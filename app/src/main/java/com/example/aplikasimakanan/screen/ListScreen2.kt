package com.example.aplikasimakanan.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.aplikasimakanan.appNav.TopAppBar
import com.example.aplikasimakanan.data.FoodData.drinks

@Composable
fun ListScreen2(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredDrinks = remember(searchQuery) {
        drinks.filter {
            it.title.contains(searchQuery, ignoreCase = true)
        }
    }
    Column {
        TopAppBar(
            title = "Restaurant Drinks",
            titleFontSize = 30.sp,
            titleColor = Color(0xFFFBFADA),
            backgroundColor = Color(0xFF436850),
            contentColor = Color.White,
            modifier = Modifier
                .height(90.dp)
        )

        Row(
            modifier = Modifier
                .padding(top = 13.dp)
        ) {
            IconButton(
                onClick = {  },
                modifier = Modifier.padding(top = 15.dp, start = 10.dp)
            ) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Cari")
            }

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Cari Menu Minuman") },
                modifier = Modifier
                    .padding(end = 20.dp)
                    .fillMaxWidth()
            )

        }

        if (filteredDrinks.isNotEmpty()) {
            LazyVerticalGrid(
                modifier = Modifier
                    .padding(start = 14.dp, end = 14.dp, top = 15.dp, bottom = 110.dp),
                columns = GridCells.Adaptive(minSize = 140.dp)
            ) {
                items(filteredDrinks.size) { index ->
                    DrinkCard(drink = filteredDrinks[index]) {
                        navController.navigate("drink_detail/${it.title}")
                    }
                }
            }
        }
    }
}

@Composable
fun DrinkCard(drink: FoodItem, onItemClick: (FoodItem) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .aspectRatio(1f)
            .clickable { onItemClick(drink) },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = drink.imageId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(3.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = drink.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Black
                )
                Text(
                    modifier = Modifier
                        .padding(bottom = 5.dp),
                    text = drink.description,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}