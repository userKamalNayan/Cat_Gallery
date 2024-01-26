package com.kamalnayan.catgallery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.kamalnayan.catgallery.R
import com.kamalnayan.catgallery.ui.theme.Purple40

/** @Author Kamal Nayan
Created on: 25/01/24
 **/

@Composable
fun Loader() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(16.dp), color = Purple40
        )
    }
}

@Composable
fun ErrorView(errorText: String) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.error_crying_cat),
            contentDescription = "",
            modifier = Modifier
                .heightIn(max = 200.dp)
                .aspectRatio(1f / 1f)

        )
        Spacer(modifier = Modifier.height(25.dp))

        Text(text = errorText, Modifier.padding(16.dp), textAlign = TextAlign.Justify)
    }
}
