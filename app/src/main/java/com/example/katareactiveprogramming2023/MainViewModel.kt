package com.example.katareactiveprogramming2023

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.katareactiveprogramming2023.connectivity.ConnectivityObserver
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val connectivity: ConnectivityObserver,
) : ViewModel() {

    private val _isConnectedMutableStateFlow = MutableStateFlow(true)
    val isConnectedStateFlow: StateFlow<Boolean> = _isConnectedMutableStateFlow.asStateFlow()

    private val _isConnectedMutableSharedFlowWithEmit = MutableSharedFlow<Boolean>()
    val isConnectedSharedFlowWithEmit: SharedFlow<Boolean> = _isConnectedMutableSharedFlowWithEmit.asSharedFlow()

    private val _isConnectedMutableSharedFlowWithTryEmit = MutableSharedFlow<Boolean>()
    val isConnectedSharedFlowWithTryEmit: SharedFlow<Boolean> = _isConnectedMutableSharedFlowWithTryEmit.asSharedFlow()

    init {
        connectivity.observe().onEach {
            _isConnectedMutableStateFlow.value = it
        }.launchIn(viewModelScope)

        connectivity.observe().onEach {
            _isConnectedMutableSharedFlowWithEmit.emit(it)
        }.launchIn(viewModelScope)

        connectivity.observe().onEach {
            _isConnectedMutableSharedFlowWithTryEmit.tryEmit(it)
        }
    }


}