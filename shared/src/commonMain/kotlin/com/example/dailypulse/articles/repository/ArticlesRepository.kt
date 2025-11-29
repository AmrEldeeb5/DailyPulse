package com.example.dailypulse.articles.repository

import com.example.dailypulse.articles.ArticleRaw
import com.example.dailypulse.articles.ArticlesDataSource
import com.example.dailypulse.articles.ArticlesService

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {
    suspend fun getArticles(): List<ArticleRaw> {
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