package org.example.demoproject.UI

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import demoproject.composeapp.generated.resources.Res
import demoproject.composeapp.generated.resources.car
import demoproject.composeapp.generated.resources.facebook
import demoproject.composeapp.generated.resources.google
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

class MyAccountScreen {
    @Composable
    fun ProfileScreen() {
        // Column Composable,
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignupScreen()
        }
    }

    @Composable
    fun SignupScreen() {
        val phoneNumber = remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "Set up your account.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Enter your phone number:")
            Spacer(modifier = Modifier.height(8.dp))

            PhoneNumberInput()

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { /* Handle Continue */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF665FF0) // Set background color to blue
                )
            ) {
                Text(
                    "Continue",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier.background(Color(0xFF665FF0))
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text("or", fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(16.dp))

            SocialButton(
                iconRes = Res.drawable.car,
                text = "Continue with Apple",
                bgColor = Color.LightGray
            )
            SocialButton(
                iconRes = Res.drawable.facebook,
                text = "Continue with Facebook",
                bgColor = Color(0xFF665FF0)
            )
            SocialButton(
                iconRes = Res.drawable.google,
                text = "Continue with Google",
                bgColor = Color(0xFFFFCDD2)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "By signing up, you agree to Drive In’s Terms of Service and Privacy Policy.",
                fontSize = 12.sp,
                color = Color.Gray
            )
        }
    }

    @Composable
    fun SocialButton(iconRes: DrawableResource, text: String, bgColor: Color) {
        Button(
            onClick = { /* Handle Social Login */ },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = bgColor),
            shape = RoundedCornerShape(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Image(
                    painter = painterResource(iconRes),
                    contentDescription = text,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text, fontSize = 16.sp, color = Color.Black)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}