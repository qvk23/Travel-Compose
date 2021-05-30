package com.example.travelcompose.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destination(val route: String, val icon: ImageVector) {
    Feed("Home", Icons.Outlined.Home),
    Search("Search", Icons.Outlined.Search),
    Book("Book", Icons.Outlined.FavoriteBorder),
    Person("Personal", Icons.Outlined.Person),
}