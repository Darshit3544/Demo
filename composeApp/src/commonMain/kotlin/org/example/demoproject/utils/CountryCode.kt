package org.example.demoproject.utils

data class Country(
    val name: String,
    val code: String,  // ISO Alpha-2 code (e.g., "US")
    val dialCode: String,
    val flag: String   // Unicode flag emoji (works on both Android & iOS)
)

// Sample list
val countryList = listOf(
    Country("United States", "US", "+1", "🇺🇸"),
    Country("Canada", "CA", "+1", "🇨🇦"),
    Country("United Kingdom", "GB", "+44", "🇬🇧"),
    Country("India", "IN", "+91", "🇮🇳")
)