package com.golike.topactivity

import android.content.Context
import android.provider.Settings
import android.util.Log


/**
 * Desc: 用来判断当前应用的辅助功能服务是否开启
 * Company: xuehai
 * Copyright: Copyright (c) 2019
 *
 * @author djh
 * @since 2019/01/24 11/06
 */
class AccessibilityUtil {
    //静态方法或静态值
    companion object {

        private const val TAG = "AccessibilityUtil"

        @JvmStatic
        fun isAccessibilitySettingsOn(context: Context): Boolean {
            var accessibilityEnabled = 0
            try {
                accessibilityEnabled = Settings.Secure.getInt(context.contentResolver,
                        android.provider.Settings.Secure.ACCESSIBILITY_ENABLED)
            } catch (e: Exception) {
                e.printStackTrace()
                Log.i(TAG, e.toString())
            }
            if (accessibilityEnabled == 1) {
                val services = Settings.Secure.getString(context.contentResolver,
                        Settings.Secure.ENABLED_ACCESSIBILITY_SERVICES)
                return services!!.toLowerCase().contains(context.packageName.toLowerCase())
            }
            return false
        }
    }
}