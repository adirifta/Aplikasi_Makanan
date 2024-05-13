package com.example.aplikasimakanan.appNav

import com.example.aplikasimakanan.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int,
    val icon_focused: Int,
) {
    object Daftar: BottomBarScreen(
        route = "daftar",
        title = "Makanan",
        icon = R.drawable.ic_bottom_daftar,
        icon_focused = R.drawable.ic_bottom_daftar_focused
    )
    object Minuman: BottomBarScreen(
        route = "minuman",
        title = "Minuman",
        icon = R.drawable.ic_bottom_minuman,
        icon_focused = R.drawable.ic_bottom_minuman_focused
    )
    object Profile: BottomBarScreen(
        route = "about",
        title = "About",
        icon = R.drawable.ic_bottom_about,
        icon_focused = R.drawable.ic_bottom_about_focused
    )
}
