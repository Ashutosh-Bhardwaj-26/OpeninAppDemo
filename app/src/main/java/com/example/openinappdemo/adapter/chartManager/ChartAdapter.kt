package com.example.openinappdemo.adapter.chartManager

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.openinappdemo.R
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

class ChartAdapter (var datesChart : Map<String,Int>,
                    var chart : LineChart,
                    var monthDateItem: TextView,
                    var context: Context) {

    private lateinit var chartData : ChartData
    private val MONTH_VALUE = arrayOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec")

    init{
        configureChart()
        setGraphDate()
        setData()

    }
    fun configureChart() {

        chart.description.isEnabled = false
        chart.setDrawGridBackground(true)
        chart.setDrawBorders(false)
        chart.setDoubleTapToZoomEnabled(false);
        chart.setGridBackgroundColor(Color.WHITE)
        chart.isDragEnabled = false
        chart.animateXY(700,700)
        chart.setNoDataTextColor(Color.WHITE)


        val xAxis = chart.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.valueFormatter = IndexAxisValueFormatter(MONTH_VALUE.asList())
        xAxis.gridColor = Color.LTGRAY
        xAxis.textColor = Color.GRAY
        xAxis.setLabelCount(12,true)

        val yAxisRight = chart.axisRight
        yAxisRight.isEnabled = false

        val yAxisLeft = chart.axisLeft
        yAxisLeft.gridColor = Color.LTGRAY
        yAxisLeft.textColor = Color.BLACK
        chart.legend.isEnabled = false
    }
    fun setGraphDate() {
        val firstVal = datesChart.keys.first()
        val lastVal = datesChart.keys.last()
        val firstMonth = Integer.parseInt(firstVal.split("-")[1])
        var firstDate = Integer.parseInt(firstVal.split("-")[2])
        val lastMonth = Integer.parseInt(lastVal.split("-")[1])
        val lastDate = Integer.parseInt(lastVal.split("-")[2])
        monthDateItem.text = firstDate.toString() + " " + MONTH_VALUE[firstMonth-1].toString()+ " - " + lastDate.toString() + " " + MONTH_VALUE[lastMonth-1].toString()

    }
    fun setData() {
        chartData = ChartData(datesChart)
        val entries = chartData.getChartData()
        val dataSet = LineDataSet(entries, "")
        dataSet.color = Color.BLUE
        dataSet.fillColor = Color.BLUE
        dataSet.setDrawFilled(true)
        dataSet.setDrawValues(false)
        dataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
        dataSet.lineWidth = 2f
        dataSet.setDrawFilled(true)
        val drawable = ContextCompat.getDrawable(context, R.drawable.chartgradient)
        dataSet.fillDrawable = drawable
        dataSet.setDrawCircles(false)
        val lineData = LineData(dataSet)
        chart.data = lineData
        chart.invalidate()
    }

}