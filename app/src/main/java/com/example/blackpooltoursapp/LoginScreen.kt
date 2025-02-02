package com.example.blackpooltoursapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
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
    Text(text = "Welcome back, your tours await.", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
}

@Composable
fun LoginComponents(){


}

@Composable
fun LoginFooter(navController: NavController){

}