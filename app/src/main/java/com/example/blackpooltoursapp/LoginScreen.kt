package com.example.blackpooltoursapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
    Column(Modifier.fillMaxSize().padding(48.dp)) {
        LoginHeader()
        LoginComponents()
        LoginFooter()
    }
}

@Composable
fun LoginHeader(){

    Text(text = "Login", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)
    Text(text = "Welcome back, your tours await.", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
}

@Composable
fun LoginComponents(){

}

@Composable
fun LoginFooter(){

}