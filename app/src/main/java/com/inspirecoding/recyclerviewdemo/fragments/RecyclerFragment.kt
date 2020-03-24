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
    private var isFabOpen = false

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

        fab.setOnClickListener {
            if(isFabOpen)
            {
                hideFabMenu()
            }
            else
            {
                showFabMenu()
            }
        }

        fab_add.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerFragment_to_addToDoDialog)
            hideFabMenu()
        }
    }

    private fun showFabMenu()
    {
        isFabOpen = true
        fab.animate().alpha(0.5f)
        fab_add.animate().translationY(-resources.getDimension(R.dimen.fab_move_upwards_65))
        fab_search.animate().translationY(-resources.getDimension(R.dimen.fab_move_upwards_125))
    }
    private fun hideFabMenu()
    {
        isFabOpen = false
        fab.animate().alpha(1f)
        fab_add.animate().translationY(0f)
        fab_search.animate().translationY(0f)
    }
}
