package com.example.friendbalance.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.friendbalance.R
import com.example.friendbalance.components.AppButton
import com.example.friendbalance.components.AppTextField

@Composable
fun ForgetPasswordScreen() {
    var email by remember { mutableStateOf("") }
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_40_x))
                )
                Image(
                    painter = painterResource(R.drawable.friend_balance),
                    contentDescription = stringResource(R.string.app_name),
                    modifier = Modifier.size(
                        dimensionResource(R.dimen.login_app_image_size),
                        dimensionResource(R.dimen.login_app_image_size)
                    ),
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_40_x))
                )
                Box (modifier = Modifier.fillMaxWidth().padding(horizontal = dimensionResource(R.dimen.size_20_x)),){
                    Text(
                        text = stringResource(R.string.forget_password_title),
                        style = TextStyle(
                            fontSize = dimensionResource(R.dimen.font_18_x).value.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                }
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_10_x)))
                AppTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x)),
                    value = email,
                    keyboardType = KeyboardType.Email,
                    label = stringResource(R.string.email_label),
                    leadingIcon = Icons.Default.Email,
                    onValueChange = {
                        email = it
                    }
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.size_10_x)))
                AppButton(
                    label = stringResource(R.string.send_email),
                    onClick = {

                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x)),
                )
            }
        }
    }
}

