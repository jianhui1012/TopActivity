package com.golike.topactivity

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.ele.uetool.UETool


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        UETool.showUETMenu()

        this.tv_start.setOnClickListener {
            run {
                // 判断辅助功能是否开启
                if (!AccessibilityUtil.isAccessibilitySettingsOn(this)) {
                    // 引导至辅助功能设置页面
                    startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
                }
            }
        }
    }
}
