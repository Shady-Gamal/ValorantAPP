package com.example.valorant


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onNavigationIconClick: ()-> Unit
) {

   TopAppBar(
       title = { null
               },
       navigationIcon = {
           IconButton(onClick = onNavigationIconClick) {
               Icon(painter = painterResource(id = R.drawable.navigation_icon), contentDescription = null,
              tint = Color.Red)

           }
       }

   )

}