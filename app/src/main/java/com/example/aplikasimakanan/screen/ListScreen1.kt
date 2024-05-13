package com.example.aplikasimakanan.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aplikasimakanan.appNav.TopAppBar
import com.example.aplikasimakanan.data.FoodData

data class FoodItem(
    val imageId: Int,
    val title: String,
    val description: String
)

@Composable
fun ListScreen1(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }

    val filteredFoods = remember(searchQuery) {
        FoodData.foods.filter {
            it.title.contains(searchQuery, ignoreCase = true)
        }
    }

    val filteredDesserts = remember(searchQuery) {
        FoodData.desserts.filter {
            it.title.contains(searchQuery, ignoreCase = true)
        }
    }

    Column {
        TopAppBar(
            title = "Restaurant Food",
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
                label = { Text("Cari Menu Makanan") },
                modifier = Modifier
                    .padding(end = 20.dp)
                    .fillMaxWidth()
            )

        }

        if (filteredFoods.isNotEmpty()) {
            Text(
                text = "Makanan Favorit",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, top = 15.dp)
            )

            LazyRow(contentPadding = PaddingValues(23.dp)) {
                items(filteredFoods) { food ->
                    FoodRow(food) {
                        navController.navigate("food_detail/${food.title}")
                    }
                }
            }
        }

        if (filteredDesserts.isNotEmpty()) {
            Text(
                text = "Makanan Penutup",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, bottom = 8.dp)
            )

            LazyColumn(
                modifier = Modifier.padding(bottom = 100.dp),
                contentPadding = PaddingValues(23.dp)
            ) {
                items(filteredDesserts) { dessert ->
                    FoodColumn(dessert) {
                        navController.navigate("food_detail_dessert/${dessert.title}")
                    }
                }
            }
        }
    }
}

@Composable
fun FoodRow(food: FoodItem, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onItemClick() }
            .padding(end = 15.dp)
            .fillMaxWidth()
            .background(Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = food.imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = food.title,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = food.description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun FoodColumn(food: FoodItem, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clickable { onItemClick() }
            .padding(bottom = 15.dp)
            .fillMaxWidth()
            .background(Color.White),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.White)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = food.imageId),
                contentDescription = null,
                modifier = Modifier
                    .size(90.dp)
                    .clip(shape = RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = food.title,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = food.description,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}