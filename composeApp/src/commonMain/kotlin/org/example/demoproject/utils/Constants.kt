package com.app.drivein.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.app.drivein.bottomNavigationBar.models.BottomNavItem
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.account
import demoproject.composeapp.generated.resources.activity
import demoproject.composeapp.generated.resources.home

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
}