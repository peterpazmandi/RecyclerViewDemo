package com.inspirecoding.recyclerviewdemo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.inspirecoding.recyclerviewdemo.R
import com.inspirecoding.recyclerviewdemo.adapter.ToDoAdapter
import com.inspirecoding.recyclerviewdemo.viewmodel.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_recycler.*
import kotlinx.android.synthetic.main.fragment_recycler.view.*

class RecyclerFragment : Fragment()
{
    private val toDoViewModel by
        navGraphViewModels<ToDoViewModel>(R.id.navigation_graph)
    private lateinit var toDoAdapter: ToDoAdapter

    private var isFabOpen = false


    override fun onStart()
    {
        super.onStart()

        (activity as AppCompatActivity).supportActionBar?.show()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View?
    {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)

        toDoAdapter = ToDoAdapter(toDoViewModel.listOfToDos)
        view.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = toDoAdapter
        }

        toDoViewModel.listOfToDosLiveData.observe(viewLifecycleOwner, Observer { list ->
            toDoAdapter.notifyDataSetChanged()
        })

        return view
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
