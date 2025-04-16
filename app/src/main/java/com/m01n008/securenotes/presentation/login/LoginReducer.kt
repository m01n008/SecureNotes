package com.m01n008.securenotes.presentation.login

fun loginReducer(loginIntent: LoginIntent, loginState: LoginState): LoginState{
  return when (loginIntent) {
      is LoginIntent.AttemptPinLogin -> {
          if (loginIntent.pin == "9876") {
              loginState.copy(isLoading = false, error = null, isAuthenticated = true)
          }
          else{
              loginState.copy(error = "Invalid PIN", isAuthenticated = false)
          }

      }
      is LoginIntent.Logout -> LoginState()
      is LoginIntent.AttemptBiometricLogin -> loginState.copy(isLoading = true, error = null)
      is LoginIntent.AttemptFaceLogin -> loginState.copy(isLoading = true)
      is LoginIntent.PinChanged -> {
          loginState.copy(error = null)
      }

  }

}