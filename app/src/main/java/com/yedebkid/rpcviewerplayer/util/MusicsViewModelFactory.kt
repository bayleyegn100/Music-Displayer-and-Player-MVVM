package com.yedebkid.rpcviewerplayer.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yedebkid.rpcviewerplayer.dependencyIngection.ViewModelModule
import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.viewModel.MusicViewModel
import javax.inject.Inject

//class MusicsViewModelFactory @Inject constructor(
////    private val repo: MusicRepo
//) : ViewModelProvider.Factory{
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return MusicViewModel(repo) as T
//    }
//    }
//}

class MusicsViewModelFactory (private val repo: MusicRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MusicViewModel(repo) as T
    }


}