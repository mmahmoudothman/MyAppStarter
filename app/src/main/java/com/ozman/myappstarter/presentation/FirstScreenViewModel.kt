package com.ozman.myappstarter.presentation

import android.net.ConnectivityManager
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozman.myappstarter.domain.model.AppDomainModel
import com.ozman.myappstarter.domain.use_case.AppUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(
    private val appUseCases: AppUseCases,
    private val connectivityManager: ConnectivityManager,
) : ViewModel() {

    var loading = mutableStateOf(false)
        private set
//
//    private val _state = mutableStateOf(FirstScreenState())
//    val state: State<FirstScreenState> = _state


    private var getDataJob: Job? = null

    init {
        getData()
    }

    private fun getData() {
        loading.value = true
        getDataJob?.cancel()
        getDataJob = appUseCases.getDataUseCase()
            .onEach { data ->
//                _state.value = state.value.copy(
//                    data = data
//                )
            }
            .launchIn(viewModelScope)
    }

    private fun deleteData(appDomainModel: AppDomainModel) {
        loading.value = true
        viewModelScope.launch { appUseCases.deleteDataUseCase(appDomainModel) }
    }
}