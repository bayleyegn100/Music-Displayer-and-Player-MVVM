package com.yedebkid.rpcviewerplayer.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.util.GenreType
import com.yedebkid.rpcviewerplayer.util.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicViewModel(
    private val repository: MusicRepo
): ViewModel() {

    private val _pop: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val pop: LiveData<UIState> get() = _pop

    private val _rock: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val rock: LiveData<UIState> get() = _rock

    private val _classic: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val classic: LiveData<UIState> get() = _classic

    init {
        getPopMusicByGenre(genreType = GenreType.GENRE_POP)
        getRockMusicByGenre(genreType = GenreType.GENRE_ROCK)
        getClassicMusicByGenre(genreType = GenreType.GENRE_CLASSIC)
    }

    fun getPopMusicByGenre(genreType: GenreType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMusicByGenre(genreType).collect() {
                withContext(Dispatchers.Main) {
                    _pop.postValue(it)
                }
            }
        }
    }
    fun getRockMusicByGenre(genreType: GenreType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMusicByGenre(genreType).collect() {
                withContext(Dispatchers.Main) {
                    _rock.postValue(it)
                }
            }
        }
    }
    fun getClassicMusicByGenre(genreType: GenreType){
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMusicByGenre(genreType).collect() {
                withContext(Dispatchers.Main) {
                    _classic.postValue(it)
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

}