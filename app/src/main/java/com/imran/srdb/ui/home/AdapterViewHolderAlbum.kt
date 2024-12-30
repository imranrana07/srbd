package com.imran.srdb.ui.home

import androidx.recyclerview.widget.RecyclerView
import com.imran.srdb.databinding.ItemPhotoAlbumBinding

class AdapterViewHolderAlbum(item: ItemPhotoAlbumBinding):RecyclerView.ViewHolder(item.root) {
    val ivAlbum = item.ivAlbum
    val tvPhotoTitle = item.tvPhotoTitle
    val tvAlbumName = item.tvAlbumName
    val tvUsername = item.tvUsername
}
