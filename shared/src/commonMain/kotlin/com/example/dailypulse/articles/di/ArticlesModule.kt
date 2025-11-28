package com.example.dailypulse.articles.di

import com.example.dailypulse.articles.ArticlesService
import com.example.dailypulse.articles.ArticlesUseCase
import com.example.dailypulse.articles.ArticlesViewModel
import com.example.dailypulse.articles.repository.ArticlesRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val ArticlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get())}
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}