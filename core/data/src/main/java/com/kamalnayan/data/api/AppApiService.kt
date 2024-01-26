package com.kamalnayan.data.api

import com.kamalnayan.commons.response.CatResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
interface AppApiService {

    @GET("v1/images/search?limit=30")
    suspend fun getGetCats(): ApiResponse<List<CatResponse>>
}