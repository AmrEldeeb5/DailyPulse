package com.example.dailypulse.di

import com.example.dailypulse.articles.di.ArticlesModule

val sharedKoinModules = listOf(
    ArticlesModule,
    NetworkModule,
)
