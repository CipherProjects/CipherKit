package com.cipherprojects.core.presentation.auth

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cipherprojects.core.presentation.auth.login.LoginScreen
import com.cipherprojects.core.presentation.auth.register.RegisterScreen

@Composable
fun AuthNavigation(
    darkTheme: Boolean,
    toggleDarkTheme: () -> Unit,
    onLoginSuccessful: () -> Unit
) {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Login
    ) {
        composable<Routes.Login> {
            LoginScreen(
                darkTheme = darkTheme,
                toggleDarkTheme = toggleDarkTheme,
                onLoginSuccessful = onLoginSuccessful,
                onRegisterAccount = {
                    navController.navigate(Routes.Register) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Routes.Register> {
            RegisterScreen(
                darkTheme = darkTheme,
                toggleDarkTheme = toggleDarkTheme,
                onRegisterSuccessful = {
                    navController.navigateUp()
                }
            )
        }
    }
}