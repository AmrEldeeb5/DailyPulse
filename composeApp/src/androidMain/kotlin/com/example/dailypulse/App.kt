package com.example.dailypulse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailypulse.articles.ArticlesViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppScaffold(articlesViewModel = viewModel<ArticlesViewModel>())
    }
}