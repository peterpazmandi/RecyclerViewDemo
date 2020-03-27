package com.inspirecoding.recyclerviewdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.navGraphViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

import com.inspirecoding.recyclerviewdemo.R
import com.inspirecoding.recyclerviewdemo.viewmodel.SearchFragmentViewModel
import com.inspirecoding.recyclerviewdemo.viewmodel.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BottomSheetDialogFragment()
{
    private val toDoViewModel by navGraphViewModels<ToDoViewModel>(R.id.navigation_graph)
    private val searchFragmentViewModel by navGraphViewModels<SearchFragmentViewModel>(R.id.navigation_graph)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        et_search_text.addTextChangedListener{
            toDoViewModel.filter(it.toString())
        }

        searchFragmentViewModel.searchText?.let {text ->
            et_search_text.setText(text)
        }

        tv_clear.setOnClickListener {
            et_search_text.text?.clear()
            dismiss()
        }

        btn_close.setOnClickListener {
            dismiss()
        }
    }
    override fun onDestroyView()
    {
        super.onDestroyView()

        searchFragmentViewModel.
        searchText = et_search_text.text.toString()
    }
}
