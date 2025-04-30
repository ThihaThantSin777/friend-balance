package com.example.friendbalance.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.friendbalance.R

@Composable
fun AppButton(label: String, onClick: () -> Unit, modifier: Modifier) {
    Button(
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.primary_dark_color)
        ),
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(text = label)
    }
}