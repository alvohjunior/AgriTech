package com.example.agritech.ui.theme.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.agritech.R

@Composable
fun SplashScreen(navController: NavController) {

    val splashTime = 3000L


    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(splashTime)
        navController.navigate("home") {

            popUpTo("splash") { inclusive = true }
        }
    }


    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.splash),
            contentDescription = "Splash Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        )
        Text(
            text = "AgriTech",
            color = Color.White,
            fontSize = 32.sp,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)
        )
    }
}
