package com.example.valorant.navigation

sealed class Screen(val route : String){
object HomeScreen : Screen("main_screen")
object AgentScreen : Screen("agents_screen")
    object AgentDetailsScreen : Screen("agentDetails_screen")
    object WeaponsScreen : Screen("weapons_screen")

    object BundlesScreen : Screen("bundles_screen")

    object PlayerCardsScreen : Screen("playerCards_screen")
    object SpraysScreen : Screen("spray_screen")
    object BuddiesScreen : Screen("buddies_screen")

    object MapsScreen : Screen("maps_screen")

    object WeaponDetailsScreen : Screen("weaponDetails_screen")
    object WeaponSkinsScreen : Screen("weaponSkins_screen")






}
