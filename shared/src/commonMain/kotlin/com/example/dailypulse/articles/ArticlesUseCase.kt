package com.example.dailypulse.articles

import com.example.dailypulse.articles.repository.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlin.math.abs

class ArticlesUseCase(private val repository: ArticlesRepository) {

    suspend fun fetchArticles(): List<Article> {
        val articlesRaw = repository.getArticles()
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            title = it.title,
            desc = it.description ?: "Click to read more",
            date = getDayAgoString(it.date),
            imageUrl = it.urlToImage ?: "https://gizmodo.com/app/uploads/2025/11/GotMilkPluribus-1-1200x675.jpg"
        )
    }

    private fun getDayAgoString(date: String): String {
        val today = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault()).date
        val articleDate = Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        val days = abs(today.daysUntil(articleDate))

        val result = when {
            days == 0 -> "Today"
            days == 1 -> "Yesterday"
            days < 7 -> "$days days ago"
            days < 30 -> "${days / 7} weeks ago"
            days < 365 -> "${days / 30} months ago"
            else -> "${days / 365} years ago"
        }

        return result
    }
}