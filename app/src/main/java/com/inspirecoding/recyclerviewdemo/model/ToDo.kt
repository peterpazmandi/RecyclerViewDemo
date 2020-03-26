package com.inspirecoding.recyclerviewdemo.model

import android.os.Parcelable
import com.inspirecoding.recyclerviewdemo.enums.Prioirities
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToDo(
    var title: String,
    var dueDate: String,
    var description: String,
    var priority: Prioirities
) : Parcelable