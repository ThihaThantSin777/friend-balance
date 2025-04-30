package com.example.friendbalance.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.friendbalance.R
import com.example.friendbalance.components.LottieSuccessAnimation
import com.example.friendbalance.navigation.Screen
import kotlinx.coroutines.delay

@Composable
fun ResetPasswordSuccessScreen(navHostController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(2000)
        navHostController.navigate(Screen.Login.route) {
            popUpTo(0) { inclusive = true }
        }
    }
    Scaffold { innerPadding ->

        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_20_x))
                )
                LottieSuccessAnimation()
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_30_x))
                )
                Text(
                    text = stringResource(R.string.reset_password_success_label), style = TextStyle(
                        fontSize = dimensionResource(R.dimen.font_26_x).value.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_30_x))
                )
            }
        }

    }
}