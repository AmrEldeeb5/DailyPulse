package com.example.dailypulse.di

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import com.example.dailypulse.articles.ArticlesViewModel

val viewModelsModule = module {
    viewModelOf(::ArticlesViewModel)
}
