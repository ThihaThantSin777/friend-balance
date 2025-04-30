package com.example.friendbalance.navigation

sealed class Screen(val route: String) {
    ///Auth
    data object Splash : Screen("splash")
    data object Login : Screen("login")
    data object Register : Screen("register")
    data object ForgetPassword : Screen("forget_password")
}