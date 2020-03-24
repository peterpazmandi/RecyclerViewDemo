package com.inspirecoding.recyclerviewdemo.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.recyclerviewdemo.R
import com.inspirecoding.recyclerviewdemo.enums.Prioirities
import com.inspirecoding.recyclerviewdemo.model.ToDo
import kotlinx.android.synthetic.main.item_todo_recyclerview.view.*

class ToDoAdapter(private val listOfToDos: MutableList<ToDo>): RecyclerView.Adapter<ToDoAdapter.ToDoHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoAdapter.ToDoHolder
    {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ToDoAdapter.ToDoHolder, position: Int)
    {
        TODO("Not yet implemented")
    }

    inner class ToDoHolder(private val view: View): RecyclerView.ViewHolder(view), View.OnClickListener
    {
        init {
            view.setOnClickListener(this)
        }

        fun bindToDo(toDo: ToDo)
        {
            view.tv_title.text = toDo.title
            view.tv_dueDate.text = toDo.dueDate
            view.tv_description.text = toDo.description
            when (toDo.priority)
            {
                Prioirities.LOW -> view.iv_priority.setBackgroundResource(R.drawable.prio_green)
                Prioirities.MEDIUM -> view.iv_priority.setBackgroundResource(R.drawable.prio_orange)
                Prioirities.HIGH -> view.iv_priority.setBackgroundResource(R.drawable.prio_red)
            }
        }

        override fun onClick(view: View)
        {

        }
    }
}