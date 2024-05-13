package com.example.aplikasimakanan.appNav

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aplikasimakanan.R

@Composable
fun TopAppBarDetail(navController: NavController) {
    Row(
        modifier = Modifier
            .background(Color(0xFF436850))
            .padding(top = 30.dp)
            .height(60.dp)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
            contentDescription = stringResource(id = R.string.back),
            modifier = Modifier
                .clickable {
                    navController.navigateUp()
                }
                .padding(16.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "Detail Restaurant",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 25.sp, color = Color.White),
            modifier = Modifier.weight(1f)
                .padding(vertical = 16.dp)
        )
    }
}