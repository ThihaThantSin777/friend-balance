package com.example.friendbalance.presentation.auth

import android.os.Build
import android.util.Log
import android.util.Patterns
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.friendbalance.R
import com.example.friendbalance.components.AppButton
import com.example.friendbalance.components.AppTextField
import com.example.friendbalance.navigation.Screen
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreen(navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var emailErrorMessage by remember { mutableStateOf<String?>(null) }
    val emailRequiredText = stringResource(R.string.email_is_required_text)
    val invalidEmailText = stringResource(R.string.invalid_email_format_text)


    var password by remember { mutableStateOf("") }
    var isPasswordShow by remember { mutableStateOf(false) }
    var passwordErrorMessage by remember { mutableStateOf<String?>(null) }
    val passwordRequiredText = stringResource(R.string.password_is_required_text)
    val passwordNeed8CharacterText = stringResource(R.string.password_need_8_characters_text)

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
                    text = "Welcome to the ${stringResource(R.string.app_name)}", style = TextStyle(
                        fontSize = dimensionResource(R.dimen.font_34_x).value.sp,
                        fontWeight = FontWeight.Medium,
                    )
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_30_x))
                )
                AppTextField(
                    value = email,
                    label = stringResource(R.string.email_label),
                    keyboardType = KeyboardType.Email,
                    onValueChange = {
                        email = it
                        emailErrorMessage = when {
                            it.isBlank() -> emailRequiredText
                            Patterns.EMAIL_ADDRESS.matcher(it).matches() -> invalidEmailText
                            else -> null
                        }
                        emailErrorMessage = if (email.isEmpty() || email.isBlank()) {
                            emailRequiredText
                        } else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                            invalidEmailText
                        } else {
                            null
                        }
                    },
                    leadingIcon = Icons.Default.Email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x))
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_10_x))
                )
                AppTextField(
                    value = password,
                    label = stringResource(R.string.password_label),
                    keyboardType = KeyboardType.Password,
                    onValueChange = {
                        password = it
                        passwordErrorMessage = when {
                            it.isBlank() -> passwordRequiredText
                            it.length < 8 -> passwordNeed8CharacterText
                            else -> null
                        }
                    },
                    leadingIcon = Icons.Default.Password,
                    isPasswordField = !isPasswordShow,
                    trailingIcon = {
                        IconButton(onClick = {
                            isPasswordShow = !isPasswordShow
                        }) {
                            if (isPasswordShow)
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
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x)),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Text(
                        text = stringResource(R.string.forget_password_label),
                        style = TextStyle(
                            color = colorResource(R.color.primary_dark_color),
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.clickable {
                            navHostController.navigate(Screen.ForgetPassword.route)
                        }
                    )
                }
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_30_x))
                )
                AppButton(
                    label = stringResource(R.string.login_label),
                    onClick = {
                        Log.i("emailErrorMessage", emailErrorMessage ?: "")
                        Log.i("passwordErrorMessage", passwordErrorMessage ?: "")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(R.dimen.size_20_x)),
                )
                Spacer(
                    modifier = Modifier.height(dimensionResource(R.dimen.size_10_x))
                )
                RegisterHereView(navHostController)
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

@Composable
private fun RegisterHereView(navHostController: NavHostController) {
    Row {
        Text(stringResource(R.string.do_not_have_an_account_label))
        Box(modifier = Modifier.clickable {
            navHostController.navigate(Screen.Register.route)
        }) {

            Text(
                " ${stringResource(R.string.register_here_label)}",
                style = TextStyle(
                    color = colorResource(R.color.primary_dark_color),
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}

