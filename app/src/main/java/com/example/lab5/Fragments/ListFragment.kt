package com.example.lab5.Fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

import com.example.lab5.R
import com.example.lab5.viewModel.DataModel
import com.example.lab5.databinding.FragmentListBinding

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    private var viewModel: DataModel ?= null

    private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        viewModel = ViewModelProviders.of(this).get(DataModel::class.java)

        binding.viewModel = viewModel


        viewModel?.name?.observe(this, Observer { name ->
            binding.catName.text = name
        })

        viewModel?.imageUrl?.observe(this, Observer { url ->
            Glide.with(this).load(url).into(binding.catImage)
        })

        viewModel?.listCompleted?.observe(this, Observer { hasListFinished ->
            if(hasListFinished){
                findNavController().navigate(R.id.moveToFinal)
            }
        })


        viewModel?.cuteScore?.observe(this, Observer { score ->
            binding.cuteScore.text = "score: " + score.toString()
        })


        viewModel?.notCuteScore?.observe(this, Observer { score ->
            binding.notCuteScore.text = "score: " + score.toString()
        })



        return binding.root
    }


}
