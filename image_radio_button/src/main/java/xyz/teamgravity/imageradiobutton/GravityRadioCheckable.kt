package xyz.teamgravity.imageradiobutton

import android.view.View
import android.widget.Checkable

interface GravityRadioCheckable : Checkable {

    fun addOnCheckedChangeListener(listener: OnCheckedChangeListener)

    fun removeOnCheckedChangeListener(listener: OnCheckedChangeListener)

    interface OnCheckedChangeListener {
        fun onCheckedChange(radioButton: View, checked: Boolean)
    }
}