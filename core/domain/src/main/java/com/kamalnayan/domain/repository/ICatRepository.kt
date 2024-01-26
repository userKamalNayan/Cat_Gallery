package com.kamalnayan.domain.repository

import com.kamalnayan.commons.response.CatResponse
import com.skydoves.sandwich.ApiResponse

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
interface ICatRepository {
    suspend fun getCatsList(): ApiResponse<List<CatResponse>>
}