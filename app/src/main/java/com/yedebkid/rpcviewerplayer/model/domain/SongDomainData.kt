package com.yedebkid.rpcviewerplayer.model.domain

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yedebkid.rpcviewerplayer.model.MusicData
import com.yedebkid.rpcviewerplayer.model.Songs
import io.reactivex.Single
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "musics")
data class SongDomainData(
    @PrimaryKey val artistName: String,
    val collectionName: String,
    val artWorkUrl60: String,
    val price: Double
) : Parcelable

fun List<Songs?>?.mapToDomainMusicList(): List<SongDomainData> =
    this?.map { musicData ->
        SongDomainData(
            artistName = musicData?.artistName ?: "Invalid Name",
            collectionName = musicData?.collectionName ?: "Collection not found.",
            artWorkUrl60 = musicData?.artworkUrl60 ?: "No Image Found",
            price = musicData?.trackPrice ?: 0.0
        )
    } ?: emptyList()



