package com.kamalnayan.data.datasource

import com.kamalnayan.commons.base.BaseRemoteDataSource
import com.kamalnayan.commons.response.CatResponse
import com.kamalnayan.data.api.AppApiService
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
class CatRemoteDataSource @Inject constructor(private val appApiService: AppApiService) :
    BaseRemoteDataSource() {

    suspend fun getCats(): ApiResponse<List<CatResponse>> {
        return getResponse {
            appApiService.getGetCats()
        }
    }
}