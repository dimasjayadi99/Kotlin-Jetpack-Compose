package com.example.belajarkotlinjetpackcompose.presentation.splash

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.belajarkotlinjetpackcompose.viewmodel.SplashViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = hiltViewModel(),
    navigateHome: () -> Unit,
    navigateLogin: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        SplashUiState.Loading -> {
            // show loading widget
        }

        SplashUiState.OnNavigateHome -> {
            // navigate to home
            LaunchedEffect(Unit) {
                navigateHome()
            }
        }

        SplashUiState.OnNavigateLogin -> {
            // navigate to login
            LaunchedEffect(Unit) {
                navigateLogin()
            }
        }
    }

    SplashContent()
}

@Composable
private fun SplashContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text("Kotlin Jetpack Compose", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text("For Example", fontWeight = FontWeight.Normal, fontSize = 14.sp)
        }
    }
}