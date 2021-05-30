package com.example.travelcompose.model

import com.example.travelcompose.R

data class Place(
    val id: Int,
    val name: String,
    val country: String,
    val image: Int,
)

val dummyPlaces = listOf(
    Place(
        id = 1,
        name = "Mt Rinjani",
        image = R.drawable.travel_01,
        country = "Indonesia"
    ),
    Place(
        id = 2,
        name = "Mt Rinjani",
        image = R.drawable.travel_02,
        country = "Indonesia"
    ),
    Place(
        id = 3,
        name = "Mt Rinjani",
        image = R.drawable.travel_03,
        country = "Indonesia"
    ),
    Place(
        id = 4,
        name = "Mt Rinjani",
        image = R.drawable.travel_04,
        country = "Indonesia"
    ),
    Place(
        id = 5,
        name = "Mt Rinjani",
        image = R.drawable.travel_02,
        country = "Indonesia"
    ),
    Place(
        id = 6,
        name = "Mt Rinjani",
        image = R.drawable.travel_01,
        country = "Indonesia"
    ),
)
