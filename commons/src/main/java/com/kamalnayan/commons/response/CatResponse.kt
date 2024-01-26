package com.kamalnayan.commons.response

import com.kamalnayan.commons.base.BaseResponse
import kotlinx.parcelize.Parcelize

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
@Parcelize
data class CatResponse(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
) : BaseResponse()
