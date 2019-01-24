package com.golike.topactivity

import android.accessibilityservice.AccessibilityService
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.view.Gravity
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent

class FloatWindowService : AccessibilityService() {


    private var mBallView: FloatBall2View? = null

    override fun onInterrupt() {
    }

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        if (event!!.eventType == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            val packageName = event.packageName;
            val className = event.className
            // 执行辅助功能服务相关操作
            addBallView(this,packageName.toString(),className.toString())
        }
    }

    private fun addBallView(context: Context,packageName:String,packageClassName:String) {
        if (mBallView == null) {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            mBallView = FloatBall2View(context)
            val params = WindowManager.LayoutParams()
            params.x = 0
            params.y = 0
            params.width = WindowManager.LayoutParams.WRAP_CONTENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            params.gravity = Gravity.LEFT or Gravity.TOP
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
            params.format = PixelFormat.RGBA_8888
            params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            mBallView!!.layoutParams = params
            windowManager.addView(mBallView, params)
        }
        mBallView!!.refreshContext(packageName,packageClassName)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return Service.START_STICKY_COMPATIBILITY
    }


}
