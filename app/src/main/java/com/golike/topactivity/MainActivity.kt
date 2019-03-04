package com.golike.topactivity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback
import kotlinx.android.synthetic.main.activity_main.*
import me.ele.uetool.UETool
import me.imid.swipebacklayout.lib.app.SwipeBackActivity


class MainActivity :  SwipeBackActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UETool.showUETMenu()
        animation_view.addValueCallback(
                KeyPath("Shape Layer", "Rectangle", "Fill"),
                LottieProperty.COLOR,
                LottieValueCallback(Color.RED))
        this.tv_start.setOnClickListener {
            run {
                // 判断辅助功能是否开启
                if (!AccessibilityUtil.isAccessibilitySettingsOn(this)) {
                    // 引导至辅助功能设置页面
                    //startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
                }
                animation_view.setAnimation("lottie_data_edit.json")
                animation_view.playAnimation()
                startActivity(Intent(this@MainActivity,TestActivity::class.java))
            }
        }


    }
}
