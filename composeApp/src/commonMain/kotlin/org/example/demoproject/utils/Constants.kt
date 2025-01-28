package com.app.drivein.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.app.drivein.bottomNavigationBar.models.BottomNavItem
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.*
import org.example.demoproject.bottomNavigationBar.HomeScreen.CarTypeModel

object Constants {
    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = Res.drawable.home,
            route = "home"
        ),
        BottomNavItem(
            label = "Activity",
            icon = Res.drawable.activity,
            route = "activity"
        ),
        BottomNavItem(
            label = "Account",
            icon = Res.drawable.account,
            route = "account"
        )
    )

    val carTypeList = listOf(
        CarTypeModel(
            label = "Standard",
            icon = Res.drawable.hatchback,
            route = "Standard"
        ),
        CarTypeModel(
            label = "Sedan",
            icon = Res.drawable.sedan,
            route = "Sedan"
        ),
        CarTypeModel(
            label = "SUV",
            icon = Res.drawable.suv,
            route = "SUV"
        ),
        CarTypeModel(
            label = "Premium",
            icon = Res.drawable.cabriolet,
            route = "Premium"
        ),
        CarTypeModel(
            label = "Minivan",
            icon = Res.drawable.minivan,
            route = "Minivan"
        )
    )
}