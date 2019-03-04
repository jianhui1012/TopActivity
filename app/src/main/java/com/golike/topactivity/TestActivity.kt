package com.golike.topactivity

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.view.View
import android.view.animation.BounceInterpolator
import android.view.animation.LinearInterpolator
import android.widget.CheckBox
import kotlinx.android.synthetic.main.activity_test.*
import me.imid.swipebacklayout.lib.app.SwipeBackActivity

class TestActivity : SwipeBackActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        this.checkbox.setOnClickListener {
            run {
                if (it is CheckBox) {
                    if (it.isChecked) {
                        setValueAnim(it, chooseBtn)
                    }
                }
            }
        }
    }

    private fun setValueAnim(view1: View, view2: View) {
        val value1 = PropertyValuesHolder.ofFloat("alpha", 1f, 1f)
        val value2 = PropertyValuesHolder.ofFloat("y", view2.y - view1.y)
        val value4 = PropertyValuesHolder.ofFloat("x",  view2.x)
        val objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(view1, value1, value2, value4)
        objectAnimator1.interpolator = LinearInterpolator()
        objectAnimator1.duration = 1000
        objectAnimator1.start()
    }
}
