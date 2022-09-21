package com.example.rajpathbookreaderapp.ConstantAPI

import android.content.Context


abstract class MyContext {

    companion object {

        private lateinit var context: Context

        fun setContext(con: Context) {
            context=con
        }
    }
}
