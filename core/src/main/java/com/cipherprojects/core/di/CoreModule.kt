package com.cipherprojects.core.di

import android.app.Application
import androidx.room.Room
import com.cipherprojects.core.data.auth.AuthRepositoryImpl
import com.cipherprojects.core.data.database.AppDatabase
import com.cipherprojects.core.data.preferences.AppPreferences
import com.cipherprojects.core.domain.auth.AuthRepository
import com.cipherprojects.core.domain.auth.LoginUserUseCase
import com.cipherprojects.core.domain.auth.RegisterUserUseCase
import com.cipherprojects.core.presentation.auth.login.LoginViewModel
import com.cipherprojects.core.presentation.auth.register.RegisterViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val coreModule = module {
    // preferences
    single { AppPreferences(get()) }

    // room
    single {
        Room.databaseBuilder(
            get<Application>(), // application context
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration().build()
    }
    single { get<AppDatabase>().userDao() } // provide UserDao
    single<AuthRepository> { AuthRepositoryImpl(get()) }
    single { LoginUserUseCase(get()) }
    single { RegisterUserUseCase(get()) }

    // [auth] login-viewmodel
    viewModelOf(::LoginViewModel)

    // [auth] register-viewmodel
    viewModelOf(::RegisterViewModel)
}