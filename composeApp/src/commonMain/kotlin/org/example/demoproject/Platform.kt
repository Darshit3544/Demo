package org.example.demoproject

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform