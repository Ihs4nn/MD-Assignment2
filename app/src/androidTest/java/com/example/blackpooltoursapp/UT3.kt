package com.example.blackpooltoursapp

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule


class UT3 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun invalidLoginCredentials() {
        val user = "usr"
        val pass = "pas"

        composeTestRule.setContent{
            LoginScreen()
        }

    }
}