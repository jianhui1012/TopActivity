package com.golike.topactivity

/**
 * Desc:
 * Company: xuehai
 * Copyright: Copyright (c) 2019
 *
 * @author djh
 * @since 2019/01/22 16/23
 */
class NewBean {

    fun test1(a: Int = 10, b: Int = 10): Int {
        return a + b
    }

    fun test2(a: Int = 8, b: Int): Int {
        return a + b
    }

    fun test3(a: Int, x: String = "default", y: Boolean = true): String {
        return x
    }

    fun test3(a: Int, b: Int, c: () -> Unit): Int {
        return a + b
    }

    open class A {
        open fun foo(i: Int = 10) {

        }
    }

    class B : A() {
        override fun foo(i: Int) {

        }  // 不能有默认值
    }
}