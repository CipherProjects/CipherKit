package com.cipherprojects.core.di

import com.cipherprojects.core.data.preferences.AppPreferences
import com.cipherprojects.core.presentation.auth.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val coreModule = module {
    single { AppPreferences(get()) }

    viewModelOf(::LoginViewModel)
}