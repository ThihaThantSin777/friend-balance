package com.example.friendbalance.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.friendbalance.presentation.auth.ForgetPasswordScreen
import com.example.friendbalance.presentation.auth.LoginScreen
import com.example.friendbalance.presentation.auth.RegisterScreen
import com.example.friendbalance.presentation.auth.ResetPasswordScreen
import com.example.friendbalance.presentation.auth.ResetPasswordSuccessScreen
import com.example.friendbalance.presentation.splash.SplashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.ForgetPassword.route) { ForgetPasswordScreen(navController) }
        composable(Screen.ResetPassword.route) { ResetPasswordScreen(navController) }
        composable(Screen.ResetPasswordSuccess.route) { ResetPasswordSuccessScreen(navController) }

    }
}