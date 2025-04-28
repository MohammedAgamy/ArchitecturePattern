package com.example.event

sealed class StatesEvent {
    object Idle : StatesEvent()
    object Loading : StatesEvent()
    data class Success(val message: String) : StatesEvent()
    data class Error(val error: String) : StatesEvent()
}