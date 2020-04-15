package no.example.service

import java.io.BufferedReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class DownloadPage(private val page: String) {


    /**
     * Result<T> type limitations and current state of art in Kotlin 1.3
     * https://stackoverflow.com/questions/52631827/why-cant-kotlin-result-be-used-as-a-return-type
     */
    fun content(): BufferedReader {
        val url = URL(this.page)

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"

            println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

            return inputStream.bufferedReader()
        }
    }

    fun wrappedContent() : List<Result<BufferedReader>> {
        try {
            val url = URL(this.page)
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

                return listOf(Result.success(inputStream.bufferedReader()))
            }
        } catch (e: Exception) {
            return listOf(Result.failure(e))
        }
    }
}