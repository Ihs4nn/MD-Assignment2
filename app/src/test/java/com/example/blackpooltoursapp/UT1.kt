package com.example.blackpooltoursapp

import org.junit.Test
import org.junit.Assert.*

class UT1 {

    @Test
    fun addTourToSavedTours(){
        // Step 1
        val testViewModel = TourViewModel()
        // Step 2
        val testTour = Tour(
            image = 0,
            title = "testCity",
            desc = "testDesc",
            extraInfo = "testExtraInfo"
        )
        // Step 3
        testViewModel.addTour(testTour)
        assertTrue("testTour added to savedTours",testViewModel.savedTours.contains(testTour))
    }
}

