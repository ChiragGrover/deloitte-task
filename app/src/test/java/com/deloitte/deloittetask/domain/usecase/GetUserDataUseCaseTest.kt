package com.deloitte.deloittetask.domain.usecase

import com.deloitte.deloittetask.domain.model.User
import com.deloitte.deloittetask.domain.repo.UserRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class GetUserDataUseCaseTest {

    private lateinit var mockUserRepository: UserRepository
    private lateinit var getUserDataUseCase: GetUserDataUseCase

    @Before
    fun setup() {
        mockUserRepository = mock(UserRepository::class.java)
        getUserDataUseCase = GetUserDataUseCase(mockUserRepository)
    }

    @Test
    fun `invoke should return user list from repository`() = runBlocking {
        val fakeUserList = listOf(
            User(id = 1, username = "chirag93", email = "abc@gmail.com", photo = "https://images")
        )
        `when`(mockUserRepository.getUsersList()).thenReturn(fakeUserList)
        val result = getUserDataUseCase.invoke()
        verify(mockUserRepository, times(1)).getUsersList()
        assertEquals(result, fakeUserList)
    }
}