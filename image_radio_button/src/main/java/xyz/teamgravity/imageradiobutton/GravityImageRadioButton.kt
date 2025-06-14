package xyz.teamgravity.imageradiobutton

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat

class GravityImageRadioButton : RelativeLayout, GravityRadioCheckable {

    companion object {
        private val DEFAULT_PRESSED_BACKGROUND_PRESSED_ID = R.drawable.background_pressed
        private const val DEFAULT_UNPRESSED_TEXT_COLOR = Color.BLACK
        private const val DEFAULT_PRESSED_TEXT_COLOR = Color.WHITE
        private const val DEFAULT_UNPRESSED_IMAGE_TINT = Color.TRANSPARENT
        private const val DEFAULT_PRESSED_IMAGE_TINT = Color.TRANSPARENT

        fun create(
            context: Context,
            text: String = "",
            @ColorInt unpressedTextColor: Int = DEFAULT_UNPRESSED_TEXT_COLOR,
            @ColorInt pressedTextColor: Int = DEFAULT_PRESSED_TEXT_COLOR,
            image: Drawable? = null,
            @ColorInt unpressedImageTint: Int = DEFAULT_UNPRESSED_IMAGE_TINT,
            @ColorInt pressedImageTint: Int = DEFAULT_PRESSED_IMAGE_TINT,
            pressedBackgroundDrawable: Drawable? = null
        ): GravityImageRadioButton {
            val view = GravityImageRadioButton(context)
            view.text = text
            view.unpressedTextColor = unpressedTextColor
            view.pressedTextColor = pressedTextColor
            view.image = image
            view.unpressedImageTint = unpressedImageTint
            view.pressedImageTint = pressedImageTint
            view.pressedBackgroundDrawable = pressedBackgroundDrawable
            return view
        }
    }

    private var textT: TextView? = null
    private var imageI: ImageView? = null

    private var text = ""
    private var unpressedTextColor = DEFAULT_UNPRESSED_TEXT_COLOR
    private var pressedTextColor = DEFAULT_PRESSED_TEXT_COLOR

    private var image: Drawable? = null
    private var unpressedImageTint = Color.TRANSPARENT
    private var pressedImageTint = Color.TRANSPARENT

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

    constructor(context: Context, attrs: AttributeSet, defaultStyleAttrs: Int) : super(context, attrs, defaultStyleAttrs) {
        parseAttrs(attrs)
        setupView()
    }

    constructor(context: Context, attrs: AttributeSet, defaultStyleAttrs: Int, defaultStyleRes: Int)
            : super(context, attrs, defaultStyleAttrs, defaultStyleRes) {
        parseAttrs(attrs)
        setupView()
    }

    private fun parseAttrs(attrs: AttributeSet) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.GravityImageRadioButton)
        try {
            text = array.getString(R.styleable.GravityImageRadioButton_girbText) ?: ""
            unpressedTextColor = array.getColor(R.styleable.GravityImageRadioButton_girbUnpressedTextColor, DEFAULT_UNPRESSED_TEXT_COLOR)
            pressedTextColor = array.getColor(R.styleable.GravityImageRadioButton_girbPressedTextColor, DEFAULT_PRESSED_TEXT_COLOR)
            image = array.getDrawable(R.styleable.GravityImageRadioButton_girbImage)
            unpressedImageTint = array.getColor(R.styleable.GravityImageRadioButton_girbUnpressedImageTint, DEFAULT_UNPRESSED_IMAGE_TINT)
            pressedImageTint = array.getColor(R.styleable.GravityImageRadioButton_girbPressedImageTint, DEFAULT_PRESSED_IMAGE_TINT)
            pressedBackgroundDrawable = array.getDrawable(R.styleable.GravityImageRadioButton_girbPressedBackgroundDrawable)
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
        bindUnpressedImageTint()
    }

    private fun setCustomTouchListener() {
        super.setOnTouchListener(TouchListener())
    }

    private fun setPressedState() {
        if (pressedBackgroundDrawable == null) setBackgroundResource(DEFAULT_PRESSED_BACKGROUND_PRESSED_ID)
        else background = pressedBackgroundDrawable

        textT?.setTextColor(pressedTextColor)
        bindPressedImageTint()
    }

    private fun setUnpressedState() {
        background = unpressedBackgroundDrawable
        textT?.setTextColor(unpressedTextColor)
        bindUnpressedImageTint()
    }

    private fun bindPressedImageTint() {
        if (pressedImageTint != DEFAULT_PRESSED_IMAGE_TINT) {
            imageI?.let { ImageViewCompat.setImageTintList(it, ColorStateList.valueOf(pressedImageTint)) }
        }
    }

    private fun bindUnpressedImageTint() {
        if (unpressedImageTint != DEFAULT_UNPRESSED_IMAGE_TINT) {
            imageI?.let { ImageViewCompat.setImageTintList(it, ColorStateList.valueOf(unpressedImageTint)) }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // API
    ///////////////////////////////////////////////////////////////////////////

    fun onTouchListener(): OnTouchListener? {
        return myOnTouchListener
    }

    fun onTouchDown(motionEvent: MotionEvent) {
        isChecked = true
    }

    fun onTouchUp(motionEvent: MotionEvent) {
        // handle user defined click listeners
        myOnClickListener?.onClick(this)
    }

    fun text(): String {
        return text
    }

    fun setText(text: String) {
        this.text = text
        textT?.text = text
    }

    fun setTextColor(@ColorRes color: Int) {
        textT?.setTextColor(ContextCompat.getColor(context, color))
    }

    fun setImageResource(@DrawableRes imageResId: Int) {
        imageI?.setImageResource(imageResId)
    }

    fun setCheckable(checkable: Boolean) {
        myCheckable = checkable
    }

    override fun setOnClickListener(l: OnClickListener?) {
        myOnClickListener = l
    }

    override fun setOnTouchListener(l: OnTouchListener?) {
        myOnTouchListener = l
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

    ///////////////////////////////////////////////////////////////////////////
    // Misc
    ///////////////////////////////////////////////////////////////////////////

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