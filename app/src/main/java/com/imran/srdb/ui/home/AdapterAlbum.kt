package com.imran.srdb.ui.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.imran.srdb.data.home.PhotosModel
import com.imran.srdb.databinding.ItemPhotoAlbumBinding

class AdapterAlbum: PagingDataAdapter<PhotosModel,AdapterViewHolderAlbum>(DiffUtilCallBack){
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AdapterViewHolderAlbum, position: Int) {
        val item = getItem(position) as PhotosModel
        holder.tvPhotoTitle.text = item.title
        holder.tvAlbumName.text = "Album Id: ${ item.albumId.toString() }"
        holder.tvUsername.text = "User Id: ${item.id.toString()}"
        Glide.with(holder.itemView.context).load(item.url).into(holder.ivAlbum)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolderAlbum {
        val view = ItemPhotoAlbumBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AdapterViewHolderAlbum(view)
    }

    private object DiffUtilCallBack: DiffUtil.ItemCallback<PhotosModel>(){
        override fun areItemsTheSame(oldItem: PhotosModel, newItem: PhotosModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: PhotosModel, newItem: PhotosModel): Boolean {
            return oldItem.id == newItem.id
        }

    }
}