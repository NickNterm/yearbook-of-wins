package com.iqsoft.yearbookofwins

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform