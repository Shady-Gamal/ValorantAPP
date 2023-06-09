package com.example.valorant.ui.maps_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entities.Resource
import com.example.domain.usecases.GetMapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
val getMapsUseCase: GetMapsUseCase
) : ViewModel() {

    var mapsState by mutableStateOf(MapsState())

    init {
        getMaps()
    }

    fun getMaps(){
        viewModelScope.launch {
            mapsState = mapsState.copy(
                isLoading = true
            )
            getMapsUseCase.invoke().collect{
            mapsState = mapsState.copy( isLoading = true
         )
                when (it){
                    is Resource.Success -> mapsState = mapsState.copy(
                        mapsInfo = it.data
                    )
                    is Resource.Error -> mapsState = mapsState.copy(
                        error = it.message
                    )
                    is Resource.Loading -> mapsState = mapsState.copy(
                        isLoading = true
                    )

                }
            }
        }
    }



}