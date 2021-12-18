package com.example.dogbreeds.di

import com.example.dogbreeds.data.repository.Repository
import org.koin.dsl.module

val repositoryModule = module {
    single { Repository(get()) }
}