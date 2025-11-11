package com.deloitte.deloittetask.features.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deloitte.deloittetask.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val useCase: GetUserDataUseCase) : ViewModel() {

    private val _state = MutableStateFlow<UserState>(UserState.Loading)
    val state = _state.asStateFlow()

    init {
        loadUsers()
    }

    fun loadUsers() {
        viewModelScope.launch {
            _state.value = UserState.Loading
            try {
                val result = useCase.invoke()
                _state.value = UserState.Success(result)
            } catch (e: Exception) {
                _state.value = UserState.Error(e.message ?: "Something went wrong")
            }
        }
    }
}