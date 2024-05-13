package com.example.aplikasimakanan.appNav

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    titleFontSize: TextUnit = 20.sp,
    titleColor: Color = Color.White,
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = MaterialTheme.colors.onPrimary
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                fontSize = titleFontSize,
                color = titleColor,
                modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth(),
            )
        },
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        modifier = modifier
    )
}