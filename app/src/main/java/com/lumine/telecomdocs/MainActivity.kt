package com.lumine.telecomdocs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lumine.telecomdocs.ui.theme.TelecomDocsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelecomDocsTheme {
                Navigation()
            }
        }
    }
}

