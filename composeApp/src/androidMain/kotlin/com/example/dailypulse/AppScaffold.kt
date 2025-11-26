package com.example.dailypulse

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.dailypulse.articles.ArticlesViewModel
import com.example.dailypulse.screens.AboutScreen
import com.example.dailypulse.screens.ArticlesScreen

@Composable
fun AppScaffold(articlesViewModel: ArticlesViewModel){
    val navController = rememberNavController()

    AppNavHost(
        navController = navController,
        modifier = Modifier.fillMaxSize(),
        articlesViewModel
    )
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier,
    articlesViewModel: ArticlesViewModel)
{
    NavHost(
        navController = navController,
        startDestination = Screen.ARTICLES.route,
        modifier = modifier
    ) {
        composable(Screen.ARTICLES.route) {
            ArticlesScreen(
                onAboutClick = { navController.navigate(Screen.ABOUT_DEVICE.route) },
                articlesViewModel = articlesViewModel
            )
        }
        composable(Screen.ABOUT_DEVICE.route) {
            AboutScreen(onUpButtonClick = { navController.popBackStack() })
        }
    }
}
