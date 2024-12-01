package com.iqsoft.yearbookofwins.presentation

import com.iqsoft.yearbookofwins.data.WinObject
import com.iqsoft.yearbookofwins.data.WinsRepository
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.stateIn
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

class ListViewModel(winsRepository: WinsRepository) : ViewModel() {
    @NativeCoroutinesState
    val objects: StateFlow<List<WinObject>> =
        winsRepository.getWins()
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
}
