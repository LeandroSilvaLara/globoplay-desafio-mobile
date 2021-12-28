package com.leandro.desafio_globopay.initializer

import android.content.Context
import androidx.startup.Initializer
import com.leandro.desafio_globopay.BuildConfig
import timber.log.Timber

class TimberInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("TimberInitializer is initialized.")
        }
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = listOf(
        SandwichInitializer::class.java
    )
}