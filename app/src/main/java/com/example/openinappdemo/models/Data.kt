package com.example.openinappdemo.models


data class Data(
    var recent_links     : List<RecentLinks>,
    var top_links        : List<TopLinks>,
    var overall_url_chart : Map<String, Int>
)
