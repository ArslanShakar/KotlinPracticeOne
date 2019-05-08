
package com.practice.kotlinpracticeone.model

data class MessageModel(val messageTitle: String)

object MessageSupplier
{
    val messagesList = listOf(MessageModel("Hi, Arslan"), MessageModel("Hey, How are you?"),
            MessageModel("I am Asif."), MessageModel("Whats going on?"), MessageModel("Whats doing?"),
            MessageModel("Are you pakistani?"), MessageModel("Pakistan Zindabad"), MessageModel("Where You From?"),
            MessageModel("I am from Pakistan."), MessageModel("Welcome dear"), MessageModel("Ramadan Mubarak!"))
}