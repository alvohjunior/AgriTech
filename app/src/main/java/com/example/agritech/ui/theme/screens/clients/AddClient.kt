package com.example.agritech.ui.theme.screens.clients

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.agritech.R
import com.example.agritech.data.ClientViewModel


@Composable
fun AddClient(navController: NavController) {
    val context = LocalContext.current

    val imageuri = rememberSaveable { mutableStateOf<Uri?>(null) }
    val painter = rememberImagePainter(
        data = imageuri.value ?: R.drawable.ic_add_a_photo,
        builder = {
            crossfade(true)
        }
    )
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let { imageuri.value = it }
    }

    // State for dropdown menu
    var expanded by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf("Consumer") }
    val types = listOf("Consumer", "Producer")

    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.Home, contentDescription = "")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.Settings, contentDescription = "")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Filled.Email, contentDescription = "")
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(
                        onClick = { /* TODO */ },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                    ) {
                        Icon(Icons.Filled.AccountCircle, contentDescription = "")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "INSERT NEW CLIENT",
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(Color.Magenta)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /* TODO */ }) {
                    Text(text = "GO BACK")
                }
                Button(onClick = {
                    val clientRepository = ClientViewModel(navController, context)
                    imageuri.value?.let { uri ->
                        clientRepository.saveClient(uri, firstname, lastname, gender, age, bio, selectedType)
                    } ?: run {
                        Toast.makeText(context, "Please select an image", Toast.LENGTH_LONG).show()
                    }
                }) {
                    Text(text = "SAVE")
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(180.dp)
                ) {
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier
                            .wrapContentSize()
                            .clickable { launcher.launch("image/*") },
                        contentScale = ContentScale.Crop
                    )
                }
                Text(text = "Change Picture Here")
            }

            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter First Name") },
                placeholder = { Text(text = "Please Enter First Name") },
                value = firstname,
                onValueChange = { newName -> firstname = newName }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter Last Name") },
                placeholder = { Text(text = "Please Enter Last Name") },
                value = lastname,
                onValueChange = { newName -> lastname = newName }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter Your Gender") },
                placeholder = { Text(text = "Please Enter Your Gender") },
                value = gender,
                onValueChange = { newName -> gender = newName }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter Your Age") },
                placeholder = { Text(text = "Please Enter Your Age") },
                value = age,
                onValueChange = { newName -> age = newName }
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                modifier = Modifier
                    .height(160.dp)
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally),
                label = { Text(text = "Enter Your Description") },
                placeholder = { Text(text = "Please Enter Your Bio") },
                value = bio,
                singleLine = false,
                onValueChange = { newName -> bio = newName }
            )

            // Dropdown Menu
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .wrapContentSize()
                    .clickable { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedType,
                    onValueChange = { selectedType = it },
                    label = { Text(text = "Select Type") },
                    placeholder = { Text(text = "Select Consumer or Producer") },
                    readOnly = true,
                    trailingIcon = {
                        Icon(
                            Icons.Filled.ArrowDropDown,
                            contentDescription = "Dropdown Arrow"
                        )
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    types.forEach { type ->
                        DropdownMenuItem(
                            text = { Text(type) },
                            onClick = {
                                selectedType = type
                                expanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AddClientPreview() {
    AddClient(rememberNavController())
}
