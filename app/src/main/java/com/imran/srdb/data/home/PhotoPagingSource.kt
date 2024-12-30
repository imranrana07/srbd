package com.imran.srdb.data.home

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.imran.srdb.data.api.ApiCall
import com.imran.srdb.data.api.ApiException
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PhotoPagingSource @Inject constructor(private val retrofit: ApiCall): PagingSource<Int, PhotosModel>() {
    override fun getRefreshKey(state: PagingState<Int, PhotosModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PhotosModel> {
        // need to merge album id and userId with respective name
        return try {
            val pageNo = params.key ?: 1
            val response = retrofit.getPhotos(pageNo)
            LoadResult.Page(
                data = response.body()!!,
                prevKey = if (pageNo == 1) null else pageNo - 1,
                nextKey = if (response.body()!!.isEmpty()) null else pageNo + 1
            )
        }catch (e: IOException){
            LoadResult.Error(e)
        }catch (e: HttpException){
            LoadResult.Error(e)
        }catch (e: ApiException){
            LoadResult.Error(e)
        }
    }
}