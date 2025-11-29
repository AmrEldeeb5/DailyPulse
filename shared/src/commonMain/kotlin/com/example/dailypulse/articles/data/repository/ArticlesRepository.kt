package com.example.dailypulse.articles.data.repository

import com.example.dailypulse.articles.data.ArticleRaw
import com.example.dailypulse.articles.data.ArticlesDataSource
import com.example.dailypulse.articles.data.ArticlesService

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getArticles(forceRefresh: Boolean): List<ArticleRaw> {
        if (forceRefresh) {
            dataSource.clearArticles()
            val fetchedArticles = service.fetchArticles()
            dataSource.insertArticles(fetchedArticles.articles)
            return fetchedArticles.articles
        }

        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} articles from the db!!}")

        if(articlesDb.isEmpty()){
            val fetchedArticles = service.fetchArticles()
            dataSource.insertArticles(fetchedArticles.articles)
            return fetchedArticles.articles
        }
        return articlesDb
    }
}