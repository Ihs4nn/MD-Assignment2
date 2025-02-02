package com.example.blackpooltoursapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Column(Modifier.fillMaxSize().padding(48.dp)) {
        LoginHeader(navController)
        LoginComponents()
        LoginFooter(navController)
    }
}

@Composable
fun LoginHeader(navController: NavController){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        IconButton(onClick = { navController.navigate("main_screen") }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
    Spacer(modifier = Modifier.height(25.dp))
    Text(text = "Login", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
    Spacer(modifier = Modifier.height(25.dp))
    Text(text = "Welcome back, your tours await.", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
}

@Composable
fun LoginComponents(){
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(70.dp))

    TextField(
        value = username.value,
        onValueChange = { username.value = it },
        label = { Text("Username *") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
    Spacer(modifier = Modifier.height(50.dp))
    TextField(
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text("Password *") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    )
}

@Composable
fun LoginFooter(navController: NavController){
    Button(
        modifier = Modifier.width(200.dp),
        onClick = { navController.navigate("tours_list_screen") },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))

    ) {
        Text("Login")
    }

}