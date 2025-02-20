package com.cipherprojects.core.presentation.auth

import kotlinx.serialization.Serializable

object Routes {

    @Serializable
    data object Login

    @Serializable
    data object Register
}