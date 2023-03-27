package com.consultingmine.spindox.beer.presentation.main

import com.consultingmine.spindox.beer.data.model.BeerModel
import com.consultingmine.spindox.beer.viewmodels.ViewEvent
import com.consultingmine.spindox.beer.viewmodels.ViewSideEffect
import com.consultingmine.spindox.beer.viewmodels.ViewState

class MainScreenContract {
    sealed class Event : ViewEvent {
        data class NewSearch(
            val value: String
        ) : Event()
    }

    enum class Status {
        IDLE,
        LOADING,
        NETWORK_ERROR
    }

    data class State(
        val status: Status,
        val beers: List<BeerModel>,
        val search: String?
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        // NOPE
    }
}