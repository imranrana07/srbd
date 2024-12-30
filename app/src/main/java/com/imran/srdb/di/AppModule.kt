package com.imran.srdb.di

import com.imran.srdb.data.api.ApiCall
import com.imran.srdb.data.api.BASE_URL
import com.imran.srdb.data.home.PhotoPagingSource
import com.imran.srdb.data.home.PhotosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun retrofitClient(): ApiCall{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiCall::class.java)
    }

    @Provides
    @Singleton
    fun photoPagingSource(retrofit: ApiCall): PhotoPagingSource {
        return PhotoPagingSource(retrofit)
    }

    @Provides
    @Singleton
    fun photoPager(photoPagingSource: PhotoPagingSource): PhotosRepository {
        return PhotosRepository(photoPagingSource)
    }


}