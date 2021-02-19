package com.zhihu.globalfloatview_test

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.tv).setOnClickListener {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && Settings.canDrawOverlays(this)) {
                GlobalFloatView.showPopupWindow(this)
            } else {

                requestSettingCanDrawOverlays()

            }

        }
    }


    private fun requestSettingCanDrawOverlays() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val iIntent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION)
            iIntent.data = Uri.parse("package:$packageName")
            startActivityForResult(iIntent, 0)
        } else {

        }
    }

}
