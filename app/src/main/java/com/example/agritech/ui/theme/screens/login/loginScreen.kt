package com.example.agritech.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.agritech.R
import com.example.agritech.data.AuthViewModel

import com.example.agritech.navigation.ROUTE_CONSUMER_SCREEN
import com.example.agritech.navigation.ROUTE_HOME

import com.example.agritech.navigation.ROUTE_PRODUCER_SCREEN
import com.example.agritech.ui.theme.AgriTechTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var context = LocalContext.current
    var emailAddress by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }

    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Image",
            contentScale = ContentScale.FillBounds
        )
    }

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Please Login First",
            fontSize = 20.sp,
            color = Color.Blue,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Sample image",
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .height(80.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = emailAddress,
            onValueChange = { emailAddress = it },
            label = { Text(text = "Enter Your EmailAddress") },
            placeholder = { Text(text = "Please enter your EmailAddress") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                focusedPlaceholderColor  = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.surface,
                focusedLabelColor  = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.small.copy(CornerSize(8.dp)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Enter Password") },
            placeholder = { Text(text = "Please enter your password") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                focusedPlaceholderColor  = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.surface,
                focusedLabelColor  = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.small.copy(CornerSize(8.dp)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = role,
            onValueChange = { role = it },
            label = { Text(text = "Enter Your Role (producer/consumer)") },
            placeholder = { Text(text = "Please enter your role") },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = MaterialTheme.colorScheme.surface,
                focusedPlaceholderColor  = MaterialTheme.colorScheme.surfaceVariant,
                unfocusedPlaceholderColor = MaterialTheme.colorScheme.surface,
                focusedLabelColor  = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                cursorColor = MaterialTheme.colorScheme.primary
            ),
            shape = MaterialTheme.shapes.small.copy(CornerSize(8.dp)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                val mylogin = AuthViewModel(navController, context)
                mylogin.login(emailAddress.trim(), password.trim())

                {
                    when (role.trim().lowercase()) {
                        "producer" -> navController.navigate(ROUTE_PRODUCER_SCREEN)
                        "consumer" -> navController.navigate(ROUTE_CONSUMER_SCREEN)
                        else -> { /* Handle unknown role or error */ }
                    }
                }
                navController.navigate(ROUTE_HOME)
            },
            colors = ButtonDefaults.buttonColors(Color.Red),
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "LOGIN HERE",
                modifier = Modifier.padding(5.dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // Implement registration action
                },
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Text(
                    text = "REGISTER HERE",
                    modifier = Modifier.padding(5.dp)
                )
            }

            Button(
                onClick = { /* Implement forgot password action */ },
                colors = ButtonDefaults.buttonColors(Color.Magenta)
            ) {
                Text(
                    text = "FORGOT PASSWORD",
                    modifier = Modifier.padding(5.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginPreview() {
    AgriTechTheme {
        Login(rememberNavController())
    }
}
