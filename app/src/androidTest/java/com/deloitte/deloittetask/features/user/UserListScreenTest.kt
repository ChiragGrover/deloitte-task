package com.deloitte.deloittetask.features.user

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.deloitte.deloittetask.domain.model.User
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserListScreenTest {
    private lateinit var viewModel: UserViewModel

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup() {
        viewModel = mockk<UserViewModel>(relaxed = true)
    }

    @Test
    fun showSuccessState_displaysLoading() {
        every { viewModel.state } returns MutableStateFlow(UserState.Loading)

        composeTestRule.setContent {
            UserListScreen(viewModel)
        }

        // THEN
        composeTestRule.onNodeWithTag("Progress Indicator").assertExists()
    }

    @Test
    fun showSuccessState_displaysUserData() {
        val fakeUserList = listOf(
            User(id = 1, username = "chirag93", email = "abc@gmail.com", photo = "https://images")
        )

        every { viewModel.state } returns MutableStateFlow(UserState.Success(fakeUserList))

        composeTestRule.setContent {
            UserListScreen(viewModel)
        }

        // THEN
        composeTestRule.onNodeWithText("chirag93").assertIsDisplayed()
    }

    @Test
    fun showSuccessState_displaysError() {
        every { viewModel.state } returns MutableStateFlow(UserState.Error("Network Error"))

        composeTestRule.setContent {
            UserListScreen(viewModel)
        }

        // THEN
        composeTestRule.onNodeWithText("Network Error").assertIsDisplayed()
    }
}