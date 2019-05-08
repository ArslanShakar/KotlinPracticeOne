package com.practice.kotlinpracticeone.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.practice.kotlinpracticeone.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val bundle: Bundle? = intent.extras
        val message = bundle!!.getString("message_key")
        tv_message.text = message
    }
}
