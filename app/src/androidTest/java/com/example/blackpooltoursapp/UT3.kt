package com.example.blackpooltoursapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule


class UT3 {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun invalidLoginCredentials() {
        val invalidUser = "use"
        val invalidPass = "pas"

        // Step 1
        composeTestRule.setContent{
            val testNavController = rememberNavController()
            LoginScreen(testNavController)
        }
        // Step 2
        composeTestRule.onNodeWithText("Username *").performTextInput(invalidUser)
        composeTestRule.onNodeWithText("Password *").performTextInput(invalidPass)
        // Step 3
        composeTestRule.onNodeWithText("Login").performClick()
        composeTestRule.onNodeWithText("Invalid username or password.").assertIsDisplayed()
    }
}