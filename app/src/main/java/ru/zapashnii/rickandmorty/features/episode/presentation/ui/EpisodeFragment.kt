package ru.zapashnii.rickandmorty.features.episode.presentation.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.zapashnii.rickandmorty.R

/** Экран эпизодов */
class EpisodeFragment : Fragment() {

    companion object {
        fun newInstance() = EpisodeFragment()
    }

    private lateinit var viewModel: EpisodeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.episode_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(EpisodeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}