package com.example.valorant

import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource

data class MenuItem(
    val id : String,
    val title : String,
    val icon : Int
)

val navigationList : List<MenuItem> = listOf(
    MenuItem(Screen.AgentScreen.route,"Agents", R.drawable.agents),
    MenuItem("Screen","Maps", R.drawable.maps),
    MenuItem(Screen.WeaponsScreen.route ,"Guns", R.drawable.guns),
    MenuItem("Seemore","See More", R.drawable.seemore)
)