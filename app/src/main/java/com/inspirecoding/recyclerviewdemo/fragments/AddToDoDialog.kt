package com.inspirecoding.recyclerviewdemo.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import com.inspirecoding.recyclerviewdemo.R
import com.inspirecoding.recyclerviewdemo.enums.Prioirities
import com.inspirecoding.recyclerviewdemo.model.ToDo
import com.inspirecoding.recyclerviewdemo.viewmodel.ToDoViewModel
import kotlinx.android.synthetic.main.fragment_add_to_do_dialog.*
import kotlinx.android.synthetic.main.fragment_add_to_do_dialog.view.*

class AddToDoDialog : DialogFragment()
{
    private val TAG = "AddToDoDialog"

    private lateinit var rootView: View
    private val toDoViewModel by navGraphViewModels<ToDoViewModel>(R.id.navigation_graph)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        rootView = inflater.inflate(R.layout.fragment_add_to_do_dialog, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        val safeArgs: AddToDoDialogArgs by navArgs()
        val toDo = safeArgs.toDo
        val position = safeArgs.position
        Log.i(TAG, "$toDo")
        Log.i(TAG, "$position")

        initSpinner()

        toDo?.let {
            rootView.tv_dialog_title.text = getString(R.string.modify_todo)
            rootView.btn_add.text = getString(R.string.modify)
            populateForm(it)
        }

        rootView.tv_cancel.setOnClickListener {
            dismiss()
        }

        rootView.btn_add.setOnClickListener {
            if(toDo != null)
            {
                toDoViewModel.updateToDo(position, createToDo())
            }
            else
            {
                toDoViewModel.addToDo(createToDo())
            }
            dismiss()
        }
    }

    private fun populateForm(toDo: ToDo)
    {
        rootView.et_title.setText(toDo.title)
        rootView.et_description.setText(toDo.description)

        when(toDo.priority)
        {
            Prioirities.LOW -> rootView.sr_priority.setSelection(0)
            Prioirities.MEDIUM -> rootView.sr_priority.setSelection(1)
            Prioirities.HIGH -> rootView.sr_priority.setSelection(2)
        }
        val day = toDo.dueDate.substringBefore('.').toInt()
        val month = toDo.dueDate.substringBeforeLast('.').substringAfter('.').toInt()
        val year = toDo.dueDate.substringAfterLast('.').toInt()
        rootView.dp_dueDate.updateDate(year, month, day)
    }

    private fun initSpinner()
    {
        activity?.let {
            val arraySpinner = arrayOf (
                it.getString(R.string.low),
                it.getString(R.string.medium),
                it.getString(R.string.high)
            )

            val adapter: ArrayAdapter<String> = ArrayAdapter<String>(it.applicationContext, android.R.layout.simple_spinner_item, arraySpinner)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sr_priority.adapter = adapter
        }
    }
    private fun createToDo() = ToDo(
        rootView.et_title.text.toString(),
        "${String.format("%02d", rootView.dp_dueDate.dayOfMonth)}.${String.format("%02d", rootView.dp_dueDate.month)}.${String.format("%04d", rootView.dp_dueDate.year)}",
        rootView.et_description.text.toString(),
        when(rootView.sr_priority.selectedItemId)
        {
            0L -> Prioirities.LOW
            1L -> Prioirities.MEDIUM
            else -> Prioirities.HIGH
        }
    )
}
