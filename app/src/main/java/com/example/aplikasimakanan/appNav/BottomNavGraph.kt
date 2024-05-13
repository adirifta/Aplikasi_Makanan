package com.example.aplikasimakanan.appNav

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.aplikasimakanan.screen.AboutScreen
import com.example.aplikasimakanan.screen.DetailScreen
import com.example.aplikasimakanan.data.FoodData.desserts
import com.example.aplikasimakanan.data.FoodData.drinks
import com.example.aplikasimakanan.data.FoodData.foods
import com.example.aplikasimakanan.screen.ListScreen1
import com.example.aplikasimakanan.screen.ListScreen2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Daftar.route) {
        composable(route = BottomBarScreen.Daftar.route) {
            Scaffold(
                bottomBar = { BottomBar(navController = navController) }
            ) {
                ListScreen1(navController)
            }
        }
        composable(route = BottomBarScreen.Minuman.route) {
            Scaffold(
                bottomBar = { BottomBar(navController = navController) }
            ) {
                ListScreen2(navController)
            }
        }
        composable(route = BottomBarScreen.Profile.route) {
            Scaffold(
                bottomBar = { BottomBar(navController = navController) }
            ) {
                AboutScreen()
            }
        }
        composable(
            route = "food_detail/{foodTitle}",
            arguments = listOf(navArgument("foodTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val foodTitle = backStackEntry.arguments?.getString("foodTitle")
            val food = foods.find { it.title == foodTitle }
            if (food != null) {
                DetailScreen(food, navController)
            } else {
                // Handle jika tidak menemukan makanan dengan judul tertentu
            }
        }
        composable(
            route = "food_detail_dessert/{foodTitle}",
            arguments = listOf(navArgument("foodTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val foodTitle = backStackEntry.arguments?.getString("foodTitle")
            val food = desserts.find { it.title == foodTitle }
            if (food != null) {
                DetailScreen(food, navController)
            } else {
                // Handle jika tidak menemukan makanan dengan judul tertentu
            }
        }
        composable(
            route = "drink_detail/{drinkTitle}",
            arguments = listOf(navArgument("drinkTitle") { type = NavType.StringType })
        ) { backStackEntry ->
            val drinkTitle = backStackEntry.arguments?.getString("drinkTitle")
            val drink = drinks.find { it.title == drinkTitle }
            if (drink != null) {
                DetailScreen(drink, navController)
            } else {
                // Handle jika tidak menemukan minuman dengan judul tertentu
            }
        }
    }
}