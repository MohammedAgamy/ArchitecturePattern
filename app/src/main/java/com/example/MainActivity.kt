package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.example.presentation.viewmodel.ModelMVVM
import com.example.presentation.ui.main.MainUi
import com.example.presentation.ui.theme.TryStateTheme
import com.example.presentation.viewmodel.ModelMVI
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val model: ModelMVI by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TryStateTheme {
                MainUi(model)
            }
        }
    }
}

