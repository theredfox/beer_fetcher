package com.consultingmine.spindox.beer.presentation.navigation

sealed class BeerScreens(
    val route: String
) {
    object Home : BeerScreens(
        route = "home"
    )

    object BeerDetail : BeerScreens(
        route = "beer-detail"
    )
}