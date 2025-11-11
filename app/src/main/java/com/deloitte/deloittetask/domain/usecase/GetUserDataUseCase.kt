package com.deloitte.deloittetask.domain.usecase

import com.deloitte.deloittetask.domain.model.User
import com.deloitte.deloittetask.domain.repo.UserRepository

class GetUserDataUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(): List<User> {
        return userRepository.getUsersList()
    }
}