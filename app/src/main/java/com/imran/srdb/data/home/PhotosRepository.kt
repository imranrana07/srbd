package com.imran.srdb.data.home

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PhotosRepository @Inject constructor(private val photoPagingSource: PhotoPagingSource) {

    fun getPhotos(): Flow<PagingData<PhotosModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {photoPagingSource}
            ).flow
    }

}