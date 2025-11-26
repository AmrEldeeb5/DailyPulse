package com.example.dailypulse

sealed class Screen(val route: String) {
    object ARTICLES : Screen("articles")
    object ABOUT_DEVICE : Screen("about_device")
}

