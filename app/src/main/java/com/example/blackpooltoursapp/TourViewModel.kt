package com.example.blackpooltoursapp
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

// AI Aided work
/// ViewModel to manage the list of saved tours
class TourViewModel : ViewModel() {
    // A variable private mutable list to store saved tours
    private val _savedTours = mutableStateListOf<Tour>()
    // A public read-only list to expose the saved tours
    val savedTours: List<Tour> get() = _savedTours

    // Adds a new tour to the saved list if it doesn't already exist
    fun addTour(tour: Tour) {
        // Prevents adding duplicate tours to the list
        if (tour !in _savedTours) {
            _savedTours.add(tour)
        }
    }
//end
    // Function used to remove specific tour
    fun removeTour(tour: Tour){
        _savedTours.remove(tour)
    }
}
