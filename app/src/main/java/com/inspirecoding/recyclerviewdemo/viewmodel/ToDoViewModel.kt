package com.inspirecoding.recyclerviewdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.recyclerviewdemo.enums.Prioirities
import com.inspirecoding.recyclerviewdemo.model.ToDo

class ToDoViewModel: ViewModel()
{
    private val TAG = "ToDoViewModel"

    var listOfToDos: MutableList<ToDo> = mutableListOf()

//    init {
//        listOfToDos.add(ToDo("First todo", "01.01.2020", "This is the first test todo", Prioirities.LOW ))
//        listOfToDos.add(ToDo("Second todo", "01.01.2020", "This is the Second test todo", Prioirities.MEDIUM ))
//        listOfToDos.add(ToDo("Third todo", "01.01.2020", "This is the Third test todo", Prioirities.HIGH ))
//        listOfToDos.add(ToDo("Forth todo", "01.01.2020", "This is the Forth test todo", Prioirities.LOW ))
//        listOfToDos.add(ToDo("Fifth todo", "01.01.2020", "This is the Fifth test todo", Prioirities.HIGH ))
//        listOfToDos.add(ToDo("Sixth todo", "01.01.2020", "This is the Sixth test todo", Prioirities.MEDIUM ))
//    }

    private val _listOfToDos = MutableLiveData<MutableList<ToDo>>()
    val listOfToDosLiveData: LiveData<MutableList<ToDo>>
        get() = _listOfToDos
}