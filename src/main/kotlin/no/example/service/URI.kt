package no.example.service

import java.lang.IllegalArgumentException

class URI(private val url: String) {

    fun getUri(): List<String> {
        return listOf(url)
    }
}
