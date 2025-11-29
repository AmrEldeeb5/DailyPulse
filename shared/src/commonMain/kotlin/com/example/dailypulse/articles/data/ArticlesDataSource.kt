package com.example.dailypulse.articles.data

import com.example.dailypulse.articles.data.ArticleRaw
import com.example.dailypulse.db.DailyPulseDatabase

class ArticlesDataSource(private val database: DailyPulseDatabase) {

    fun getAllArticles(): List<ArticleRaw> {
        return database.dailyPulseDatabaseQueries.selectAllArticles(::mapToArticleRaw).executeAsList()
    }

    fun insertArticles(articles: List<ArticleRaw>) {
        database.dailyPulseDatabaseQueries.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    fun clearArticles() {
        database.dailyPulseDatabaseQueries.clearArticles()
    }

    private fun insertArticle(articleRaw: ArticleRaw) {
        database.dailyPulseDatabaseQueries.insertArticle(
            title = articleRaw.title,
            desc = articleRaw.description,
            date = articleRaw.date,
            imageUrl = articleRaw.urlToImage
        )
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw = ArticleRaw(
        title = title,
        description = desc,
        date = date,
        urlToImage = imageUrl
    )
}