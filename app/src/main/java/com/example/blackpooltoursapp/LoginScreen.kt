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
    // Variables used to store user input and for error control
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val isError = remember { mutableStateOf(false) }

    Column(Modifier.fillMaxSize().padding(48.dp)) {
        // Initialises each function w/ specific parameters needed
        LoginHeader(navController)
        LoginComponents(username, password, isError)
        LoginFooter(navController, username, password, isError)
    }
}

// Login Screen split into three parts for easy set up: Header, Components and Footer
@Composable
fun LoginHeader(navController: NavController){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start
    ) {
        // Backspace button used when a user wants to go back to the main page
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
fun LoginComponents(username: MutableState<String>, password: MutableState<String>, isError: MutableState<Boolean>){
    Spacer(modifier = Modifier.height(70.dp))
    // Conditional to check to see if credentials are valid, if not, new UI changes are made
    if (isError.value){
        Text(
            text = "Invalid username or password.",
            // Changes text colour to red when incorrect credentials are entered
            color = Color.Red,
            fontSize = 14.sp,
            modifier = Modifier
                .padding(start = 8.dp)
        )
    }
    Spacer(modifier = Modifier.height(20.dp))

    // Input field for user to type in their credentials
    TextField(
        value = username.value,
        onValueChange = { username.value = it },
        label = { Text("Username *") },
        isError = isError.value,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )

    Spacer(modifier = Modifier.height(25.dp))
    TextField(
        value = password.value,
        onValueChange = { password.value = it },
        label = { Text("Password *") },
        isError = isError.value,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 32.dp)
    )

}

@Composable
fun LoginFooter(navController: NavController, username: MutableState<String>, password: MutableState<String>, isError: MutableState<Boolean>){
    // Button navigating to the tours_list screen
    Button(
        modifier = Modifier.width(200.dp),
        onClick = {
            // Only navigates if user credentials are valid
            if (username.value == "user" && password.value == "pass"){
                isError.value = false
                navController.navigate("tours_list_screen")
            } else {
                isError.value = true
            }
                  },
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))

    ) {
        Text("Login")
    }

}