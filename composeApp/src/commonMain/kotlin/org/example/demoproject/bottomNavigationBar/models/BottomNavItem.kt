package com.app.drivein.bottomNavigationBar.models

import org.jetbrains.compose.resources.DrawableResource

data class BottomNavItem(
    val label: String,
    val icon: DrawableResource,
    val route:String,
)