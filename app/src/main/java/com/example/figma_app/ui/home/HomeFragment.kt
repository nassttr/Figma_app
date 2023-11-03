package com.example.figma_app.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.figma_app.R
import com.example.figma_app.databinding.FragmentHomeBinding
import com.example.figma_app.recadapters.FeelRecycler
import com.example.figma_app.recadapters.MyFeel
import com.example.figma_app.recadapters.MyState
import com.example.figma_app.recadapters.StateRecycler

class HomeFragment : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val feel_recycler : RecyclerView = root.findViewById(R.id.feel_rec)
        feel_recycler.adapter = FeelRecycler(requireContext(),MyFeel().feel_list)

        val state_recycler : RecyclerView = root.findViewById(R.id.state_rec)
        state_recycler.adapter = StateRecycler(requireContext(),MyState().state_list)
        return root
    }
}