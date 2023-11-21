package com.moltaqa.composeapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.moltaqa.composeapplication.ui.theme.Purple200

@Composable
fun GymsScreen() {
    LazyColumn(){
        items(listOfGyms){ gym ->
            GymItem(gym)
        }
    }
 /*   Column(Modifier.verticalScroll(rememberScrollState())) {
        listOfGyms.forEach {
            GymItem(it)
        }
    }*/
}

@Composable
fun GymItem(gym: Gym) {
    Card(elevation = 4.dp, modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            GymIcon(Icons.Filled.Place, Modifier.weight(0.15f))
            GymDetails(gym, Modifier.weight(0.85f))
        }
    }
}

@Composable
fun GymDetails(gym: Gym, modifier: Modifier) {
    Column(horizontalAlignment = Alignment.Start, modifier = modifier) {

        Text(
            text = gym.name,
            color = Purple200,
            style = MaterialTheme.typography.h6
        )

        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = gym.address,
                style = MaterialTheme.typography.body2,
            )
        }

    }
}

@Composable
fun GymIcon(place: ImageVector, modifier: Modifier) {
    Image(
        imageVector = place,
        contentDescription = "Gym Icon",
        modifier = modifier,
        colorFilter = ColorFilter.tint(
            Color.DarkGray
        )
    )
}
