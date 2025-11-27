package com.example.dailypulse.articles.di

import com.example.dailypulse.articles.ArticlesService
import com.example.dailypulse.articles.ArticlesUseCase
import com.example.dailypulse.articles.ArticlesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val ArticlesModule = module {
    single { ArticlesService(get()) }
    single { ArticlesUseCase(get()) }
    single { ArticlesViewModel(get())}
}