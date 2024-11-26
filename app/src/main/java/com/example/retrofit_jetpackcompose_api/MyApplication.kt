package com.example.retrofit_jetpackcompose_api

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import okhttp3.OkHttpClient

class MyApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .crossfade(true)
            .memoryCachePolicy(coil.request.CachePolicy.ENABLED)
            .diskCache( // Config de cache en disk
                DiskCache.Builder()
                    .directory(cacheDir.resolve("image_cache")) // Cache Folder
                    .maxSizeBytes(50L * 1024 * 1024) // Max.: 50 MB
                    .build()
            )
            .okHttpClient {
                OkHttpClient.Builder()
                    .build()
            }
            .build()
    }
}
