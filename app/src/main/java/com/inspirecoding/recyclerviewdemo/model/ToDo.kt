package com.inspirecoding.recyclerviewdemo.model

import android.os.Parcelable
import com.inspirecoding.recyclerviewdemo.enums.Prioirities
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class ToDo(
    var title: String,
    var description: String,
    var dueDate: String,
    var priority: Prioirities
) : Parcelable