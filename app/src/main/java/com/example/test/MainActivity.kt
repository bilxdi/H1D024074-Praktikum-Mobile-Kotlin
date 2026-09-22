package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test.ui.screen.BasicInfoScreen
import com.example.test.ui.screen.HubungiKamiScreen
import com.example.test.ui.theme.TestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "basic_info") {
                        composable("basic_info") {
                            BasicInfoScreen(
                                onNavigateToContact = { navController.navigate("form_screen") }
                            )
                        }
                        composable("form_screen") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//@Composable
//fun LayoutTentangJualan() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Box(
//            modifier = Modifier
//                .size(100.dp)
//                .clip(CircleShape)
//                .background(Color.Gray),
//            contentAlignment = Alignment.Center
//        ) {
//            Column() {
////                Image(
////                    painter = painterResource(id = R.drawable.ic_launcher_round),
////                    contentDescription = "Jualan".toString(),
////                    modifier = Modifier.size(150.dp),
////                    contentScale = ContentScale.Crop
////                )
//
//                Text("Jualan", color = Color.White, fontWeight = FontWeight.Bold)
//            }
//        }
//
//        Spacer(modifier = Modifier.height(24.dp))
//
//        Text(
//            text = "Tentang Jualan",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(
//            text = "Aplikasi Jualan adalah platform yang mewadahi produk lokal UMKM di wilayah Kabupaten Purbalinggan, Jawa Tengah.",
//            fontSize = 16.sp,
//            modifier = Modifier.padding(horizontal = 16.dp)
//        )
//
//        Spacer(modifier = Modifier.height(32.dp))
//
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(Color(0xFFE0E0E0))
//                .padding(16.dp)
//        ) {
//            Text(
//                text = "Misi Kami:",
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.weight(1f)
//            )
//            Text(
//                text = "Memajukan UMKM Lokal",
//                modifier = Modifier.weight(2f)
//            )
//        }
//    }
//}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestTheme {
        Greeting("Android")
    }
}