package com.lumine.telecomdocs.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.lumine.telecomdocs.R
import com.lumine.telecomdocs.Screen

@Composable
fun Result(navController: NavController) {
    Scaffold(
        topBar = {
            TopBar(
                title = R.string.info,
                icon1 = Icons.Default.ArrowBack,
                onClick1 = { navController.navigate(route = Screen.Calculator.route) },
                icon2 = null,
                onClick2 = null
            )
        },
        content = { paddingValues ->
            LazyColumn(contentPadding = paddingValues) {
            }
        }
    )
}