package com.example.blackpooltoursapp
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

// AI Aided work
class TourViewModel : ViewModel() {
    private val _savedTours = mutableStateListOf<Tour>()
    val savedTours: List<Tour> get() = _savedTours

    fun addTour(tour: Tour) {
        if (tour !in _savedTours) {
            _savedTours.add(tour)
        }
    }
//end
    fun removeTour(tour: Tour){
        _savedTours.remove(tour)
    }
}
