package com.kamalnayan.catgallery.ui.viewmodel

import androidx.lifecycle.viewModelScope
import com.kamalnayan.commons.base.BaseViewModel
import com.kamalnayan.commons.response.CatResponse
import com.kamalnayan.commons.state.NetworkResult
import com.kamalnayan.domain.usecase.GetCatsUseCase
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
@HiltViewModel
class CatsViewModel @Inject constructor(private val getCatsUseCase: GetCatsUseCase) :
    BaseViewModel() {

    init {
        getCats()
    }

    private val _catsResponseState: MutableStateFlow<NetworkResult<List<CatResponse>>> =
        MutableStateFlow(NetworkResult.Loading())
    val catsResponseState: StateFlow<NetworkResult<List<CatResponse>>> = _catsResponseState


    fun getCats() {
        viewModelScope.launch {
            val response = getCatsUseCase()
            response.suspendOnSuccess {
                _catsResponseState.tryEmit(NetworkResult.Success(this.data))
            }
                .onFailure {
                    _catsResponseState.tryEmit(NetworkResult.Error(this))
                }
        }
    }
}