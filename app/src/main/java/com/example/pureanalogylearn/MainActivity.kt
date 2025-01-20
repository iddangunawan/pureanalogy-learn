package com.example.pureanalogylearn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.pureanalogylearn.ui.base.navigation.AppNavHost
import com.example.pureanalogylearn.ui.theme.PureanalogylearnTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PureanalogylearnTheme {
                AppNavHost()
            }
        }
    }
}
