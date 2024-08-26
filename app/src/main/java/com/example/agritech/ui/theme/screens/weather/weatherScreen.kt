package com.example.agritech.ui.theme.screens.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agritech.R
import com.example.agritech.ui.theme.AgriTechTheme

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            AgriTechTheme {
//                WeatherScreen()
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen(navController: NavController) {
    var location by remember { mutableStateOf("") }
    var weatherInfo by remember { mutableStateOf<WeatherInfo?>(null) }
    Box {
        Image(
            painter = painterResource(id = R.drawable.background2),
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    )

    {
        Image(
            painter = painterResource(id = R.drawable.icon),
            contentDescription = "Weather App Icon",
            modifier = Modifier
                .padding(bottom = 16.dp)
                .wrapContentHeight()
                .fillMaxWidth()
                .height(80.dp)

        )

        Text(
            text = "Weather App",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = location,
                onValueChange = { location = it },
                label = { Text("Enter Location") },
                modifier = Modifier.weight(1f)
            )

            Button(onClick = {
                // Simulate fetching weather data
                weatherInfo = WeatherInfo(
                    location = location,
                    date = "August 21, 2024",
                    condition = "Rain"
                )
            }) {
                Text("Get Weather")
            }
        }

        weatherInfo?.let {
            WeatherInfoView(weatherInfo = it)
        }
    }
}

@Composable
fun WeatherInfoView(weatherInfo: WeatherInfo) {
    Column(modifier = Modifier.padding(top = 16.dp)) {
        Text(text = "Location: ${weatherInfo.location}")
        Text(text = "Date: ${weatherInfo.date}")
        Text(text = "Condition: ${weatherInfo.condition}")
    }
}

data class WeatherInfo(
    val location: String,
    val date: String,
    val condition: String
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherScreenPreview() {
    AgriTechTheme {
        WeatherScreen(rememberNavController())
    }
}
