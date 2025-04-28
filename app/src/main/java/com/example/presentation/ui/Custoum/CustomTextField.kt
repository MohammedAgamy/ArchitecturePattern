package com.example.presentation.ui.Custoum

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    error: String?,
    icon: Int,
    keyboardType: KeyboardType = KeyboardType.Text
) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, color = Color.Gray) },
        isError = error != null,
        leadingIcon = {
            Icon(
                painter = painterResource(icon),
                contentDescription = "Icon",
                tint = Color.Gray
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth().height(45.dp)
            .padding(horizontal = 10.dp),

        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Gray,
            focusedContainerColor = White,
            disabledContainerColor = White,
            unfocusedLabelColor = White,
            unfocusedContainerColor = White,
            disabledLabelColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            focusedIndicatorColor = if (error != null) Red else Color.Gray,
            unfocusedIndicatorColor = Color.Gray,
            cursorColor = Color.Gray,
            unfocusedTextColor = Color.Gray,
            errorContainerColor = Red,
        ),

        )
    error?.let {
        Text(
            it,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier.padding(start = 12.dp)
        )
    }

}

