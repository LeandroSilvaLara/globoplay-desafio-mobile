package com.leandro.desafio_globopay.ui.main

import androidx.compose.foundation.lazy.LazyListState

data class HomeTabStateHolder (
    val movieLazyListState: LazyListState,
    val tvLazyListState: LazyListState,
    val peopleLazyListState: LazyListState,
)