package com.example.blackpooltoursapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Blackpool Tours", fontSize = 35.sp)
        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(id = R.drawable.bptlogo),
            contentDescription = "BlackPool Tours Logo",
            contentScale = ContentScale.Fit
        )

        Button(
            modifier = Modifier.width(200.dp),
            onClick = { navController.navigate("login_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))

        ) {
            Text("Login")
        }
    }

}

