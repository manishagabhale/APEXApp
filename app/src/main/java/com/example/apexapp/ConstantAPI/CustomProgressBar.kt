package com.example.rajpathbookreaderapp.ConstantAPI

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.example.apexapp.R

class CustomProgressBar(private val context: Context) {
    var builder: AlertDialog.Builder
    var alertDialog: AlertDialog? = null
    fun ShowProgressBar(loader: String?) {

        val dialogView: View =
            LayoutInflater.from(context).inflate(R.layout.progress_bar_dialog, null, false)

        builder.setCancelable(false)
        val progressBar = dialogView.findViewById<ImageView>(R.id.progressBar)
        val txt_loader = dialogView.findViewById<TextView>(R.id.txt_loader)
        Glide.with(context).load(R.drawable.spin).into(progressBar)
        txt_loader.text = loader

       builder.setView(dialogView)

        alertDialog = builder.create()
        alertDialog!!.show()
    }

    fun DismissProgressBar() {
        alertDialog!!.dismiss()
    }

    init {
        builder = AlertDialog.Builder(context)
    }
}