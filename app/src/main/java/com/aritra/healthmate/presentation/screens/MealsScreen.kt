package com.aritra.healthmate.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.wear.compose.foundation.lazy.ScalingLazyColumn
import androidx.wear.compose.foundation.lazy.ScalingLazyColumnDefaults
import androidx.wear.compose.foundation.lazy.rememberScalingLazyListState
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.PositionIndicator
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import com.aritra.healthmate.R
import com.aritra.healthmate.presentation.model.MealItems

@Composable
fun MealsScreen() {

    val lazyList = rememberScalingLazyListState()

    val mealsOptions = remember {
        mutableStateListOf(
            MealItems(
                image = R.drawable.breakfast,
                text = "Breakfast"
            ),
            MealItems(
                image = R.drawable.lunch,
                text = "Lunch"
            ),
            MealItems(
                image = R.drawable.dinner,
                text = "Dinner"
            )
        )
    }

    Scaffold(
        positionIndicator = {
            PositionIndicator(scalingLazyListState = lazyList)
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        }
    ) {
        ScalingLazyColumn(
            state = lazyList,
            scalingParams = ScalingLazyColumnDefaults.scalingParams(
                edgeScale = 0.5f,
                minTransitionArea = 0.6f,
                maxTransitionArea = 0.7f
            )
        ) {
            mealsOptions.forEachIndexed { index, mealsListOption ->
                item(key = mealsListOption.text) {
                    MealsChip(
                        image = mealsListOption.image,
                        text = mealsListOption.text,
                        onClick = {

                        }
                    )
                }
            }
        }
    }
}

@Composable
fun MealsChip(
    modifier: Modifier = Modifier,
    image: Int,
    text: String,
    onClick: () -> Unit
) {
    Chip(
        modifier = modifier.fillMaxWidth(),
        label = {
            Text(text = text)
        },
        icon = {
            Icon(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier
                    .size(ChipDefaults.SmallIconSize)
                    .background(Color.Transparent)
            )
        },
        onClick = {
            onClick()
        }
    )
}