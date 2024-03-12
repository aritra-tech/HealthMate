package com.aritra.healthmate.presentation.screens

import android.text.format.DateFormat
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
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.ButtonDefaults
import androidx.wear.compose.material.CircularProgressIndicator
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Scaffold
import androidx.wear.compose.material.Text
import androidx.wear.compose.material.TimeText
import androidx.wear.compose.material.TimeTextDefaults
import androidx.wear.compose.material.Vignette
import androidx.wear.compose.material.VignettePosition
import com.aritra.healthmate.R
import java.util.Locale

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

    Scaffold(
        timeText = {
            TimeText(
                timeSource = TimeTextDefaults.timeSource(
                    DateFormat.getBestDateTimePattern(Locale.getDefault(), "hh:mm")
                )
            )
        },
        vignette = {
            Vignette(vignettePosition = VignettePosition.TopAndBottom)
        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Spacer(modifier = Modifier.height(30.dp))

                Text(
                    text = stringResource(R.string.water),
                    fontSize = 10.sp
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    String.format("%.1f ", animateProgress),
                    textAlign = TextAlign.Center,
                    fontSize = 25.sp,
                    fontWeight = Medium
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    stringResource(R.string._10_0_l),
                    textAlign = TextAlign.Center,
                    fontSize = 12.sp,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    modifier = Modifier
                        .size(ButtonDefaults.DefaultButtonSize),
                    colors = ButtonDefaults.primaryButtonColors(
                        backgroundColor = Color(0xFF5500ff)
                    ),
                    onClick = {
                        waterProgress += 1f
                    },
                    enabled = waterProgress < 10f
                ) {
                    if (waterProgress < 10) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = Icons.Rounded.Add,
                            contentDescription = null,
                            tint = Color(0xFFf6f6f6)
                        )
                    } else {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            imageVector = Icons.Default.Check,
                            contentDescription = null,
                            tint = Color(0xFFf6f6f6)
                        )
                    }
                }
            }

            CircularProgressIndicator(
                startAngle = 295.5f,
                endAngle = 245.4f,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(3.dp),
                strokeWidth = 5.dp,
                progress = animateProgress / 10,
                indicatorColor = Color(0xFF339aff),
                trackColor = Color.White
            )
        }
    }
}