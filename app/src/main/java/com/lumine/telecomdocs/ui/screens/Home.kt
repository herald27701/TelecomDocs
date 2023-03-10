package com.lumine.telecomdocs.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lumine.telecomdocs.R
import com.lumine.telecomdocs.Screen
import kotlinx.coroutines.launch

@Composable
fun Home(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopBar(
                title = R.string.app_name,
                icon1 = Icons.Default.Menu,
                onClick1 = { scope.launch { scaffoldState.drawerState.open() } },
                icon2 = Icons.Default.Search,
                onClick2 = { /*TODO*/ }
            )
        },
        drawerContent = {},
        content = { paddingValues ->
            LazyColumn(contentPadding = paddingValues) {
                item {
                    HomeItem(
                        text = R.string.app_name,
                        icon = R.drawable.ic_launcher_foreground,
                        onClick = { navController.navigate(route = Screen.Calculator.route) }
                    )
                }
            }
        }
    )
}

@Composable
fun TopBar(
    title: Int,
    icon1: ImageVector,
    onClick1: () -> Unit,
    icon2: (ImageVector)?,
    onClick2: (() -> Unit)?
) {
    TopAppBar(
        title = { Text(text = stringResource(id = title)) },
        navigationIcon = {
            IconButton(onClick = onClick1) {
                Icon(imageVector = icon1, contentDescription = null)
            }
        },
        actions = {
            if (onClick2 != null) {
                IconButton(onClick = onClick2) {
                    if (icon2 != null) {
                        Icon(imageVector = icon2, contentDescription = null)
                    }
                }
            }
        }
    )
}

@Composable
fun HomeItem(modifier: Modifier = Modifier, text: Int, icon: Int, onClick: () -> Unit = {}) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = ImageVector.vectorResource(id = icon), contentDescription = null)
        Text(text = stringResource(id = text))
    }
    Divider()
}