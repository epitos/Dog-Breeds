package com.example.dogbreeds.application

import android.app.Application
import com.example.dogbreeds.di.appModule
import com.example.dogbreeds.di.repositoryModule
import com.example.dogbreeds.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BreedApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BreedApplication)
            modules(provideModules())
        }
    }
    private fun provideModules() = listOf(appModule, repositoryModule, viewModelModule)
}