package com.m01n008.securenotes.presentation.login

data class LoginState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val isBiometricAvailable: Boolean = true,
    val isAuthenticated: Boolean = false

)
