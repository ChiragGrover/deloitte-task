package com.deloitte.deloittetask.features.user

import com.deloitte.deloittetask.domain.model.User
import com.deloitte.deloittetask.domain.repo.UserRepository
import com.deloitte.deloittetask.domain.usecase.GetUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class UserViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var userRepository: UserRepository
    private lateinit var useCase: GetUserDataUseCase
    private lateinit var viewModel: UserViewModel


    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        userRepository = mock(UserRepository::class.java)
        useCase = GetUserDataUseCase(userRepository)
        viewModel = UserViewModel(useCase)
    }

    @Test
    fun `loadUsers emits Success when use case succeeded`() = runTest {
        val fakeUserList = listOf(
            User(id = 1, username = "chirag93", email = "abc@gmail.com", photo = "https://images")
        )
        `when`(useCase.invoke()).thenReturn(fakeUserList)
        // When
        viewModel.loadUsers()
        // Then
        testDispatcher.scheduler.advanceUntilIdle()
        val state = viewModel.state.value
        assertTrue(state is UserState.Success)
    }

    @Test
    fun `loadUsers emits Error when use case failed`() = runTest {
        `when`(useCase.invoke()).thenThrow(RuntimeException("Network error"))
        // When
        viewModel.loadUsers()
        // Then
        testDispatcher.scheduler.advanceUntilIdle()
        val state = viewModel.state.value
        assertTrue(state is UserState.Error)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}