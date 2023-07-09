package com.example.openinappdemo.adapter.chartManager

import com.github.mikephil.charting.data.Entry

class ChartData(var datesChart : Map<String,Int>) {
    private val monthTotalValue = ArrayList<Int>()
    fun getChartData(): List<Entry> {
        val values = ArrayList<Entry>()
        for(i in 0..12){
            monthTotalValue.add(0)
        }
        for ((date, value) in datesChart) {
            val month = Integer.parseInt(date.split("-")[1])
            var currentValue =  monthTotalValue[month]
            monthTotalValue[month] = currentValue + value
        }
        for(i in 0 until monthTotalValue.size){
            values.add(Entry(i.toFloat(), monthTotalValue[i].toFloat()))
        }
        return values
    }
}