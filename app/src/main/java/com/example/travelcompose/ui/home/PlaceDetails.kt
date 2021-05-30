package com.example.travelcompose.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.travelcompose.model.Place
import com.example.travelcompose.model.dummyPlaces
import com.example.travelcompose.ui.theme.TravelComposeTheme

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PlaceDetails(
    placeId: Int,
    upPress: () -> Unit
) {
    val place = dummyPlaces[placeId - 1]

    Box(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberScrollState(0)
        PlaceImage(
            place.image
        )
        UpButton(upPress)
        Body(place, scrollState)
    }
}

@Composable
fun Body(
    place: Place,
    scrollState: ScrollState
) {
    Column {
        Spacer(
            modifier = Modifier
                .height(350.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topEnd = 24.dp, topStart = 24.dp))
                .background(MaterialTheme.colors.secondary)
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = place.name, style = MaterialTheme.typography.h2)
                Text(text = place.country, style = MaterialTheme.typography.subtitle2)
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "Description", style = MaterialTheme.typography.h3)
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut tempus, sem vitae convallis imperdiet, lectus nunc pharetra diam, ac rhoncus quam eros eu risus. Nulla pulvinar condimentum erat, pulvinar tempus turpis blandit ut. Etiam sed ipsum sed lacus eleifend hendrerit eu quis quam. Etiam ligula eros, finibus vestibulum tortor ac, ultrices accumsan dolor. Vivamus vel nisl a libero lobortis posuere. Aenean facilisis nibh vel ultrices bibendum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Suspendisse ac est vitae lacus commodo efficitur at ut massa. Etiam vestibulum sit amet sapien sed varius. Aliquam non ipsum imperdiet, pulvinar enim nec, mollis risus. Fusce id tincidunt nisl.",
                    style = MaterialTheme.typography.body2,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                )
            }
            Button(
                onClick = { },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Visit Place",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.secondary
                )
            }
        }

    }

}

@Composable
fun PlaceImage(
    image: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}


@Composable
fun UpButton(
    upPress: () -> Unit
) {
    Column {
        Spacer(
            modifier = Modifier
                .height(20.dp)
                .fillMaxWidth()
        )
        IconButton(
            onClick = upPress,
        ) {
            Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
        }
    }
}

@Preview
@Composable
private fun UpButtonPreview() {
    TravelComposeTheme {
        PlaceDetails(
            1,
            { }
        )
    }
}
