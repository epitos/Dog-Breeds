package com.example.dogbreeds.di

import com.example.dogbreeds.ui.viewmodel.BreedDetailsViewModel
import com.example.dogbreeds.ui.viewmodel.BreedListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { BreedListViewModel(get(), get()) }
    viewModel { BreedDetailsViewModel(get(), get()) }
}
