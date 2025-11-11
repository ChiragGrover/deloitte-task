package com.deloitte.deloittetask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.deloitte.deloittetask.navigation.AppNavGraph
import com.deloitte.deloittetask.ui.theme.DeloitteTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DeloitteTaskTheme {
                AppNavGraph(rememberNavController())
            }
        }
    }
}