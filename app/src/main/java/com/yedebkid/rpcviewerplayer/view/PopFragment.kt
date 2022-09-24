package com.yedebkid.rpcviewerplayer.view

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.yedebkid.rpcviewerplayer.adapter.MusicAdapter
import com.yedebkid.rpcviewerplayer.databinding.FragmentPopBinding
import com.yedebkid.rpcviewerplayer.dependencyIngection.MussicApp
import com.yedebkid.rpcviewerplayer.rest.MusicRepo
import com.yedebkid.rpcviewerplayer.util.GenreType
import com.yedebkid.rpcviewerplayer.util.MusicsViewModelFactory
import com.yedebkid.rpcviewerplayer.util.UIState
import com.yedebkid.rpcviewerplayer.viewModel.MusicViewModel
import javax.inject.Inject

class PopFragment : Fragment() {

    private val binding by lazy {
        FragmentPopBinding.inflate(layoutInflater)
    }

    private val musicAdapter by lazy {
        MusicAdapter()
    }

    @Inject
    lateinit var  musicsViewModelFactory: MusicsViewModelFactory

    private val musicsViewModel: MusicViewModel by lazy {
        ViewModelProvider(
            requireActivity(),
            musicsViewModelFactory
        )[MusicViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MussicApp.musicComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = musicAdapter
        }

        musicsViewModel.pop.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UIState.LOADING -> {
                    binding.loadingSpinner.visibility = View.VISIBLE
                    binding.recyclerview.visibility = View.GONE
                }
                is UIState.SUCCESS -> {
                    binding.loadingSpinner.visibility = View.GONE
                    binding.recyclerview.visibility = View.VISIBLE

                    musicAdapter.updateSongs(state.musicData)
                }
                is UIState.ERROR -> {
                    binding.recyclerview.visibility = View.GONE
                    binding.loadingSpinner.visibility = View.GONE

                    AlertDialog.Builder(requireActivity())
                        .setTitle("Error occurred.")
                        .setMessage(state.error.localizedMessage)
                        .setNegativeButton("Dismiss") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .setPositiveButton("Retry") { dialog, _ ->
                            musicsViewModel.getPopMusicByGenre(GenreType.GENRE_POP)
                            dialog.dismiss()
                        }
                        .create()
                        .show()
                }

            }
        }

        musicsViewModel.getPopMusicByGenre(GenreType.GENRE_POP)
        return binding.root
    }

}