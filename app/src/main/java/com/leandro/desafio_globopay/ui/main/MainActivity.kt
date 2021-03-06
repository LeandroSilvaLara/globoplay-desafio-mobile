package com.leandro.desafio_globopay.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.CompositionLocalProvider
import com.leandro.desafio_globopay.ui.theme.MovieComposeTheme
import com.skydoves.landscapist.coil.LocalCoilImageLoader
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider(LocalCoilImageLoader provides viewModel.imageLoader) {

                MovieComposeTheme {

                    MainScreen()
                }
            }
        }
    }


}
