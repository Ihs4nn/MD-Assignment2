package com.example.blackpooltoursapp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MyTours(navController: NavController, tourViewModel: TourViewModel) {
    val isHidden by remember { mutableStateOf<Boolean>(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Saved Tours",
            fontSize = 35.sp,
            modifier = Modifier.padding(25.dp)
        )
        // AI Aided work
        LazyColumn(modifier = Modifier.weight(1f).padding(25.dp)) {
            items(tourViewModel.savedTours) { tour ->
                TourCards(tour, onSaveTour = {}, onRemoveTour = {tourViewModel.removeTour(it)}, isHidden = isHidden)
            }

        }
        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = { navController.popBackStack() },
            // end
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))
        ) {
            Text("Back to tours")
        }
    }
}
