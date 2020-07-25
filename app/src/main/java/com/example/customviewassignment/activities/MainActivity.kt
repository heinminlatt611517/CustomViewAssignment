package com.example.customviewassignment.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.customviewassignment.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TOTAL_TIME = 8 * 1000L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //timeOutRemoveTimer.start()
        circle_progress.progress = 0.8f

        ivAdd.setOnClickListener {
            startActivity(Intent(this,TaskScreen::class.java))
        }

        ivProfile.setOnClickListener {
            startActivity(Intent(this,ProfileScreen::class.java))
        }
    }

    private var timeOutRemoveTimer = object : CountDownTimer(TOTAL_TIME, 8) {
        override fun onFinish() {
            circle_progress.progress = 0.8f

        }

        override fun onTick(millisUntilFinished: Long) {
            circle_progress.progress = (TOTAL_TIME - millisUntilFinished).toFloat() / TOTAL_TIME
        }
    }
}
