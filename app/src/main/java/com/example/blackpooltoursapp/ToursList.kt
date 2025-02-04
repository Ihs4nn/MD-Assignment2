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
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

data class Tour(
    val image: Int,
    val title: String,
    val desc: String,
    val extraInfo: String
)
@Composable
fun ToursList(navController: NavController, tourViewModel: TourViewModel) {
    var isHidden by remember { mutableStateOf<Boolean>(true) }

    val sampleTours = listOf(
        Tour(R.drawable.morocco, "Sahara Dessert", "Morocco's expansive dunes","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tour(R.drawable.spain, "Sagrada Famillia", "A breathtaking church in Barcelona","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tour(R.drawable.italy, "Rome","The capital of Italy","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tour(R.drawable.aussie, "Kangaroo Island","A wildlife paradise in Australia","Lorem ipsum dolor sit amet, consectetur adipiscing elit"),
        Tour(R.drawable.japan, "Mount Fuji", "Japan's highest mountain","Lorem ipsum dolor sit amet, consectetur adipiscing elit")
    )

    Column(Modifier.fillMaxSize().padding(5.dp)) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
        ) {
            // AI Aided work
            items(sampleTours){ tour ->
                TourCards(tour, onSaveTour = { tourViewModel.addTour(it) }, onRemoveTour = {tourViewModel.removeTour(it)}, isHidden = isHidden)
            }
        }
        //end
        ToursListFooter(navController, hiddenButtonNav = {
            isHidden = false
            navController.navigate("my_tours_screen")
        })
    }
}

@Composable
fun TourCards(tour: Tour, onSaveTour: (Tour) -> Unit, onRemoveTour: (Tour) -> Unit = {}, isHidden: Boolean) {
    var isExpanded by remember { mutableStateOf<Boolean>(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { isExpanded = !isExpanded },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = tour.image),
                contentDescription = tour.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = tour.title)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = tour.desc)

            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = tour.extraInfo)
            }
            Spacer(modifier = Modifier.height(10.dp))

            if (isHidden){
                Button(
                    modifier = Modifier
                        .width(55.dp),
                    // AI Aided work
                    onClick = { onSaveTour(tour)},
                    // end
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF)),
                ) {
                    Text("+")
                }
            } else {
                Button(
                    modifier = Modifier
                        .width(55.dp),

                    onClick = {onRemoveTour(tour)},
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8A80)),
                ) {
                    Text("-")
                }
            }

        }
    }
}

@Composable
fun ToursListFooter(navController: NavController, hiddenButtonNav: () -> Unit){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ){
        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = { navController.navigate("my_tours_screen")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))

        ) {
            Text("My Tours")
        }
    }

}