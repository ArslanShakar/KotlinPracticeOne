package com.practice.kotlinpracticeone

import android.content.Context
import android.widget.Toast
import java.time.Duration

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT)
{
    /* duration have default toast show length and it is a optional parameter */
    Toast.makeText(this, message, duration).show()
}