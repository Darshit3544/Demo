package org.example.demoproject.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.home
import demoproject.composeapp.generated.resources.user_photo
import org.jetbrains.compose.resources.painterResource

class ProfileScreen {

    @Composable
    fun profileScreen(navController: NavHostController) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TopBar(navController)
            Column(
                modifier = Modifier.fillMaxSize().padding(top = 15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ProfileSection()
                Spacer(modifier = Modifier.height(16.dp))
                SettingsOptions()
            }
        }
    }

    @Composable
    fun TopBar(navController: NavHostController) {
        Row(modifier = Modifier.fillMaxWidth()) {
            androidx.compose.material3.IconButton(onClick = { navController.navigateUp() }) {
                androidx.compose.material3.Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }

            Text(
                text = "My Profile",
                fontSize = 25.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
        }
    }

    @Composable
    fun ProfileSection() {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.user_photo),
                contentDescription = "Profile Picture",
                modifier = Modifier.size(250.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Darshit Patel", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "(807) 358-3522", fontSize = 16.sp, color = Color.Gray)
            Text(text = "darshitpatel318@gmail.com", fontSize = 16.sp, color = Color.Gray)
        }
    }

    @Composable
    fun SettingsOptions() {
        Column(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { /* Edit Information */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6B63FF))
            ) {
                Text(text = "✏ Edit Information", fontSize = 16.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { /* Manage Account */ },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF6B63FF))
            ) {
                Text(text = "⚙ Manage Account Settings", fontSize = 16.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Change Password",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 4.dp).clickable { })
            Text(
                text = "Payment Methods",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 4.dp).clickable { })
            Text(
                text = "Ride Preferences",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(vertical = 4.dp).clickable { })
        }
    }

}