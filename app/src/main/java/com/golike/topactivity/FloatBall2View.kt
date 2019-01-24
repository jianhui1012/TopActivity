package com.golike.topactivity

import android.content.Context
import android.graphics.Point
import android.text.TextUtils
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Desc:
 * Company: xuehai
 * Copyright: Copyright (c) 2019
 *
 * @author djh
 * @since 2019/01/23 14/32
 */
class FloatBall2View : LinearLayout {
    private var tvPackageName: TextView? = null
    private var tvPackageActivity: TextView? = null

    private var mBallView: FloatBall2View? = null
    private var windowManager: WindowManager? = null

    private var prePoint: Point? = null
    private var curPoint: Point? = null

    private val showTitle = "隐藏"
    private val hideTitle = "显示"


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    /***
     * init
     * @param context context
     */
    private fun init(context: Context) {
        windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        this.orientation = LinearLayout.VERTICAL
        this.setBackgroundColor(context.resources.getColor(R.color.bgColor))

        tvPackageName = TextView(context)
        this.addView(tvPackageName)
        tvPackageActivity = TextView(context)
        this.addView(tvPackageActivity)
        var showButton = Button(context)
        showButton.text = hideTitle
        //showButton.setBackgroundDrawable(resources.getDrawable(R.mipmap.blue_button))
        showButton.setOnClickListener {
            run {
                if (TextUtils.equals(showButton.text, showTitle)) {
                    tvPackageName!!.visibility = View.VISIBLE
                    tvPackageActivity!!.visibility = View.VISIBLE
                    showButton.text = hideTitle
                } else {
                    tvPackageName!!.visibility = View.GONE
                    tvPackageActivity!!.visibility = View.GONE
                    showButton.text = showTitle
                }
            }
        }
        this.addView(showButton)
    }

    /***
     * refreshContext
     * @param packageName packageName
     * @param packageActivity packageActivity
     */
    fun refreshContext(packageName: String, packageActivity: String) {
        tvPackageName!!.text = packageName
        tvPackageActivity!!.text = packageActivity
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                prePoint = Point(event.rawX.toInt(), event.rawY.toInt())
            }
            MotionEvent.ACTION_MOVE -> {
                curPoint = Point(event.rawX.toInt(), event.rawY.toInt())
                val xOffset = curPoint!!.x - prePoint!!.x
                val yOffset = curPoint!!.y - prePoint!!.y
                val layoutParams = this.layoutParams as WindowManager.LayoutParams
                layoutParams.x += xOffset
                layoutParams.y += yOffset
                windowManager!!.updateViewLayout(this, layoutParams)
                prePoint = curPoint
            }
        }
        return super.onTouchEvent(event)
    }

}
