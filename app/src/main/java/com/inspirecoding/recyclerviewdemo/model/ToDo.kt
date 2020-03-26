package com.inspirecoding.recyclerview_practice_1.model

import android.os.Parcelable
import com.inspirecoding.recyclerview_practice_1.enums.Prioirities
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Parcelize
data class ToDo(
    var title: String,
    var dueDate: String,
    var description: String,
    var priority: Prioirities
) : Parcelable