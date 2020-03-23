package com.inspirecoding.recyclerviewdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController

import com.inspirecoding.recyclerviewdemo.R
import kotlinx.android.synthetic.main.fragment_recycler.*

class RecyclerFragment : Fragment()
{
    override fun onStart()
    {
        super.onStart()

        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recycler, container, false )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        fab_add.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_addToDoDialog)
        }
    }
}
