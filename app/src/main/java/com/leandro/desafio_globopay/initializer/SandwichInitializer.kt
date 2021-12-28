package com.leandro.desafio_globopay.initializer

import android.content.Context
import androidx.startup.Initializer
import com.leandro.desafio_globopay.operator.GlobalResponseOperator
import com.skydoves.sandwich.SandwichInitializer

class SandwichInitializer : Initializer<Unit> {

    override fun create(context: Context) {

        // initialize global sandwich operator
        SandwichInitializer.sandwichOperator = GlobalResponseOperator<Unit>(context)
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
