package com.imran.srdb.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.imran.srdb.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private lateinit var adapterAlbum: AdapterAlbum

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        adapterAlbum = AdapterAlbum()
        binding.rvPhotos.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPhotos.adapter = adapterAlbum

        adapterAlbum.addLoadStateListener {
            when (it.refresh) {
                is LoadState.Loading -> {
                    binding.progressBar.visibility = VISIBLE
                }
                is LoadState.Error -> {
                    binding.progressBar.visibility = GONE
                    Toast.makeText(activity, (it.source.refresh as LoadState.Error).error.localizedMessage, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    binding.progressBar.visibility = GONE
                }
            }
        }

        viewModel.getPhotos().observe(viewLifecycleOwner) {
            adapterAlbum.submitData(lifecycle, it)
        }
    }
}
