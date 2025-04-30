package com.example.friendbalance.presentation.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.friendbalance.R
import com.example.friendbalance.navigation.Screen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navHostController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navHostController.navigate(Screen.Login.route) {
            popUpTo(0) { inclusive = true }
        }
    }
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(R.drawable.friend_balance),
                    contentDescription = stringResource(R.string.app_name),
                )
            }
        }
    }
}