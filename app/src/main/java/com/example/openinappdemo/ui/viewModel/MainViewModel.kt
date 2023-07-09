package com.example.openinappdemo.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openinappdemo.repository.UserRepository
import com.example.openinappdemo.models.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    val usersLiveData : LiveData<User>
        get() = repository.users

    init{
        viewModelScope.launch {
            repository.getUsersData()
        }
    }
}