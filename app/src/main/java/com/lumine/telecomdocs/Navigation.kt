package com.lumine.telecomdocs

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lumine.telecomdocs.ui.screens.Calculator
import com.lumine.telecomdocs.ui.screens.Home
import com.lumine.telecomdocs.ui.screens.Result

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Calculator : Screen(route = "calculator")
    object Result : Screen(route = "result")
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }
        composable(route = Screen.Calculator.route) {
            Calculator(navController = navController)
        }
        composable(route = Screen.Result.route) {
            Result(navController = navController)
        }
    }
}