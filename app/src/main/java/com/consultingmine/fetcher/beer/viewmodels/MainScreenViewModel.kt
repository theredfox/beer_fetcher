package com.consultingmine.fetcher.beer.viewmodels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.consultingmine.fetcher.beer.data.actions.GetBeers
import com.consultingmine.fetcher.beer.presentation.main.MainScreenContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getBeers: GetBeers
) : BaseViewModel<MainScreenContract.Event, MainScreenContract.State, MainScreenContract.Effect>() {

    private val beersPerPage = 25

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        Log.e(MainScreenViewModel::class.java.name, exception.message ?: "")
        setState {
            copy(
                status = MainScreenContract.Status.NETWORK_ERROR
            )
        }
    }

    init {
        viewModelScope.launch(errorHandler) {
            getBeers(1, beersPerPage)
        }
    }

    override fun setInitialState(): MainScreenContract.State = MainScreenContract.State(
        status = MainScreenContract.Status.IDLE,
        beers = listOf()
    )

    override fun handleEvents(event: MainScreenContract.Event) {
        when(event) {
            is MainScreenContract.Event.NewSearch -> setState {
                copy(
                    search = event.value
                )
            }
        }
    }

    private suspend fun getBeers(page: Int?, perPage: Int?) {
        showLoading()
        getBeers.execute(page, perPage)
            .catch {
                setState {
                    copy(
                        status = MainScreenContract.Status.NETWORK_ERROR
                    )
                }
            }. collect { beers ->
                setState {
                    copy(
                        status = MainScreenContract.Status.IDLE,
                        beers = beers
                    )
                }
            }
    }

    private fun showLoading() = setState {
        copy(
            status = MainScreenContract.Status.LOADING
        )
    }

}