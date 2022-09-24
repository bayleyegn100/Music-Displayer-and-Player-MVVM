package com.yedebkid.rpcviewerplayer.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.viewModel.MusicViewModel

class MusicsViewModelFactory(
    private val repository: MusicRepo
): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MusicViewModel(repository) as T
    }

}

//class MusicsViewModelFactory(
//    private val owner: SavedStateRegistryOwner,
//    private val repository: MusicRepo
//    ) : AbstractSavedStateViewModelFactory(owner, null), ViewModelProvider.Factory {
//    override fun <T : ViewModel?> create(key: String, modelClass: Class<T>, state: SavedStateHandle) =
//        MusicViewModel(repository) as T
//}
