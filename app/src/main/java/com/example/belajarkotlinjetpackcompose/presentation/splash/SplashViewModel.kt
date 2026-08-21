package com.example.belajarkotlinjetpackcompose.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Loading)
    val uiState = _uiState.asStateFlow()

    init {
        checkInitLogin()
    }

    private fun checkInitLogin(){
        viewModelScope.launch {
            delay(1500)
            val loggedIn = false

            _uiState.value = if(loggedIn){
                SplashUiState.OnNavigateHome
            }else{
                SplashUiState.OnNavigateLogin
            }
        }
    }
}