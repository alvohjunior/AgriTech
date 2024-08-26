package com.example.agritech.ui.theme.screens.goods

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.agritech.R
import com.example.agritech.ui.theme.AgriTechTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewGoods(navController: NavController) {

}
@Composable
fun ViewGoodsPreview() {
    AgriTechTheme {
        ViewGoods(navController = rememberNavController())
    }
}

