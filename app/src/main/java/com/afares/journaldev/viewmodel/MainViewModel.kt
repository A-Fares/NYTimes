package com.afares.journaldev.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.afares.journaldev.data.Repository
import com.afares.journaldev.model.ArticleResponse
import com.afares.journaldev.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {

    var articlesResponse: MutableLiveData<NetworkResult<ArticleResponse>> = MutableLiveData()

    fun getArticles(period: String) = viewModelScope.launch {
        getArticlesSafeCall(period)
    }

    private suspend fun getArticlesSafeCall(period: String) {
        articlesResponse.value = NetworkResult.Loading()
        if (hasInternetConnection()) {
            try {
                val response = repository.remote.getArticles(period)
                articlesResponse.value = handleFoodArticlesResponse(response)
            } catch (e: Exception) {
                articlesResponse.value = NetworkResult.Error("Articles Not Found.")
            }
        } else {
            articlesResponse.value = NetworkResult.Error("No Internet Connection.")
        }
    }


    private fun handleFoodArticlesResponse(response: Response<ArticleResponse>): NetworkResult<ArticleResponse>? {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResult.Error("Timeout")
            }
            response.code() == 402 -> {
                return NetworkResult.Error("API Key Limited.")
            }
            response.body()!!.articles.isNullOrEmpty() -> {
                return NetworkResult.Error("Articles Not Found.")
            }
            response.isSuccessful -> {
                val articles = response.body()
                return NetworkResult.Success(articles!!)
            }
            else -> {
                return NetworkResult.Error(response.message())
            }
        }
    }

    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<Application>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }

}