package com.yedebkid.rpcviewerplayer.util

import com.yedebkid.rpcviewerplayer.model.MusicData
import com.yedebkid.rpcviewerplayer.model.Songs
import com.yedebkid.rpcviewerplayer.model.domain.SongDomainData
import java.lang.Exception

sealed class UIState{
    object LOADING: UIState()
    data class SUCCESS(val musicData: List<SongDomainData>): UIState()
    data class ERROR(val error: Exception): UIState()
}
