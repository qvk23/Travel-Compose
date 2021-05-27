package com.example

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.travelcompose.model.Destination
import com.example.travelcompose.ui.home.TravelHomeCompose

@Composable
fun TravelComposeNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Destination.Home.title) {
        composable(Destination.Home.title) {
            TravelHomeCompose()
        }
    }
}