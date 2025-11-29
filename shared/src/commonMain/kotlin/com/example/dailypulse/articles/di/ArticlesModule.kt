package com.example.dailypulse.articles.di

import com.example.dailypulse.articles.data.ArticlesDataSource
import com.example.dailypulse.articles.data.ArticlesService
import com.example.dailypulse.articles.presention.ArticlesUseCase
import com.example.dailypulse.articles.presention.ArticlesViewModel
import com.example.dailypulse.articles.data.repository.ArticlesRepository
import org.koin.dsl.module

val ArticlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get())}
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}