package com.golike.topactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val result = test(2, 10);
        this.tv_name.text = result.toString() +"学习hello World!!!";
    }

    fun test(a: Int, b: Int): Int {
        return a + b
    }
}
