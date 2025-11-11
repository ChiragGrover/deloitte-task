package com.deloitte.deloittetask.data.api

import com.deloitte.deloittetask.domain.model.User
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUsersList() : List<User>
}