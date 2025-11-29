package com.example.dailypulse

import android.app.Application
import coil3.ImageLoader
import coil3.SingletonImageLoader
import coil3.disk.DiskCache
import coil3.memory.MemoryCache
import coil3.network.ktor3.KtorNetworkFetcherFactory
import coil3.request.crossfade
import com.example.dailypulse.di.dataBaseModule
import com.example.dailypulse.di.sharedKoinModules
import com.example.dailypulse.di.viewModelsModule
import okio.Path.Companion.toPath
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class DailyPulseApplication : Application(), SingletonImageLoader.Factory {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + dataBaseModule

        startKoin {
            androidContext(this@DailyPulseApplication)
            modules(modules)
        }
    }

    override fun newImageLoader(context: android.content.Context): ImageLoader {
        return ImageLoader.Builder(context)
            .components {
                add(KtorNetworkFetcherFactory())
            }
            .memoryCache {
                MemoryCache.Builder()
                    .maxSizePercent(context, 0.25)
                    .build()
            }
            .diskCache {
                DiskCache.Builder()
                    .directory(context.cacheDir.resolve("image_cache").absolutePath.toPath())
                    .maxSizePercent(0.02)
                    .build()
            }
            .crossfade(true)
            .build()
    }
}

