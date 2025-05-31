package xyz.teamgravity.imageradiobutton

import android.view.View
import android.widget.CompoundButton

/**
 * Sets checked value of CompoundButton without notifying its OnCheckedChangeListener.
 *
 * @param checked
 * New value to set.
 * @param listener
 * Listener that is set after setting the new value.
 */
fun CompoundButton.setCheckedWithoutNotifyingListener(
    checked: Boolean,
    listener: (CompoundButton, Boolean) -> Unit
) {
    setOnCheckedChangeListener(null)
    isChecked = checked
    setOnCheckedChangeListener(listener)
}

/**
 * Sets checked value of RadioButton without notifying its OnCheckedChangeListener.
 *
 * @param button
 * Which button to change the value of. Button must be child of this RadioGroup.
 * @param checked
 * New value to set for [button].
 * @param listener
 * Listener that is set after setting the new value.
 */
fun GravityRadioGroup.setCheckedWithoutNotifyingListener(
    button: GravityImageRadioButton,
    checked: Boolean,
    listener: (View, View?, Boolean, Int) -> Unit
) {
    if (indexOfChild(button) == -1) throw IllegalArgumentException("Passed RadioButton must be child of this RadioGroup.")
    setOnCheckedChangeListener(null)
    button.isChecked = checked
    setOnCheckedChangeListener(listener)
}