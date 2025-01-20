package com.example.pureanalogylearn.ui.base.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Detail : Screen("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }

    object Country : Screen("country")
}