package com.example.dailypulse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailypulse.articles.ArticlesViewModel
import com.example.dailypulse.screens.ArticlesScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        ArticlesScreen(articlesViewModel = viewModel<ArticlesViewModel>())
    }
}