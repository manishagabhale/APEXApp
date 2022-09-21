package com.example.rajpathbookreaderapp.ConstantAPI

import android.content.Context
import android.content.SharedPreferences
import java.util.*

// Define constructor this way
class UserSettings(context: Context) {
    val PREFERENCE_NAME="SharedPreferenceExample"
    val preference=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE)

    fun getLoginName(): String?
    {
        return preference.getString(PREFERENCE_NAME,"Hello World")
    }

    fun setLoginName(name:String)
    {
        val editor=preference.edit()
        editor.putString(PREFERENCE_NAME,name)
        editor.commit()
    }

    fun getBookmarkPage(): String?
    {
        return preference.getString(PREFERENCE_NAME,"Hello World")
    }

    fun setBookmarkPage(name:String)
    {
        val editor=preference.edit()
        editor.putString(PREFERENCE_NAME,name)
        editor.commit()
    }

}