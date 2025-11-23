package com.example.dailypulse.articles

import com.example.dailypulse.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel: BaseViewModel(){
    private val _articlesState = MutableStateFlow(ArticlesState())
    val articlesState: StateFlow<ArticlesState> = _articlesState

    init {
        getArticles()
    }

    private fun getArticles(){
        scope.launch{
            delay(500)
            _articlesState.emit(ArticlesState())
        }
    }

    suspend fun fetchArticles(): List<Article> = mockArticles

    private val mockArticles = listOf(
        Article(
            title = "Stock market today: Live updates - CNBC",
            desc = "Futures were higher in premarket trading as Wall Street tried to regain its footing.",
            date = "2023-11-09",
            imageUrl = "https://image.cnbcfm.com/api/v1/image/107326078-1698758530118-gettyimages-1765623456-wall26362_igj6eh.jpg?v=1698758580"
        ),

        Article(
            title = "Best iPhone Deals (2023): Carrier Deals, Unlocked iPhones",
            desc = "Apple's smartphones rarely go on sale, but if you’re looking to upgrade (or you're gift shopping), here are the best deals available now.",
            date = "2023-11-09",
            imageUrl = "https://media.wired.com/photos/622aa5c8cca6ac55fb70b57/1:w_1280,c_limit/iPhone-13-Pro-Colors-SOURCE.jpg"
        ),

        Article(
            title = "Samsung details 'Galaxy AI' and a feature that can translate phone calls in real time",
            desc = "Samsung previewed what it calls a new era of Galaxy AI coming to its smartphones and devices.",
            date = "2023-11-09",
            imageUrl = "https://cdn.vox-cdn.com/thumbor/0cz_0vdutaexp1aPTMYqaqzBR8=/0x0:2000x1333/1200x628/filters:focal(1000x667:1001x668)/cdn.vox-cdn.com/uploads/chorus_image/image/72789982/DSCF6944.0.jpg"
        )
    )

}
