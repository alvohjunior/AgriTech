package com.example.agritech.ui.theme.screens.records

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable

fun FinancialRecords(navController: NavController) {

    var income by remember { mutableStateOf("") }
    var expenditure by remember { mutableStateOf("") }
    var receipts by remember { mutableStateOf("") }
    var invoices by remember { mutableStateOf("") }
    var loanRecords by remember { mutableStateOf("") }
    var assetInventory by remember { mutableStateOf("") }
    var taxRecords by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home")
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Financial Records",
                fontSize = 24.sp,
                color = Color.Magenta,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                label = { Text("Income") },
                value = income,
                onValueChange = { income = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Expenditure") },
                value = expenditure,
                onValueChange = { expenditure = it },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Receipts") },
                value = receipts,
                onValueChange = { receipts = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Invoices") },
                value = invoices,
                onValueChange = { invoices = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Loan Records") },
                value = loanRecords,
                onValueChange = { loanRecords = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Asset Inventory") },
                value = assetInventory,
                onValueChange = { assetInventory = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Tax Records") },
                value = taxRecords,
                onValueChange = { taxRecords = it }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Save financial records */ }) {
                Text(text = "Save Records")
            }
        }
    }
}

@Composable
fun CropProductionRecords(navController: NavController) {
    var plantingDates by remember { mutableStateOf("") }
    var varieties by remember { mutableStateOf("") }
    var locations by remember { mutableStateOf("") }
    var inputRecords by remember { mutableStateOf("") }
    var harvestYields by remember { mutableStateOf("") }
    var cropRotation by remember { mutableStateOf("") }
    var pestManagement by remember { mutableStateOf("") }

    Scaffold(
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Home")
                }
                IconButton(onClick = { /* TODO */ }) {
                    Icon(Icons.Filled.Settings, contentDescription = "Settings")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Crop Production Records",
                fontSize = 24.sp,
                color = Color.Magenta,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            OutlinedTextField(
                label = { Text("Planting Dates") },
                value = plantingDates,
                onValueChange = { plantingDates = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Varieties") },
                value = varieties,
                onValueChange = { varieties = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Locations") },
                value = locations,
                onValueChange = { locations = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Input Records") },
                value = inputRecords,
                onValueChange = { inputRecords = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Harvest Yields") },
                value = harvestYields,
                onValueChange = { harvestYields = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Crop Rotation") },
                value = cropRotation,
                onValueChange = { cropRotation = it }
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                label = { Text("Pest Management") },
                value = pestManagement,
                onValueChange = { pestManagement = it }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { /* Save crop production records */ }) {
                Text(text = "Save Records")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FinancialRecordsPreview() {
    FinancialRecords(rememberNavController())
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CropProductionRecordsPreview() {
    CropProductionRecords(rememberNavController())
}
