package com.kamalnayan.domain.usecase

import com.kamalnayan.commons.base.BaseUseCase
import com.kamalnayan.commons.response.CatResponse
import com.kamalnayan.domain.repository.ICatRepository
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
class GetCatsUseCase @Inject constructor(private val iCatRepository: ICatRepository) :
    BaseUseCase<Unit, ApiResponse<List<CatResponse>>>() {
    override suspend fun invoke(params: Unit?): ApiResponse<List<CatResponse>> {
        return iCatRepository.getCatsList()
    }
}