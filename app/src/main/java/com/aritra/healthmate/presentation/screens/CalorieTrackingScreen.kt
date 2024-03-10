package com.aritra.healthmate.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.aritra.healthmate.R

@Composable
fun CalorieTrackingScreen() {

    var calorieProgress by rememberSaveable {
        mutableFloatStateOf(0f)
    }

    val animateProgress by animateFloatAsState(
        targetValue = calorieProgress,
        label = "Calorie Progress",
        animationSpec = tween(500)
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(R.string.calories),
                style = TextStyle(fontSize = 10.sp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                String.format("%.1f ", animateProgress),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                stringResource(R.string._100_kcal),
                textAlign = TextAlign.Center,
                fontSize = 12.sp,
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .size(ButtonDefaults.DefaultButtonSize),
                colors = ButtonDefaults.primaryButtonColors(
                    backgroundColor = Color(0xFF80ff80)
                ),
                onClick = {
                    calorieProgress += 10f
                },
                enabled = calorieProgress < 100f
            ) {
                if (calorieProgress < 100) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Rounded.Add,
                        contentDescription = null,
                        tint = Color.Black
                    )
                } else {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                    )
                }
            }
        }

        CircularProgressIndicator(
            startAngle = 270f,
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            strokeWidth = 10.dp,
            progress = animateProgress / 100,
            indicatorColor = Color(0xFF6bb300),
            trackColor = Color.White
        )
    }

}