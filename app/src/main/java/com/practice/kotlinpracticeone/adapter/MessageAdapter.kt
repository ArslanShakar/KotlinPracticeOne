package com.practice.kotlinpracticeone.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.practice.kotlinpracticeone.model.MessageModel
import com.practice.kotlinpracticeone.R
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(private val context: Context, val messagesList: List<MessageModel>) :
    RecyclerView.Adapter<MessageAdapter.VH>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_message, viewGroup, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return messagesList.size;
    }

    override fun onBindViewHolder(vh: VH, pos: Int) {
        val dataModel = messagesList[pos]
        vh.setData(dataModel, pos)
    }

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentMessageModel: MessageModel? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                //Toast.makeText(context, currentMessageModel!!.messageTitle, Toast.LENGTH_LONG).show() //OR
                Toast.makeText(context, messagesList[currentPosition].messageTitle, Toast.LENGTH_LONG).show()
            }

            itemView.tv_share_message.setOnClickListener {
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, currentMessageModel!!.messageTitle)
                context.startActivity(Intent.createChooser(intent, "Share to:"))
            }
        }

        fun setData(dataModel: MessageModel?, pos: Int) {
            itemView.tv_message.text = dataModel!!.messageTitle

            currentMessageModel = dataModel
            currentPosition = pos
        }
    }
}