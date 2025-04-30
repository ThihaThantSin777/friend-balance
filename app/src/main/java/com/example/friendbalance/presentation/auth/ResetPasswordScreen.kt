package com.example.friendbalance.presentation.auth

import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.friendbalance.R
import com.example.friendbalance.components.AppButton
import com.example.friendbalance.components.AppTextField
import com.example.friendbalance.navigation.Screen
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ResetPasswordScreen(navHostController: NavHostController) {
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isNewPasswordShow by remember { mutableStateOf(false) }
    var isConfirmPasswordShow by remember { mutableStateOf(false) }
    Scaffold { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
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
                Text(
                    text = "Reset Password to the ${stringResource(R.string.app_name)}",
                    style = TextStyle(
                        fontSize = dimensionResource(R.dimen.font_34_x).value.sp,
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_30_x))
                )
                AppTextField(
                    value = newPassword,
                    label = stringResource(R.string.new_password_label),
                    keyboardType = KeyboardType.Password,
                    onValueChange = {
                        newPassword = it
                    },
                    leadingIcon = Icons.Default.Password,
                    isPasswordField = !isNewPasswordShow,
                    trailingIcon = {
                        IconButton(onClick = {
                            isNewPasswordShow = !isNewPasswordShow
                        }) {
                            if (isNewPasswordShow)
                                Icon(Icons.Default.Visibility, contentDescription = null)
                            else
                                Icon(Icons.Default.VisibilityOff, contentDescription = null)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x))
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_10_x))
                )
                AppTextField(
                    value = confirmPassword,
                    label = stringResource(R.string.confirm_password_label),
                    keyboardType = KeyboardType.Password,
                    onValueChange = {
                        confirmPassword = it
                    },
                    leadingIcon = Icons.Default.Password,
                    isPasswordField = !isConfirmPasswordShow,
                    trailingIcon = {
                        IconButton(onClick = {
                            isConfirmPasswordShow = !isConfirmPasswordShow
                        }) {
                            if (isConfirmPasswordShow)
                                Icon(Icons.Default.Visibility, contentDescription = null)
                            else
                                Icon(Icons.Default.VisibilityOff, contentDescription = null)
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x))
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_30_x))
                )
                AppButton(
                    label = stringResource(R.string.reset_label),
                    onClick = {
                        navHostController.navigate(Screen.ResetPasswordSuccess.route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x)),
                )
                Spacer(
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "@${LocalDate.now().year} ${stringResource(R.string.app_name)}. All Right Reserved."
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_20_x))
                )

            }
        }
    }
}


