package com.example.taskguide

import android.app.PendingIntent
import android.app.PictureInPictureParams
import android.app.RemoteAction
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.res.Configuration
import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Rational
import android.view.View
import android.widget.Button
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.view.isVisible

class Task1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task1)
        supportActionBar?.hide()

        val btReturnMainMenu: Button = findViewById(R.id.btReturn)

        btReturnMainMenu.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onUserLeaveHint() {
//        val pipParams = PictureInPictureParams.Builder().build()


        val actions = ArrayList<RemoteAction>()

        val actionIntent = Intent("SCROLL_DOWN")

        val pendingIntent = PendingIntent.getBroadcast(this,0
            , actionIntent, 0)

        val icon = Icon.createWithResource(this, android.R.drawable.arrow_down_float)

        val remoteAction = RemoteAction(icon,
            "ScrollDown",
            "Scroll down a few lines",
            pendingIntent)

        val actionIntent2 = Intent("SCROLL_UP")

        val pendingIntent2 = PendingIntent.getBroadcast(this,0
            , actionIntent2, 0)

        val icon2 = Icon.createWithResource(this, android.R.drawable.arrow_up_float)

        val remoteAction2 = RemoteAction(icon2,
            "ScrollUp",
            "Scroll up a few lines",
            pendingIntent2)

        actions.add(remoteAction)
        actions.add(remoteAction2)

        val pipParams = PictureInPictureParams.Builder().setActions(actions).build()

        enterPictureInPictureMode(pipParams)

    }

    override fun onPictureInPictureModeChanged(
        isInPictureInPictureMode: Boolean, newConfig: Configuration?) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig)

        val btReturnMainMenu: Button = findViewById(R.id.btReturn)
        val txtTitle: TextView = findViewById(R.id.txtTaskTitle)
        val pipScrollView: ScrollView = findViewById(R.id.scrollBody)

        if (isInPictureInPictureMode) {
            // Acitivity entered Picture-in-Picture mode
            btReturnMainMenu.visibility = Button.GONE
            txtTitle.visibility = TextView.GONE


            val filter = IntentFilter()
            filter.addAction("SCROLL_DOWN")
            val receiver = object: BroadcastReceiver()
            {
                override fun onReceive(context: Context?, intent: Intent?) {
                    pipScrollView.smoothScrollBy(0,200)
                }
            }

            val filter2 = IntentFilter()
            filter2.addAction("SCROLL_UP")
            val receiver2 = object: BroadcastReceiver()
            {
                override fun onReceive(context: Context?, intent: Intent?) {
                    pipScrollView.smoothScrollBy(0,-200)
                }
            }

            registerReceiver(receiver,filter)
            registerReceiver(receiver2,filter2)

        } else {
            // Activity entered full screen mode
            txtTitle.visibility = TextView.VISIBLE
            btReturnMainMenu.visibility = Button.VISIBLE
        }

    }
}