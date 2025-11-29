package com.example.dailypulse.di

import app.cash.sqldelight.db.SqlDriver
import com.example.dailypulse.articles.presention.ArticlesViewModel
import com.example.dailypulse.db.DailyPulseDatabase
import com.example.dailypulse.db.DatabaseDriverFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin
import org.koin.dsl.module

private val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}

fun initKoin() {
    val modules = sharedKoinModules + databaseModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector: KoinComponent {
    val articlesViewModel: ArticlesViewModel by inject()
}