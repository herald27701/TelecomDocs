package com.lumine.telecomdocs.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.lumine.telecomdocs.R
import com.lumine.telecomdocs.Screen

@Composable
fun Calculator(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                title = R.string.calculator,
                icon1 = Icons.Default.ArrowBack,
                onClick1 = { navController.navigate(route = Screen.Home.route) },
                icon2 = Icons.Default.Info,
                onClick2 = { navController.navigate(route = Screen.Result.route) }
            )
        },
        content = { paddingValues ->
            LazyColumn(contentPadding = paddingValues) {
            }
        }
    )
}