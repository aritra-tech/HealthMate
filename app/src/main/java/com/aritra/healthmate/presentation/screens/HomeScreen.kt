package com.aritra.healthmate.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Card
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import com.aritra.healthmate.R
import com.aritra.healthmate.presentation.model.HomeListItems

@Composable
fun HomeScreen(
    onClick: (id: String) -> Unit
) {

    val scalingLazyList = rememberScalingLazyListState()

    val homeItems = remember {
        mutableStateListOf(
            HomeListItems(
                icon = R.drawable.stats,
                text = "Stats"
            ),
            HomeListItems(
                icon = R.drawable.water,
                text = "Add Water"
            ),
            HomeListItems(
                icon = R.drawable.calorie,
                text = "Add Calories"
            )
        )
    }

    Scaffold(
        positionIndicator = {
            PositionIndicator(scalingLazyListState = scalingLazyList)
        },
        vignette = { Vignette(vignettePosition = VignettePosition.TopAndBottom) }
    ) {
        ScalingLazyColumn(
            state = scalingLazyList,
            scalingParams = ScalingLazyColumnDefaults.scalingParams(
                edgeScale = 0.5f,
                minTransitionArea = 0.6f,
                maxTransitionArea = 0.7f
            )
        ) {
            homeItems.forEachIndexed { index, homeListItems ->
                item(key = homeListItems.text) {
                    HomeCards(
                        modifier = Modifier.padding(
                            top = if (index == 0) {
                                24.dp
                            } else {
                                8.dp
                            }
                        ),
                        homeListItems.icon, homeListItems.text,
                        onClick = {
                            onClick(homeListItems.text)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HomeCards(
    modifier: Modifier = Modifier,
    icon: Int,
    title: String,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(painter = painterResource(id = icon), contentDescription = "")
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = title)
        }
    }
}
