package com.example

import androidx.compose.animation.Animatable
import androidx.compose.animation.animateContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.MainDestination.PLACE_ID_KEY
import com.example.travelcompose.model.Destination
import com.example.travelcompose.ui.home.PlaceDetails
import com.example.travelcompose.ui.home.TravelHomeCompose

object MainDestination {
    const val HOME_ROUTE = "home"
    const val PLACE_DETAIL_ROUTE = "place"
    const val PLACE_ID_KEY = "placeId"
}
@Composable
fun TravelComposeNavGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = MainDestination.HOME_ROUTE) {
        navigation(
            route = MainDestination.HOME_ROUTE,
            startDestination = Destination.Feed.route
        ) {
            addHomeGraph(
                onPlaceSelected = { placeId: Int, _ ->
                    navController.navigate("${MainDestination.PLACE_DETAIL_ROUTE}/$placeId")
                }
            )
        }
        composable(
            route = "${MainDestination.PLACE_DETAIL_ROUTE}/{$PLACE_ID_KEY}",
            arguments = listOf(navArgument(PLACE_ID_KEY) { type = NavType.IntType })
        ) {
            val arguments = requireNotNull(it.arguments)
            val placeId = arguments.getInt(PLACE_ID_KEY)
            PlaceDetails(
                placeId = placeId,
                upPress = { navController.navigateUp() }
            )
        }
    }
}

fun NavGraphBuilder.addHomeGraph(
    onPlaceSelected: (Int, NavBackStackEntry) -> Unit
) {
    composable(Destination.Feed.route) { from ->
        TravelHomeCompose(
            onPlaceClick = { placeId -> onPlaceSelected(placeId, from) }
        )
    }
    composable(Destination.Search.route) {

    }
    composable(Destination.Book.route) {

    }
    composable(Destination.Person.route) {

    }
}
