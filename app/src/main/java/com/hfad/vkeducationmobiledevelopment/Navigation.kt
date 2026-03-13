package com.hfad.vkeducationmobiledevelopment

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object AppList : Screen("app_list")
    object AppDetails : Screen("app_details")
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AppList.route,
        modifier = modifier
    ) {
        composable(Screen.AppList.route) {
            AppListScreen(
                onAppClick = { app ->
                    navController.navigate(Screen.AppDetails.route)
                }
            )
        }

        composable(Screen.AppDetails.route) {
            AppDetailsScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
