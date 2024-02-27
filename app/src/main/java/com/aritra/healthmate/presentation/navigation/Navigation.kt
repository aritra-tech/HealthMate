package com.aritra.healthmate.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import com.aritra.healthmate.presentation.screens.CalorieTrackingScreen
import com.aritra.healthmate.presentation.screens.HomeScreen
import com.aritra.healthmate.presentation.screens.WaterTrackingScreen

@Composable
fun Navigation(
    navController: NavHostController
) {
    SwipeDismissableNavHost(
        navController = navController,
        startDestination = "home_screen"
    ) {
        composable("home_screen") {
            HomeScreen { selected ->
                when(selected) {
                    "Add Water" -> {
                        navController.navigate("water_tracking_screen")
                    }

                    "Add Calories" -> {
                        navController.navigate("calorie_tracking_screen")
                    }
                }
            }
        }

        composable("water_tracking_screen") {
            WaterTrackingScreen()
        }

        composable("calorie_tracking_screen") {
            CalorieTrackingScreen()
        }
    }
}