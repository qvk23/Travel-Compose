package com.example.travelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.TravelComposeNavGraph
import com.example.travelcompose.model.Destination
import com.example.travelcompose.ui.theme.PrimaryColor
import com.example.travelcompose.ui.theme.TravelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelComposeTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        bottomBar = {
                            TravelBottomNavigation(navController)
                        },
                    ) {
                        TravelComposeNavGraph(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun TravelBottomNavigation(
    navController: NavController
) {
    val section = remember { Destination.values() }
    val routes = remember {
        section.map { it.route }
    }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute in routes) {
        val dummyListIcon = listOf(
            Destination.Feed,
            Destination.Search,
            Destination.Book,
            Destination.Person,
        )
        val (currentSection, onItemSelected) = remember {
            mutableStateOf(section.first { it.route == currentRoute })
        }
        Row(modifier = Modifier.padding(24.dp)) {
            dummyListIcon.forEach { section ->
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    TravelIconBottomNav(
                        item = section,
                        isSelected = section == currentSection,
                        onItemSelected = {
                            navController.navigate(section.route)
                            onItemSelected(section)
                        },
                    )
                }
            }
        }
    }
}

@Composable
fun TravelIconBottomNav(
    item: Destination,
    isSelected: Boolean,
    onItemSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    Crossfade(
        targetState = isSelected,
        animationSpec = tween(5, easing = LinearEasing)
    ) {
        if (it) {
            Text(
                text = item.route,
                color = MaterialTheme.colors.primary,
                modifier = modifier.withSelection()
            )
        } else {
            Icon(
                imageVector = item.icon,
                contentDescription = null,
                modifier = modifier
                    .clickable {
                        onItemSelected()
                    }
                    .size(28.dp)
            )
        }
    }
}

private fun Modifier.withSelection() = drawWithContent {
    drawContent()

    val radius = 4.dp.value * density
    val dotCenter = Offset(x = size.center.x, y = size.height * 1.2f)

    drawCircle(color = PrimaryColor, radius, dotCenter)
}
