package com.example.agritech.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agritech.ui.theme.screens.about.About
import com.example.agritech.ui.theme.screens.clients.AddClient
import com.example.agritech.ui.theme.screens.goods.PostGoods
import com.example.agritech.ui.theme.screens.goods.ViewGoods
import com.example.agritech.ui.theme.screens.home.ConsumerHomeScreen
import com.example.agritech.ui.theme.screens.home.HomeScreen
import com.example.agritech.ui.theme.screens.home.ProducerHomeScreen
import com.example.agritech.ui.theme.screens.login.Login
import com.example.agritech.ui.theme.screens.register.Register
import com.example.agritech.ui.theme.screens.soiltest.SoilTest
import com.example.agritech.ui.theme.screens.weather.WeatherScreen

@Composable
fun AppNavHost(navController:NavHostController= rememberNavController(),
               startDestination: String = ROUTE_REGISTER){
    NavHost(navController=navController,
        startDestination=startDestination){
        composable(ROUTE_REGISTER){ Register(navController)}
        composable(ROUTE_HOME){ HomeScreen(navController) }
        composable( ROUTE_WEATHER){ WeatherScreen(navController)}
        composable(ROUTE_CONSUMER_SCREEN){ ConsumerHomeScreen(navController)}
        composable(ROUTE_PRODUCER_SCREEN){ ProducerHomeScreen(navController)}
        composable(ROUTE_LOGIN){ Login(navController)}
        composable(ROUTE_ABOUT){ About(navController)}
        composable(ROUTE_SOIL_TEST){ SoilTest(navController)}
        composable(ROUTE_POST_GOODS){ PostGoods(navController)}
        composable(ROUTE_ADD_CLIENT){ AddClient(navController)}
        composable(ROUTE_VIEW_GOODS){ ViewGoods(navController)}
    }


}

