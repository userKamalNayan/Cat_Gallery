package com.kamalnayan.catgallery.ui.screens.cats

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.kamalnayan.catgallery.R
import com.kamalnayan.catgallery.ui.components.ErrorView
import com.kamalnayan.catgallery.ui.components.Loader
import com.kamalnayan.catgallery.ui.viewmodel.CatsViewModel
import com.kamalnayan.commons.response.CatResponse
import com.kamalnayan.commons.state.NetworkResult

/** @Author Kamal Nayan
Created on: 25/01/24
 **/

@Composable
fun CatsScreen(
    catsViewModel: CatsViewModel = hiltViewModel()
) {
    val catsResponseState by catsViewModel.catsResponseState.collectAsState()


    when (catsResponseState) {
        is NetworkResult.Error -> {
            ErrorView((catsResponseState as NetworkResult.Error<List<CatResponse>>).error)
        }

        is NetworkResult.Loading -> {
            Loader()
        }

        is NetworkResult.Success -> {
            LazyColumn {
                items((catsResponseState as NetworkResult.Success<List<CatResponse>>).data) { cat ->
                    CatItem(item = cat)
                }
            }
        }
    }
}

@Composable
fun CatItem(item: CatResponse) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val aspectRatio = (item.width.toFloat() / item.height.toFloat())
        val finalRatio = if (aspectRatio <= 0) (16 / 9).toFloat() else aspectRatio

        Log.d("ratio", "CatItem: $aspectRatio")
        AsyncImage(
            modifier = Modifier
                .aspectRatio(finalRatio)
                .heightIn(240.dp, 600.dp),
            model = item.url,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = R.drawable.placeholder_cat_paw)
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
    }
}