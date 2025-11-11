package com.deloitte.deloittetask.data.repo

import com.deloitte.deloittetask.data.api.ApiService
import com.deloitte.deloittetask.domain.model.User
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class UserRepositoryImplTest {
    private lateinit var apiService: ApiService
    private lateinit var userRepositoryImpl: UserRepositoryImpl

    @Before
    fun setup() {
        apiService = mock(ApiService::class.java)
        userRepositoryImpl = UserRepositoryImpl(apiService)
    }

    @Test
    fun `should return user list from api service`() = runBlocking {
        val fakeUserList = listOf(
            User(id = 1, username = "chirag93", email = "abc@gmail.com", photo = "https://images")
        )
        `when`(apiService.getUsersList()).thenReturn(fakeUserList)
        val result = userRepositoryImpl.getUsersList()
        verify(apiService, times(1)).getUsersList()
        assertEquals(result, fakeUserList)
    }
}