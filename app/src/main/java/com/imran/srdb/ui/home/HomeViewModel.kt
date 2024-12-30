package com.imran.srdb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.imran.srdb.data.home.PhotosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val photosRepository: PhotosRepository): ViewModel() {
    fun getPhotos() = photosRepository.getPhotos().asLiveData()

}