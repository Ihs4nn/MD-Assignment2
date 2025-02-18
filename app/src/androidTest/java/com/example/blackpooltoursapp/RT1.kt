
package com.example.blackpooltoursapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.navigation.compose.rememberNavController
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule


class RT1 {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun navigationalFlow() {
        val validUser = "user"
        val validPass = "pass"

        // Step 1
        composeTestRule.setContent {
            val testNavController = rememberNavController()
            MainScreen(testNavController)
        }
        // Step 2
        composeTestRule.onNode(hasText("Login") and hasClickAction()).performClick()

        // Step 3
        // Confirm we are in login screen
        composeTestRule.onNodeWithText("Username *").assertIsDisplayed()
        composeTestRule.onNodeWithText("Username *").performTextInput(validUser)
        composeTestRule.onNodeWithText("Password *").performTextInput(validPass)
        composeTestRule.onNode(hasText("Login") and hasClickAction()).performClick()

        // Step 4
        // Confirm we are in the tours list screen
        composeTestRule.onNodeWithText("My Tours").assertIsDisplayed()
        composeTestRule.onNode(hasText("My Tours") and hasClickAction()).performClick()

        // Step 5
        // Confirm we are in the my tours screen
        composeTestRule.onNodeWithText("My Saved Tours").assertIsDisplayed()
        composeTestRule.onNode(hasText("Back to tours") and hasClickAction()).performClick()
        // Confirm we are back to tours list screen
        composeTestRule.onNodeWithText("My Tours").assertIsDisplayed()



    }


}