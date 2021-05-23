package com.example.travelcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelcompose.ui.theme.TravelComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    TravelCompose()
                }
            }
        }
    }
}

@Composable
fun TravelCompose() {
    Column(modifier = Modifier.padding(24.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        TravelCaption()
        Spacer(modifier = Modifier.height(20.dp))
        TravelChips()
        Spacer(modifier = Modifier.height(20.dp))
        TravelPlaces()
    }
}

@Composable
fun TravelCaption() {
    val definition = rememberInfiniteTransition()
    val state by definition.animateFloat(
        initialValue = 0f,
        targetValue = 45f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    val position by definition.animateFloat(
        initialValue = 0f,
        targetValue = 15f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000),
            repeatMode = RepeatMode.Reverse
        )
    )
    val textId = "inlineContent"
    val text = buildAnnotatedString {
        append("Where do you like to go?")
        appendInlineContent(textId, "[Text]")
    }
    val inlineContent = mapOf(
        textId to InlineTextContent(
            Placeholder(
                width = 36.sp,
                height = 32.sp,
                placeholderVerticalAlign = PlaceholderVerticalAlign.AboveBaseline
            )
        ) {
            Row {
                Spacer(modifier = Modifier.width(4.dp))
                Image(
                    painter = painterResource(id = R.drawable.waving_hand),
                    contentDescription = null,
                    modifier = Modifier
                        .graphicsLayer {
                            translationX = position
                            rotationZ = state
                        }
                )
            }
        }
    )
    Text(
        modifier = Modifier.layoutId("text"),
        style = MaterialTheme.typography.h1,
        inlineContent = inlineContent,
        text = text,
    )
}

@Composable
fun TravelChips() {
    val dummyList = listOf(
        "Place",
        "Culinary",
        "Culture",
        "Beautiful",
        "Beach",
        "Place",
        "Culinary",
        "Culture",
        "Beautiful",
        "Beach",
    )
    val (pos, onIndexChange) = remember { mutableStateOf(0) }
    Row(
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    ) {
        dummyList.forEachIndexed { index, content ->
            val padding = if (index == 0) 0.dp else 16.dp
            Spacer(modifier = Modifier.width(padding))
            TravelChipItem(
                chip = content,
                isSelected = index == pos,
                onChipSelected = { onIndexChange(index) }
            )
        }
    }
}

@Composable
fun TravelChipItem(
    chip: String,
    isSelected: Boolean,
    onChipSelected: () -> Unit
) {
    val colorBackground = animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.primary
        else MaterialTheme.colors.primaryVariant
    )
    val textColor = animateColorAsState(
        targetValue = if (isSelected) MaterialTheme.colors.secondary
        else MaterialTheme.colors.primary
    )
    Card(
        shape = RoundedCornerShape(percent = 50),
        backgroundColor = colorBackground.value,
        modifier = Modifier.clickable {
            onChipSelected()
        }
    ) {
        Text(
            text = chip,
            color = textColor.value,
            modifier = Modifier
                .padding(start = 26.dp, end = 26.dp, top = 12.dp, bottom = 12.dp)

        )
    }
}

@Composable
fun TravelPlaces() {
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
    LazyRow {
        items(dummyPlaces) { place ->
            ItemPlace(
                place = place,
                modifier = Modifier
                    .fillParentMaxSize(0.8f)
                    .padding(10.dp)
            )
        }
    }
}

@Composable
fun ItemPlace(
    place: Place,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = place.image),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        ItemDescription(place = place)
    }

}

@Composable
fun ItemDescription(
    place: Place,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        backgroundColor = MaterialTheme.colors.secondary,
        modifier = modifier
            .wrapContentHeight()
            .padding(10.dp)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column {
                Text(text = place.name, style = MaterialTheme.typography.h3)
                Text(text = place.country, style = MaterialTheme.typography.subtitle2)
            }
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            )
        }

    }
}

data class Place(
    val name: String,
    val country: String,
    val image: Int,
)


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ItemDescription(
        Place(
            name = "Mt Rinjani",
            image = R.drawable.travel_01,
            country = "Indonesia"
        ),
        modifier = Modifier
    )
}