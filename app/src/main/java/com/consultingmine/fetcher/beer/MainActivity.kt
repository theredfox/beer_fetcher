package com.consultingmine.fetcher.beer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.consultingmine.fetcher.beer.viewmodels.MainScreenViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.consultingmine.fetcher.beer.presentation.main.MainScreen
import com.consultingmine.fetcher.beer.presentation.main.MainScreenContract
import com.consultingmine.fetcher.beer.presentation.navigation.BeerScreens
import com.consultingmine.fetcher.beer.ui.theme.BeerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreenNavigator()
                }
            }
        }
    }
}

@Composable
fun MainScreenNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = BeerScreens.Home.route) {
        composable(BeerScreens.Home.route) {
            InitMainScreen(navController)
        }
    }
}

@Composable
fun InitMainScreen(
    navController: NavController
) {
    val viewModel: MainScreenViewModel = hiltViewModel()
    val listState = rememberLazyListState()

    MainScreen(
        listState = listState,
        state = viewModel.viewState.value,
        onNewSearch = { search ->
            viewModel.setEvent(MainScreenContract.Event.NewSearch(search))
        }
    )
}