package com.example.dailypulse.articles.presention

import com.example.dailypulse.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
): BaseViewModel(){
    private val _articlesState = MutableStateFlow(ArticlesState(isLoading = true))
    val articlesState: StateFlow<ArticlesState> = _articlesState



    init {
        getArticles()
    }

    fun getArticles(forceRefresh: Boolean = false){
        scope.launch {
            try {
                _articlesState.emit(ArticlesState(isLoading = true))
                val fetchedArticles = useCase.fetchArticles(forceRefresh)
                _articlesState.emit(ArticlesState(articles = fetchedArticles))
            } catch (e: Exception) {
                _articlesState.emit(ArticlesState(error = e.message ?: "Unknown error occurred"))
            }
        }
    }
}