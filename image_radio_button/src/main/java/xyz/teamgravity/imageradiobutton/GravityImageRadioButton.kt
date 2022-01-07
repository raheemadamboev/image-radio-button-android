package xyz.teamgravity.imageradiobutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

class GravityImageRadioButton : RelativeLayout, GravityRadioCheckable {

    companion object {
        private val DEFAULT_PRESSED_BACKGROUND_PRESSED_ID = R.drawable.background_shape_preset_button_pressed
        private const val DEFAULT_UNPRESSED_TEXT_COLOR = Color.BLACK
        private const val DEFAULT_PRESSED_TEXT_COLOR = Color.WHITE
    }

    private var textT: TextView? = null
    private var imageI: ImageView? = null

    private var text = ""
    private var unpressedTextColor = DEFAULT_UNPRESSED_TEXT_COLOR
    private var pressedTextColor = DEFAULT_PRESSED_TEXT_COLOR

    private var image: Drawable? = null
    private var imageResId = -1
    private var unpressedImageTint = -1
    private var pressedImageTint = -1

    private var pressedBackgroundDrawable: Drawable? = null
    private var unpressedBackgroundDrawable: Drawable? = null

    private var myOnClickListener: OnClickListener? = null
    private var myOnTouchListener: OnTouchListener? = null

    private var myChecked = false
    private var myCheckable = true

    private val onCheckedChangeListeners = ArrayList<GravityRadioCheckable.OnCheckedChangeListener>()

    constructor(context: Context) : super(context) {
        setupView()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        parseAttrs(attrs)
        setupView()
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    constructor(context: Context, attrs: AttributeSet, defaultStyleAttrs: Int) : super(context, attrs, defaultStyleAttrs) {
        parseAttrs(attrs)
        setupView()
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defaultStyleAttrs: Int, defaultStyleRes: Int)
            : super(context, attrs, defaultStyleAttrs, defaultStyleRes) {
        parseAttrs(attrs)
        setupView()
    }

    private fun parseAttrs(attrs: AttributeSet) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.GravityImageRadioButton, 0, 0)
        try {
            text = array.getString(R.styleable.GravityImageRadioButton_text) ?: ""
            image = array.getDrawable(R.styleable.GravityImageRadioButton_image)
            unpressedTextColor = array.getColor(R.styleable.GravityImageRadioButton_unpressedTextColor, DEFAULT_UNPRESSED_TEXT_COLOR)
            pressedTextColor = array.getColor(R.styleable.GravityImageRadioButton_pressedTextColor, DEFAULT_PRESSED_TEXT_COLOR)
            unpressedImageTint = array.getColor(R.styleable.GravityImageRadioButton_unpressedImageTint, -1)
            pressedImageTint = array.getColor(R.styleable.GravityImageRadioButton_pressedImageTint, -1)
            pressedBackgroundDrawable = array.getDrawable(R.styleable.GravityImageRadioButton_pressedBackgroundDrawable)
        } finally {
            array.recycle()
        }
    }

    private fun setupView() {
        inflateView()
        bindView()
        setCustomTouchListener()
    }

    private fun inflateView() {
        LayoutInflater.from(context).inflate(R.layout.image_radio_button, this, true)
        textT = findViewById(R.id.text_t)
        imageI = findViewById(R.id.image_i)
        unpressedBackgroundDrawable = background
    }

    private fun bindView() {
        textT?.setTextColor(unpressedTextColor)
        textT?.text = text
        imageI?.setImageDrawable(image)
        if (unpressedImageTint != -1) {
            imageI?.let {
                ImageViewCompat.setImageTintList(it, ColorStateList.valueOf(ContextCompat.getColor(context, unpressedImageTint)))
            }
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        myOnClickListener = l
    }

    private fun setCustomTouchListener() {
        super.setOnTouchListener(TouchListener())
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
        myOnTouchListener = l
    }

    fun onTouchListener() = myOnTouchListener

    fun onTouchDown(motionEvent: MotionEvent) {
        isChecked = true
    }

    fun onTouchUp(motionEvent: MotionEvent) {
        // handle user defined click listeners
        myOnClickListener?.onClick(this)
    }

    private fun setPressedState() {
        if (pressedBackgroundDrawable == null) setBackgroundResource(DEFAULT_PRESSED_BACKGROUND_PRESSED_ID)
        else background = pressedBackgroundDrawable

        textT?.setTextColor(pressedTextColor)
        if (pressedImageTint != -1) {
            imageI?.let {
                ImageViewCompat.setImageTintList(it, ColorStateList.valueOf(ContextCompat.getColor(context, pressedImageTint)))
            }
        }
    }

    private fun setUnpressedState() {
        background = unpressedBackgroundDrawable
        textT?.setTextColor(unpressedTextColor)
        if (unpressedImageTint != -1) {
            imageI?.let {
                ImageViewCompat.setImageTintList(it, ColorStateList.valueOf(ContextCompat.getColor(context, unpressedImageTint)))
            }
        }
    }

    fun text() = text

    fun setText(text: String) {
        this.text = text
        textT?.text = text
    }

    fun setTextColor(@ColorRes color: Int) {
        textT?.setTextColor(ContextCompat.getColor(context, color))
    }

    fun setImageResource(@DrawableRes imageResId: Int) {
        this.imageResId = imageResId
        imageI?.setImageResource(this.imageResId)
    }

    override fun addOnCheckedChangeListener(listener: GravityRadioCheckable.OnCheckedChangeListener) {
        onCheckedChangeListeners.add(listener)
    }

    override fun removeOnCheckedChangeListener(listener: GravityRadioCheckable.OnCheckedChangeListener) {
        onCheckedChangeListeners.remove(listener)
    }

    override fun setChecked(checked: Boolean) {
        if (myCheckable) {
            if (myChecked != checked) {
                myChecked = checked
                if (onCheckedChangeListeners.isNotEmpty()) {
                    for (i in onCheckedChangeListeners.indices) {
                        onCheckedChangeListeners[i].onCheckedChange(this, myChecked)
                    }
                }

                if (myChecked) setPressedState() else setUnpressedState()
            }
        }
    }

    override fun isChecked(): Boolean {
        return myChecked
    }

    override fun toggle() {
        isChecked = !myChecked
    }

    fun setCheckable(checkable: Boolean) {
        myCheckable = checkable
    }

    private inner class TouchListener : OnTouchListener {

        override fun onTouch(v: View?, event: MotionEvent?): Boolean {
            when (event?.action) {
                MotionEvent.ACTION_DOWN -> onTouchDown(event)
                MotionEvent.ACTION_UP -> onTouchUp(event)
            }

            myOnTouchListener?.onTouch(v, event)

            return true
        }
    }
}