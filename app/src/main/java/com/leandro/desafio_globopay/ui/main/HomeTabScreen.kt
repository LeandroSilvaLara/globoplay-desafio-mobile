package com.leandro.desafio_globopay.ui.main

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.leandro.desafio_globopay.ui.movie.MovieScreen
import com.leandro.desafio_globopay.ui.people.PeopleScreen
import com.leandro.desafio_globopay.ui.theme.purple200
import com.leandro.desafio_globopay.ui.tv.TvScreen


@Composable
fun HomeTabScreen(
    viewModel: MainViewModel,
    tabStateHolder: HomeTabStateHolder,
    selectItem: (MainScreenHomeTab, Long) -> Unit
) {
    val selectedTab by viewModel.selectedTab
    val tabs = MainScreenHomeTab.values()

    Scaffold(
        backgroundColor = MaterialTheme.colors.primarySurface,
        topBar = { MainAppBar() },
        bottomBar = {

            BottomNavigation(
                backgroundColor = purple200,
                modifier = Modifier
                    .navigationBarsHeight(56.dp)
            ) {

                tabs.forEach { tab ->
                    BottomNavigationItem(
                        icon = { Icon(imageVector = tab.icon, contentDescription = null) },
                        label = { Text(text = stringResource(tab.title), color = Color.White) },
                        selected = tab == selectedTab,
                        onClick = { viewModel.selectTab(tab) },
                        selectedContentColor = LocalContentColor.current,
                        unselectedContentColor = LocalContentColor.current,
                        modifier = Modifier.navigationBarsPadding()
                    )
                }
            }
        }
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)

        Crossfade(selectedTab) { destination ->
            when (destination) {
                MainScreenHomeTab.MOVIE -> MovieScreen(
                    viewModel,
                    selectItem,
                    tabStateHolder.movieLazyListState,
                    modifier,
                )
                MainScreenHomeTab.TV -> TvScreen(
                    viewModel,
                    selectItem,
                    tabStateHolder.tvLazyListState,
                    modifier,
                )
                MainScreenHomeTab.PERSON -> PeopleScreen(
                    viewModel,
                    selectItem,
                    tabStateHolder.peopleLazyListState,
                    modifier,
                )
            }
        }
    }
}
