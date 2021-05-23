package com.example.travelcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.travelcompose.R

// Set of Material typography styles to start with

val AxiformaFamily = FontFamily(
    Font(R.font.metropolis_bold, FontWeight.Bold),
    Font(R.font.metropolis_regular)
)

val TravelTypography = Typography(
    h1 = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 48.sp
    ),
    h2 = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h3 = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Thin,
        fontSize = 16.sp
    ),
    body1 = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = AxiformaFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
)