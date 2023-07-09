package com.example.openinappdemo.models


data class RecentLinks(
    var url_id         : Int?    = null,
    var web_link       : String? = null,
    var smart_link     : String? = null,
    var title         : String? = null,
    var total_clicks   : Int?    = null,
    var original_image : String? = null,
    var thumbnail     : String? = null,
    var times_ago      : String? = null,
    var created_at     : String? = null,
    var domain_id      : String? = null,
    var url_prefix     : String? = null,
    var url_suffix     : String? = null,
    var app           : String? = null
)
