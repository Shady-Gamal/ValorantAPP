package com.example.valorant.ui.sprays_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetSpraysUSeCase
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpraysViewModel @Inject constructor(
    val getSpraysUSeCase: GetSpraysUSeCase
) : ViewModel() {

    init {
        getSprays()
    }
var spraysState by mutableStateOf(SpraysState())
    fun getSprays(){

        viewModelScope.launch {
            getSpraysUSeCase.invoke().collect{
                when (it){
                    is Resource.Success -> spraysState = spraysState.copy(
                        spraysInfo = it.data
                    )
                    is Resource.Error ->  spraysState = spraysState.copy(
                        error = it.message
                    )
                    is Resource.Loading -> spraysState = spraysState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }
}