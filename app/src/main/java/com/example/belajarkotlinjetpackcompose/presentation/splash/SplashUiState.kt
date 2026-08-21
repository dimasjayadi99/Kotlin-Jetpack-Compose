package com.example.belajarkotlinjetpackcompose.presentation.splash

sealed interface SplashUiState {
    data object Loading : SplashUiState
    data object OnNavigateLogin : SplashUiState
    data object  OnNavigateHome : SplashUiState
}