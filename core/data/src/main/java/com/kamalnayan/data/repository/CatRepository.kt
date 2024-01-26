package com.kamalnayan.data.repository

import com.kamalnayan.commons.response.CatResponse
import com.kamalnayan.data.datasource.CatRemoteDataSource
import com.kamalnayan.domain.repository.ICatRepository
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
class CatRepository @Inject constructor(private val catRemoteDataSource: CatRemoteDataSource) :
    ICatRepository {

    override suspend fun getCatsList(): ApiResponse<List<CatResponse>> {
        return catRemoteDataSource.getCats()
    }
}