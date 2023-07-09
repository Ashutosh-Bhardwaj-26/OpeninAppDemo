package com.example.openinappdemo.adapter

import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.widget.TextView
import java.text.SimpleDateFormat

class GreetingsSetup (val greetingsId : TextView) {
    fun setupGrettings() {
        val tz = TimeZone.getTimeZone("GMT+05:30")
        val time = Calendar.getInstance(tz).time
        val formatter = SimpleDateFormat("HH")
        val current = Integer.parseInt(formatter.format(time))
        when (current) {
            in 5..11 -> {
                greetingsId.text = "Good Morning"
            }
            in 12..16 -> {
                greetingsId.text = "Good Afternoon"
            }
            in 17..23 -> {
                greetingsId.text = "Good Evening"
            }
            in 0..4      -> {
                greetingsId.text = "Good Evening"
            }
            else -> {
                greetingsId.text = "Welcome"
            }
        }
    }
}