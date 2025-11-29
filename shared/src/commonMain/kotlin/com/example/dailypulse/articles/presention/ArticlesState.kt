package com.example.dailypulse.articles.presention

import com.example.dailypulse.articles.application.Article

data class ArticlesState(
    val articles: List<Article> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)