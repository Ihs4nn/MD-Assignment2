package com.example.blackpooltoursapp

import android.media.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material3.Text

@Composable
fun ToursList(navController: NavController) {
    data class Tours(
        val image: Int,
        val title: String,
        val desc: String,
        val extradesc: String,
        val isSelected: Boolean = false
    )

    val sample_tours = listOf(
        Tours(R.drawable.spain, "Sagrada Famillia", "A breathtaking church in Barcelona","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tours(R.drawable.italy, "Rome","The capital of Italy","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tours(R.drawable.aussie, "Kangaroo Islam","A wildlife paradise in Australia","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tours(R.drawable.japan, "Mount Fuji", "Japan's highest mountain","Lorem ipsum dolor sit amet, consectetur adipiscing elit")
    )


}

