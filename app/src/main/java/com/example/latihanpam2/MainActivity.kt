package com.example.latihanpam2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

private val Primary = Color(0xFF4F5BD5)
private val Background = Color(0xFFFAFAFD)
private val Surface = Color(0xFFFFFFFF)
private val OnSurface = Color(0xFF1C1B22)
private val OnSurfaceVariant = Color(0xFF5A5A66)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = lightColorScheme(primary = Primary, background = Background, surface = Surface)) {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "screen1") {
                    composable("screen1") { Screen1(navController) }
                    composable("screen2") { Screen2(navController) }
                }
            }
        }
    }
}

@Composable
fun BaseScreen(navController: NavHostController, content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = stringResource(R.string.nama),
            color = OnSurface,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.nim),
            color = OnSurfaceVariant,
            fontSize = 14.sp,
            modifier = Modifier.padding(top = 4.dp)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Surface),
            border = BorderStroke(1.dp, Color(0xFFE0E0E8))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                content()
            }
        }
    }
}

@Composable
fun Screen1(navController: NavHostController) {
    BaseScreen(navController) {
        Text(
            text = stringResource(R.string.screen_1),
            color = OnSurface,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = { navController.navigate("screen2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Primary)
        ) {
            Text(
                text = stringResource(R.string.ke_halaman_2),
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    BaseScreen(navController) {
        Text(
            text = stringResource(R.string.screen_2),
            color = OnSurface,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
