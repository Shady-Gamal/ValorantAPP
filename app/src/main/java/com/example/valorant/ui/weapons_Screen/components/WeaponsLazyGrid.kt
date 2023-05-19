package com.example.valorant.ui.weapons_Screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.valorant.ui.theme.PinkForLazyRows
import com.example.valorant.ui.weapons_Screen.WeaponState

@Composable
fun WeaponsLazyGrid(
    weaponState : WeaponState
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {

        items(weaponState.weaponsInfo?.size ?: 0){

            Card(modifier = Modifier
                .width(200.dp)
                .height(120.dp)
                .padding(end = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(color = PinkForLazyRows)
                        .fillMaxSize()) {

                    Text(text = weaponState.weaponsInfo?.get(it)?.displayName ?: "Unknown" ,
                        modifier = Modifier
                            .align(Alignment.TopCenter)
                            .padding(top = 5.dp))
                    Spacer(modifier = Modifier.height(10.dp))

                    AsyncImage(model = weaponState.weaponsInfo?.get(it)?.displayIcon, contentDescription = null
                        , modifier = Modifier
                            .align(Alignment.Center)
                            .sizeIn(maxWidth = 180.dp, maxHeight = 70.dp)
                    )
                }
            }



        }


    })
}