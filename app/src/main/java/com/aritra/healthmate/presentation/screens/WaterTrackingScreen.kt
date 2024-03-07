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
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text

@Composable
fun WaterTrackingScreen() {

    var waterProgress by rememberSaveable {
        mutableFloatStateOf(0f)
    }

    val animateProgress by animateFloatAsState(
        targetValue = waterProgress,
        label = "Water Progress",
        animationSpec = tween(600)
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
                text = "Water",
                style = TextStyle(fontWeight = Medium, fontSize = 20.sp)
            )

            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Liters",
                style = TextStyle(color = Color(0xFF949aa1), fontSize = 14.sp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                String.format("%.1f L", animateProgress),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                modifier = Modifier
                    .size(ButtonDefaults.DefaultButtonSize),
                colors = ButtonDefaults.primaryButtonColors(
                    backgroundColor = Color(0xFF949aa1)
                ),
                onClick = {
                    waterProgress += 1f
                }
            ) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = Icons.Rounded.Add,
                    contentDescription = null,
                    tint = Color(0xFFf6f6f6)
                )
            }
        }

        CircularProgressIndicator(
            startAngle = 270f,
            modifier = Modifier
                .fillMaxSize()
                .padding(3.dp),
            strokeWidth = 10.dp,
            progress = animateProgress / 10,
            indicatorColor = Color(0xFF339aff),
            trackColor = Color.LightGray
        )
    }
}