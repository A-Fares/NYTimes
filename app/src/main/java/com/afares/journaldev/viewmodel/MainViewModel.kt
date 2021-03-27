package com.afares.journaldev.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.afares.journaldev.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {


}