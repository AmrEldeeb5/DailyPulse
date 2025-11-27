package com.example.dailypulse.articles

class ArticlesUseCase(private val articlesService: ArticlesService) {

    suspend fun fetchArticles(): List<Article> {
        val articlesRaw = articlesService.fetchArticles()
        return mapArticles(articlesRaw.articles)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map {
        Article(
            title = it.title,
            desc = it.description ?: "Click to read more",
            date = it.date,
            imageUrl = it.urlToImage ?: "https://gizmodo.com/app/uploads/2025/11/GotMilkPluribus-1-1200x675.jpg"
        )
    }
}