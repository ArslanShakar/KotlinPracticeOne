package com.practice.kotlinpracticeone.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.practice.kotlinpracticeone.adapter.MessageAdapter
import com.practice.kotlinpracticeone.model.MessageSupplier
import com.practice.kotlinpracticeone.R
import kotlinx.android.synthetic.main.activity_show_all_messages.*

class ShowAllMessagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_messages)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = layoutManager

        val adapter = MessageAdapter(this, MessageSupplier.messagesList)
        recycler_view.adapter = adapter

        adapter.notifyDataSetChanged()
    }
}
