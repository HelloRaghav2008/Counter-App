package com.raghav.counterapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.raghav.counterapp.ui.state.CounterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CounterState(count = 0, incEnabled = true, decEnabled = false))
    val uiState = _uiState.asStateFlow()
    fun increment() {
        _uiState.update { current ->
            val newCount = current.count + 1
            current.copy(
                count = newCount,
                incEnabled = newCount < 10,
                decEnabled = newCount > 0
            )
        }
    }

    fun decrement() {
        _uiState.update { current ->
            val newCount = current.count - 1
            current.copy(
                count = newCount,
                incEnabled = newCount < 10,
                decEnabled = newCount > 0
            )
        }
    }

    fun reset() {
        _uiState.value = CounterState(count = 0, incEnabled = true, decEnabled = false)
    }

}