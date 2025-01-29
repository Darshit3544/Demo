package org.example.demoproject.UI

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.drivein.utils.Constants
import org.example.demoproject.UI.HomeScreen.HomeScreen
import org.jetbrains.compose.resources.painterResource

class BottomNavigationView {
    @Composable
    fun BottomNavigationBar(navController: NavHostController) {

        var selectedItem by remember { mutableStateOf(0) }

        BottomNavigation(

            // set background color
            backgroundColor = Color(0xFFFFFFFF),
        ) {

            // observe the backstack
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            // observe current route to change the icon
            // color,label color when navigated
            val currentRoute = navBackStackEntry?.destination?.route

            // Bottom nav items we declared
            Constants.BottomNavItems.forEachIndexed {index, navItem ->
                val isSelected = selectedItem == index
                val scale by animateFloatAsState(if (isSelected) 1.2f else 1f, label = "icon_scale")
                val iconColor = if (isSelected) Color.Black else Color.LightGray
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
                        Crossfade(targetState = isSelected, label = "icon_crossfade") {
                            Image(
                                painter = painterResource(navItem.icon),
                                contentDescription = navItem.label,
                                modifier = Modifier.size(25.dp),
                            )
                        }
                    },

                    // label
                    label = {
                        Text(text = navItem.label, fontSize = 10.sp)
                    },
                    selectedContentColor = Color.Black,
                    unselectedContentColor = Color.LightGray,
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
                    HomeScreen().HomeScreen(navController)
                }

                // route : search
                composable("activity") {
                    ActivityScreen().SearchScreen()
                }

                // route : profile
                composable("account") {
                    MyAccountScreen().ProfileScreen()
                }

                // route : whereTo
                composable("WhereToScreen") {
                    whereToLayout(navController = navController)
                }
            })

    }


}