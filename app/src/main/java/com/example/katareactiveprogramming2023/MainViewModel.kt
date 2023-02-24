package com.example.katareactiveprogramming2023

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katareactiveprogramming2023.connectivity.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class MainViewModel(
    private val connectivity: ConnectivityObserver,
) : ViewModel() {

    private val _isConnected = MutableStateFlow(true)
    val isConnected: StateFlow<Boolean> = _isConnected.asStateFlow()

    init {
        connectivity.observe().onEach {
            _isConnected.value = it
        }.launchIn(viewModelScope)
    }
}