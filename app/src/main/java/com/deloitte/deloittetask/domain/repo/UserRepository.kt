package com.deloitte.deloittetask.domain.repo

import com.deloitte.deloittetask.domain.model.User

interface UserRepository {
    suspend fun getUsersList() : List<User>
}