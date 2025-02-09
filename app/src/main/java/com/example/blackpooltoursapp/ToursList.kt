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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color

// Data class 'Tour' used to hold information about each tour
data class Tour(
    val image: Int, // Images are Ints in Android!
    val title: String,
    val desc: String,
    val extraInfo: String,
    var weatherInfo: String? = null
)
@Composable
fun ToursList(navController: NavController, tourViewModel: TourViewModel) {
    // Variable used to toggle between '+' and '-' button depending on screen
    val isHidden by remember { mutableStateOf<Boolean>(true) }


    // Actual list of all the tours to be added to the ToursList screen.
    val sampleTours = listOf(
        Tour(R.drawable.morocco, "Sahara Dessert", "Morocco's expansive dunes","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
        Tour(R.drawable.spain, "Sagrada Famillia", "A breathtaking church in Barcelona","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
        Tour(R.drawable.italy, "Rome","The capital of Italy","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
        Tour(R.drawable.aussie, "Kangaroo Island","A wildlife paradise in Australia","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."),
        Tour(R.drawable.japan, "Mount Fuji", "Japan's highest mountain","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
    )

    Column(Modifier.fillMaxSize().padding(5.dp)) {
        // LazyColum used to create the scrollable cards for the tours
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
        ) {
            // AI Aided work
            // Iterates over sampleTours and displays each in a 'TourCard'
            items(sampleTours){ tour ->
                // Adds actions to save or remove a tour from the list
                TourCards(tour, onSaveTour = { tourViewModel.addTour(it) }, onRemoveTour = {tourViewModel.removeTour(it)}, isHidden = isHidden)
            }
        }
        //end

        // Calls the footer function to show the button beneath the cards
        ToursListFooter(navController)
    }
}

@Composable
fun TourCards(tour: Tour, onSaveTour: (Tour) -> Unit, onRemoveTour: (Tour) -> Unit = {}, isHidden: Boolean) {
    // Variable used to check if the cards are expanded
    var isExpanded by remember { mutableStateOf<Boolean>(false) }
    val weatherState = remember { mutableStateOf(tour.weatherInfo) }

    val weatherCity = when(tour.title) {
        "Sahara Dessert" -> "Marrakech"
        "Sagrada Famillia" -> "Barcelona"
        "Rome" -> "Rome"
        "Kangaroo Island" -> "Melbourne"
        "Mount Fuji" -> "Tokyo"
        else -> tour.title
    }

    if (isExpanded && weatherState.value == null) {
        LaunchedEffect(Unit) {
            weatherState.value = WeatherAPI.getWeather(weatherCity)
            tour.weatherInfo = weatherState.value
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            // Allows card to be clickable
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

            // If the card has been clicked, it is expanded and 'extraInfo' is displayed to user
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = tour.extraInfo)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Weather in $weatherCity: ${weatherState.value ?: "Loading..."}")
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
            // Conditional used to toggle '-' button for My Tours
            } else {
                Button(
                    modifier = Modifier
                        .width(55.dp),
                    // Once the button is clicked, runs the onRemoveTour function to remove tour
                    onClick = {onRemoveTour(tour)},
                    // Red colour to specify deletion
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF8A80)),
                ) {
                    Text("-")
                }
            }

        }
    }
}

@Composable
fun ToursListFooter(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,

    ){
        // Button used to allow users to navigate to 'My Tours' screen
        Button(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            onClick = { navController.navigate("my_tours_screen")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA8E6CF))

        ) {
            Text("My Tours")
        }
    }

}