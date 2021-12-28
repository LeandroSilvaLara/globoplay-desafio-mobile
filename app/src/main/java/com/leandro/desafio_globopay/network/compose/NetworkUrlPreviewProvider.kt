package com.leandro.desafio_globopay.network.compose

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.leandro.desafio_globopay.R

class NetworkUrlPreviewProvider : PreviewParameterProvider<Int> {
    override val count: Int
        get() = super.count
    override val values: Sequence<Int>
        get() = sequenceOf(R.drawable.icon_youtube)
}
