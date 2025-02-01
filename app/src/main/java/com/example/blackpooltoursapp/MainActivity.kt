package com.example.blackpooltoursapp
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blackpooltoursapp.ui.theme.BlackPoolToursAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlackPoolToursAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NavHost(navController = navController, startDestination = "main_screen") {
                        composable("main_screen") { MainScreen(navController) }
                        composable("login_screen") { LoginScreen() }
                    }
                }
            }
        }
    }
}
