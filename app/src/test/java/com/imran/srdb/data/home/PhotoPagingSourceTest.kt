package com.imran.srdb.data.home

import com.imran.srdb.data.api.ApiCall
import org.junit.Before
import org.junit.Rule
import javax.inject.Inject

@HiltAndroidTest
class PhotoPagingSourceTest {
    @Inject lateinit var apiCall: ApiCall
    @Inject lateinit var repository: PhotosRepository

    @get:Rule
    val hiltRule = HiltAndroidRule(this)
    private lateinit var photoPagingSource: PhotoPagingSource

    @Before
    fun setup(){
        hiltRule.inject()
        photoPagingSource = PhotoPagingSource(apiCall)
    }
}