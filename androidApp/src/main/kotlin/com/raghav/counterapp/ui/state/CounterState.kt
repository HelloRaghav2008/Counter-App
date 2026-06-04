package com.raghav.counterapp.ui.state

data class CounterState(
    val count: Int,
    val incEnabled: Boolean,
    val decEnabled: Boolean
)