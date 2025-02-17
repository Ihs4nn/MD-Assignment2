package com.example.blackpooltoursapp

import org.junit.Test
import org.junit.Assert.*

class UT2 {

    @Test
    fun removeTourInSavedTours(){
        // Step 1
        val testViewModel = TourViewModel()
        val testTour = Tour(
            image = 0,
            title = "testCity",
            desc = "testDesc",
            extraInfo = "testExtraInfo"
        )
        testViewModel.addTour(testTour)
        // Step 2
        testViewModel.removeTour(testTour)
        assertTrue(testViewModel.savedTours.isEmpty())

    }
}