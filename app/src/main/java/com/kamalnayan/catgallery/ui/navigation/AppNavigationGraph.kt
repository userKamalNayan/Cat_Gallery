package com.kamalnayan.catgallery.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kamalnayan.catgallery.ui.screens.cats.CatsScreen

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
@Composable
fun AppNavigationGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.CATS_SCREEN) {
        composable(Routes.CATS_SCREEN) {
            CatsScreen()
        }
    }
}