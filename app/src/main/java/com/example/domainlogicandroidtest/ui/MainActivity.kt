package com.example.domainlogicandroidtest.ui

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domainlogicandroidtest.ui.formulary.Formulary
import com.example.domainlogicandroidtest.ui.formulary.FormularyContract
import com.example.domainlogicandroidtest.ui.formulary.FormularyPresenter
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLEncoder
import java.nio.charset.StandardCharsets
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity(), FormularyContract.View {

    @Inject
    lateinit var presenter: FormularyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navHostController = rememberNavController()

            NavigationGraph(navController = navHostController)
        }
    }

    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "formulary") {
            composable("formulary") { Formulary(presenter){
                navController.navigate("webview/${URLEncoder.encode(it, StandardCharsets.UTF_8.toString())}")
            } }
            composable("webview/{url}") { backStackEntry ->
                WebViewScreen(url = backStackEntry.arguments?.getString("url") ?: "", navController)
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun WebViewScreen(url: String, navController: NavController) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "Web View") },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    },
                )
            }
        ) { innerPadding ->
            AndroidView(
                factory = { ctx ->
                    WebView(ctx).apply {
                        webViewClient = WebViewClient()
                        loadUrl(url)
                    }
                },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            )
        }
    }
}