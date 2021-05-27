package com.example.travelcompose.model

import com.example.travelcompose.R

data class Place(
    val name: String,
    val country: String,
    val image: Int,
)

val dummyPlaces = listOf(
    Place(
        name = "Mt Rinjani",
        image = R.drawable.travel_01,
        country = "Indonesia"
    ),
    Place(
        name = "Mt Rinjani",
        image = R.drawable.travel_02,
        country = "Indonesia"
    ),
    Place(
        name = "Mt Rinjani",
        image = R.drawable.travel_03,
        country = "Indonesia"
    ),
    Place(
        name = "Mt Rinjani",
        image = R.drawable.travel_04,
        country = "Indonesia"
    ),
    Place(
        name = "Mt Rinjani",
        image = R.drawable.travel_02,
        country = "Indonesia"
    ),
    Place(
        name = "Mt Rinjani",
        image = R.drawable.travel_01,
        country = "Indonesia"
    ),
)
