package com.example.rajpathbookreaderapp.ConstantAPI

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import com.example.apexapp.R


class PermissionAPI(private val mainActivity: Activity) {
    private val REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 0
    fun permissionsCheck() {
        val permissionsNeeded: MutableList<String> = ArrayList()
        val permissionsList: MutableList<String> = ArrayList()
        // Add permission check for any permission that is not NORMAL_PERMISSIONS
        if (!addPermission(
                permissionsList,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
        ) permissionsNeeded.add("Write External Storage,")

        if (!addPermission(
                permissionsList,
                Manifest.permission.INTERNET
            )
        ) permissionsNeeded.add("INTERNET,")
        if (!addPermission(
                permissionsList,
                Manifest.permission.READ_PHONE_STATE
            )
        ) permissionsNeeded.add("Read Storage,")
        if (!addPermission(
                permissionsList,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) permissionsNeeded.add("Read External Storage,")
        if (!addPermission(
                permissionsList,
                Manifest.permission.ACCESS_NETWORK_STATE
            )
        ) permissionsNeeded.add("Network State Storage.")
        if (!addPermission(
                permissionsList,
                Manifest.permission.CAMERA
            )
        ) permissionsNeeded.add("CAMERA.")

        if (permissionsList.size > 0) {
            if (permissionsNeeded.size > 0) {
                // Need Rationale
                var message =
                    mainActivity.getString(R.string.permission_granted) + permissionsNeeded[0]
                for (i in 1 until permissionsNeeded.size) message = """$message 
 ${              permissionsNeeded[i]}"""
                /* showMessageOKCancel(message,
                        new DialogInterface.OnClickListener() {
                            @TargetApi(Build.VERSION_CODES.M)
                            @Override
                            public void onClick(DialogInterface dialog, int which) {*/if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    mainActivity.requestPermissions(
                        permissionsList.toTypedArray(),
                        REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS
                    )
                }

                /* }
                        });*/return
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mainActivity.requestPermissions(
                    permissionsList.toTypedArray(),
                    REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS
                )
            }
            return
        }
        // launch method demo();
    }

    private fun showMessageOKCancel(message: String, okListener: DialogInterface.OnClickListener) {
        AlertDialog.Builder(mainActivity)
            .setMessage(mainActivity.getString(R.string.app_needs_to_allow_some_permissions))
            .setPositiveButton(
                mainActivity.getString(R.string.allow),
                okListener
            ) //.setNegativeButton(R.string.dialog_cancel_button_text, null)
            .setCancelable(false)
            .create()
            .show()
    }

    private fun addPermission(permissionsList: MutableList<String>, permission: String): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (mainActivity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                permissionsList.add(permission)
                // Check for Rationale Option
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!mainActivity.shouldShowRequestPermissionRationale(permission)) return false
                }
            }
        }
        return true
    }

    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS -> {
                val perms: MutableMap<String, Int> = HashMap()
                // Initial

                perms[Manifest.permission.READ_PHONE_STATE] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] =
                    PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.READ_EXTERNAL_STORAGE] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.ACCESS_NETWORK_STATE] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.CAMERA] = PackageManager.PERMISSION_GRANTED
                perms[Manifest.permission.CALL_PHONE] = PackageManager.PERMISSION_GRANTED
                // Fill with results
                var i = 0
                while (i < permissions.size) {
                    perms[permissions[i]] = grantResults[i]
                    i++
                }
                // Check for RECORD_AUDIO
                if (perms[Manifest.permission.READ_PHONE_STATE] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.WRITE_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.READ_EXTERNAL_STORAGE] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.ACCESS_NETWORK_STATE] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.CALL_PHONE] == PackageManager.PERMISSION_GRANTED && perms[Manifest.permission.CAMERA] == PackageManager.PERMISSION_GRANTED) {
                    // All Permissions Granted
                    // launch method demo();
                } else {
                    // Permission Denied
                    Toast.makeText(
                        mainActivity,
                        mainActivity.getString(R.string.permission_denied),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            else -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mainActivity.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }
    }

    companion object {
        private val TAG = PermissionAPI::class.java.simpleName
        private var instance: PermissionAPI? = null
        fun getInstance(activity: Activity): PermissionAPI? {
            return if (instance == null) {
                instance = PermissionAPI(activity)
                instance
            } else {
                instance
            }
        }

        protected var hasPermissions = false
    }
}