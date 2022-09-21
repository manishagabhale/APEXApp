package com.example.rajpathbookreaderapp.ConstantAPI

import android.content.Context
import com.example.apexapp.R

class PrefConfig(applicationContext: Context) {

    /*Declare variable*/
    //private var sharedPreferences: SharedPreferences? = null
    private var context: Context? = null
    var list: ArrayList<String>? = null

    private var  sharedPreferences = applicationContext.getSharedPreferences(
    applicationContext.getString(R.string.pref_file_),
    Context.MODE_PRIVATE
    )

    fun PrefConfig() {

    }

    /*declare constructor*/
    fun PrefConfig(context: Context) {
        this.context = context
        sharedPreferences = context.getSharedPreferences(
            context.getString(R.string.pref_file_),
            Context.MODE_PRIVATE
        )
        list = ArrayList()
    }


    fun readUserId(): String? {
        return sharedPreferences?.getString(MainApplication.applicationContext().getString(R.string.pref_user_id), "9")
    }


    fun writeUserId(UserId: String?) {
        val editor = sharedPreferences?.edit()
        editor?.putString(MainApplication.applicationContext().getString(R.string.pref_user_id), UserId)
        editor?.commit()
    }

    fun writeImageName(imageName: String?) {
        val editor = sharedPreferences.edit()
        editor.putString(context!!.getString(R.string.pref_ImageName), imageName)
        editor.commit()
    }

    fun readImageName(): String? {
        return sharedPreferences.getString(context!!.getString(R.string.pref_ImageName), "0.jpg")
    }
}

