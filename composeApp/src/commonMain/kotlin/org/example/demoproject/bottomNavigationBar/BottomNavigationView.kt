package com.app.drivein.bottomNavigationBar

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.drivein.utils.Constants

class BottomNavigationView {
    @Composable
    fun BottomNavigationBar(navController: NavHostController) {

        BottomNavigation(

            // set background color 
            backgroundColor = Color(0xFF0F9D58)
        ) {

            // observe the backstack
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            // observe current route to change the icon
            // color,label color when navigated
            val currentRoute = navBackStackEntry?.destination?.route

            // Bottom nav items we declared
            Constants.BottomNavItems.forEach { navItem ->

                // Place the bottom nav items
                BottomNavigationItem(

                    // it currentRoute is equal then its selected route
                    selected = currentRoute == navItem.route,

                    // navigate on click
                    onClick = {
                        navController.navigate(navItem.route)
                    },

                    // Icon of navItem
                    icon = {
                        Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                    },

                    // label
                    label = {
                        Text(text = navItem.label)
                    },
                    alwaysShowLabel = false
                )
            }
        }
    }

    @Composable
    fun NavHostContainer(
        navController: NavHostController,
        padding: PaddingValues
    ) {

        NavHost(
            navController = navController,

            // set the start destination as home
            startDestination = "home",

            // Set the padding provided by scaffold
            modifier = Modifier.padding(paddingValues = padding),

            builder = {

                // route : Home
                composable("home") {
                    HomeScreen().HomeScreen()
                }

                // route : search
                composable("search") {
                    ActivityScreen().SearchScreen()
                }

                // route : profile
                composable("profile") {
                    MyAccountScreen().ProfileScreen()
                }
            })

    }


}