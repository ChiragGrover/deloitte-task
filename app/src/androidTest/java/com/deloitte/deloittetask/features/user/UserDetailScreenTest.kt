package com.deloitte.deloittetask.features.user

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.deloitte.deloittetask.domain.model.User
import com.google.gson.Gson
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserDetailScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun show_userData() {
        val user = User(1, "chirag93", "abc@gmail.com", "https://images")
        val userJson = Gson().toJson(user)
        composeTestRule.setContent {
            UserDetailScreen(userJson)
        }

        // THEN
        composeTestRule.onNodeWithText("chirag93").assertIsDisplayed()
    }
}