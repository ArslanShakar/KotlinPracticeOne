package com.practice.kotlinpracticeone.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.practice.kotlinpracticeone.R
import com.practice.kotlinpracticeone.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        bt_show_toast.setOnClickListener{
            showToast("Welcome to Kotlin Course!!!")
        }
        */

        //OR
        bt_show_toast.setOnClickListener(this)

        //Navigate to Second Activity
        bt_move_to_second_activity.setOnClickListener {
            val message = et_message.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("message_key", message)
            startActivity(intent)
        }

        //implicit Intent
        bt_implicit_intent.setOnClickListener {
            val message = et_message.text.toString()
            if (TextUtils.isEmpty(message)) {
                showToast("Please write Message Title")
            } else {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, message)
                startActivity(Intent.createChooser(intent, "Share to:"))
            }
        }

        //show items in recycler view
        bt_show_data_in_recyclerView.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.bt_show_toast) {
            showToast("Welcome to Kotlin Course!!!", Toast.LENGTH_LONG)
        }

        if (v!!.id == R.id.bt_show_data_in_recyclerView) {
            startActivity(Intent(this, ShowAllMessagesActivity::class.java))
        }
    }
}

