package com.example.lab5.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.lab5.databinding.FragmentStartBinding
import androidx.navigation.fragment.findNavController

import com.example.lab5.R


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentStartBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_start, container, false)

        binding.startBtn.setOnClickListener {
            findNavController().navigate(R.id.startJudging)
        }
        return binding.root
    }


}
