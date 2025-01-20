package com.example.pureanalogylearn.ui.base.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pureanalogylearn.ui.country.CountryRoute
import com.example.pureanalogylearn.ui.home.DetailsScreen
import com.example.pureanalogylearn.ui.home.HomeRoute

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeRoute(
                onNavigateToDetails = { id ->
                    navController.navigate(Screen.Detail.createRoute(id))
                },
                onNavigateToCountry = {
                    navController.navigate(Screen.Country.route)
                },
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: 0
            DetailsScreen(
                id = id,
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(route = Screen.Country.route) {
            CountryRoute()
        }
    }
}