package com.deloitte.deloittetask.data.repo

import com.deloitte.deloittetask.data.api.ApiService
import com.deloitte.deloittetask.domain.model.User
import com.deloitte.deloittetask.domain.repo.UserRepository

class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {

    override suspend fun getUsersList(): List<User> {
        return apiService.getUsersList()
    }
}