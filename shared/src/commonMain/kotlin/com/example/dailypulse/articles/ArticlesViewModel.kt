package com.example.dailypulse.articles

import com.example.dailypulse.BaseViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class ArticlesViewModel: BaseViewModel(){
    private val _articlesState = MutableStateFlow(ArticlesState(isLoading = true))
    val articlesState: StateFlow<ArticlesState> = _articlesState

    private lateinit var useCase: ArticlesUseCase

    init {
        val httpClient = HttpClient(){
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
        }
        val service = ArticlesService(httpClient)
        useCase = ArticlesUseCase(service)
        getArticles()
    }

    private fun getArticles(){
        scope.launch{
            try {
                _articlesState.emit(ArticlesState(isLoading = true))
                val fetchedArticles = useCase.fetchArticles()
                _articlesState.emit(ArticlesState(articles = fetchedArticles))
            } catch (e: Exception) {
                _articlesState.emit(ArticlesState(error = e.message ?: "Unknown error occurred"))
            }
        }
    }
}
