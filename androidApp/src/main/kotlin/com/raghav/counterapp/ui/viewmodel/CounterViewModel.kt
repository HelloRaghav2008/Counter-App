package com.raghav.counterapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.raghav.counterapp.ui.state.CounterState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    val uiState: StateFlow<CounterState>
        field = MutableStateFlow(CounterState(count = 0, incEnabled = true, decEnabled = false))

    fun increment() {
        uiState.update { current ->
            val newCount = current.count + 1
            current.copy(
                count = newCount,
                incEnabled = newCount < 10,
                decEnabled = newCount > 0
            )
        }
    }

    fun decrement() {
        uiState.update { current ->
            val newCount = current.count - 1
            current.copy(
                count = newCount,
                incEnabled = newCount < 10,
                decEnabled = newCount > 0
            )
        }
    }

    fun reset() {
        uiState.value = CounterState(count = 0, incEnabled = true, decEnabled = false)
    }

}