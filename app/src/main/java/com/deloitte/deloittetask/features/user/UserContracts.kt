package com.deloitte.deloittetask.features.user

import com.deloitte.deloittetask.domain.model.User

sealed interface UserState {
    object Loading : UserState
    data class Success(val users: List<User>) : UserState
    data class Error(val message: String) : UserState
}