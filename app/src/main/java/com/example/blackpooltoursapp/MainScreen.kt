package com.example.blackpooltoursapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.bptlogo),
            contentDescription = "BlackPool Tours Logo"
        )
        Button(
            onClick = { /* TODO: Add navigation to LoginScreen.kt */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))
        ) {
            Text("Login")
        }
    }


}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen()
}
