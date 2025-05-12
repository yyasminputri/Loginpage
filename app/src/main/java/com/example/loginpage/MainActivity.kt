package com.example.loginpage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginPageTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFFFF6F6) // Light pink background
                ) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            // Avatar dan Background
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(bottom = 36.dp)
                    .size(120.dp)
            ) {
                // Background Circle dengan shadow - soft purple
                Surface(
                    modifier = Modifier
                        .size(120.dp)
                        .shadow(
                            elevation = 8.dp,
                            shape = CircleShape,
                            ambientColor = Color(0xFFD5CCFF)
                        ),
                    shape = CircleShape,
                    color = Color(0xFFE8E4FF) // Softer purple background
                ) {}

                // Application Icon Styled
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    // User Icon - Only profile icon with soft purple colors
                    Surface(
                        shape = CircleShape,
                        color = Color.White,
                        modifier = Modifier
                            .size(56.dp)
                            .shadow(4.dp, CircleShape)
                    ) {
                        Box(
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "User",
                                tint = Color(0xFFA388EE), // Soft purple icon
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                }
            }

            // Welcome text
            Text(
                text = "Welcome Back!",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF303030)
            )

            Text(
                text = "Login to your account",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 36.dp)
            )

            // Email field
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
                    .shadow(2.dp, RoundedCornerShape(12.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color(0xFF5D5FEF)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color.Gray
                    )
                }
            )

            // Password field
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .shadow(2.dp, RoundedCornerShape(12.dp)),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.LightGray,
                    focusedBorderColor = Color(0xFF5D5FEF)
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password",
                        tint = Color.Gray
                    )
                }
            )

            // Login button
            Button(
                onClick = { /* Handle login logic */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .shadow(4.dp, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8B85F3)
                )
            ) {
                Text(
                    "Login",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Or sign in with
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 24.dp)
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray
                )
                Text(
                    text = "Or sign in with",
                    color = Color.Gray,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = Color.LightGray
                )
            }

            // Social login buttons
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Google
                SocialLoginButton(
                    onClick = { /* Handle Google login */ },
                    icon = Icons.Default.Email,
                    tint = Color(0xFFDB4437),
                    backgroundColor = Color(0xFFFEE3E3)
                )

                // Facebook - menggunakan icon Person sebagai alternatif
                SocialLoginButton(
                    onClick = { /* Handle Facebook login */ },
                    icon = Icons.Default.Person,
                    tint = Color(0xFF4267B2),
                    backgroundColor = Color(0xFFE3E9FE)
                )

                // Apple - menggunakan icon Lock sebagai alternatif
                SocialLoginButton(
                    onClick = { /* Handle Apple login */ },
                    icon = Icons.Default.Lock,
                    tint = Color.Black,
                    backgroundColor = Color(0xFFECECEC)
                )
            }
        }
    }
}

@Composable
fun SocialLoginButton(
    onClick: () -> Unit,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    tint: Color,
    backgroundColor: Color
) {
    Surface(
        onClick = onClick,
        shape = CircleShape,
        color = backgroundColor,
        modifier = Modifier
            .size(48.dp)
            .shadow(4.dp, CircleShape)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Social Login",
                tint = tint,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginPageTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFFFF6F6) // Light pink background
        ) {
            LoginScreen()
        }
    }
}