package com.raghav.counterapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform