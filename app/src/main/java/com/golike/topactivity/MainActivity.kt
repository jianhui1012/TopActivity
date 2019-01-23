package com.golike.topactivity

import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.*
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var REQUEST_CODE = 1
    private var mBallView: FloatBall2View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tv_start.setOnClickListener {
            run {
                checkOverlayPermission()
            }
        }
        //val x = "<answer>{\"sup\":\"fĕi\"}</answer>翠"
    }


    private fun addBallView(context: Context) {
        if (mBallView == null) {
            val windowManager = windowManager
            val screenWidth = windowManager.defaultDisplay.width
            val screenHeight = windowManager.defaultDisplay.height
            mBallView = FloatBall2View(context)
            val params = WindowManager.LayoutParams()
            params.x = screenWidth
            params.y = screenHeight / 2
            params.width = WindowManager.LayoutParams.WRAP_CONTENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            params.gravity = Gravity.LEFT or Gravity.TOP
            params.type = TYPE_APPLICATION_OVERLAY
            params.format = PixelFormat.RGBA_8888
            params.flags = FLAG_NOT_TOUCH_MODAL or FLAG_NOT_FOCUSABLE
            mBallView!!.layoutParams = params
            windowManager.addView(mBallView, params)
        }
        mBallView!!.refreshContext(packageName,this.localClassName)
    }

    private fun checkOverlayPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                startActivityForResult(
                        Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName")),
                        REQUEST_CODE
                )
                Toast.makeText(this, "请先授予 \"TopActivity\" 悬浮窗权限", Toast.LENGTH_LONG).show()
            } else {
                addBallView(this)
            }
        } else {
            addBallView(this)
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && !Settings.canDrawOverlays(this)) {
            //checkOverlayPermission()
            //addBallView(this)
        }
    }

}
