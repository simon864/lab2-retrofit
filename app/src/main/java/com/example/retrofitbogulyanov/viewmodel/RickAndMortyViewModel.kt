package com.example.retrofitbogulyanov.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitbogulyanov.api.RickAndMortyApiService
import com.example.retrofitbogulyanov.data.Results
import com.example.retrofitbogulyanov.ui.CharacterAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.lang.Exception

class RickAndMortyViewModel : ViewModel() {
    var charactersData = MutableLiveData<Results>()

    suspend fun retrofitAPI() {
        if (charactersData.value != null) {
            return
        }

        CoroutineScope(Dispatchers.IO).async {
            try {
                val characterRetrofit = RickAndMortyApiService.create().getCharacters()
                charactersData.postValue(characterRetrofit)
            } catch (ex : Exception) { }
        }.await()
    }
}