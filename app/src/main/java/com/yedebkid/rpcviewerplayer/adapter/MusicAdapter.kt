package com.yedebkid.rpcviewerplayer.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.yedebkid.rpcviewerplayer.R
import com.yedebkid.rpcviewerplayer.databinding.MusicItemBinding
import com.yedebkid.rpcviewerplayer.model.Songs
import com.yedebkid.rpcviewerplayer.model.domain.SongDomainData
import com.yedebkid.rpcviewerplayer.util.GenreType

class MusicAdapter(
    private val musicDataset: MutableList<SongDomainData> = mutableListOf()
) : RecyclerView.Adapter<MusicViewHolder>() {

    fun updateSongs(newSong: List<SongDomainData>?){
        musicDataset.clear()
        musicDataset.addAll(newSong!!.sortedBy { it. artistName})
        notifyDataSetChanged()
}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder =
        MusicViewHolder(
            MusicItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) =
        holder.bind(musicDataset[position])

    override fun getItemCount(): Int =
        musicDataset.size
}

class MusicViewHolder(
    private val binding: MusicItemBinding
): RecyclerView.ViewHolder(binding.root){
    fun bind(song: SongDomainData) {
        binding.artistName.text = song.artistName
        binding.collectionName.text = song.collectionName
        binding.musicPrice.text = song.price.toString()
//        binding.musicPrice.text = song.price?.firstOrNull()?.musicMakerPrice

        Picasso.get()
            .load(song.artWorkUrl60)
            .placeholder(R.drawable.image_holder)
            .error(R.drawable.broken_img)
            .into(binding.image)

    }

}