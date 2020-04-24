package no.example.service.throwexceptionsfunctions

import java.io.BufferedReader
import java.net.HttpURLConnection
import java.net.URL
import java.net.UnknownHostException

class DownloadPage(private val page: String) {


    /**
     * Result<T> type limitations and current state of art in Kotlin 1.3
     * https://stackoverflow.com/questions/52631827/why-cant-kotlin-result-be-used-as-a-return-type
     */
    @Throws(UnknownHostException::class)
    fun content(): BufferedReader{
        val url = URL(this.page)

        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "GET"
            return inputStream.bufferedReader()
        }
    }

    fun wrappedContent() : List<Result<BufferedReader>> {
        return try {
            val reader: BufferedReader = content()
            listOf(Result.success(reader))
        } catch (e: UnknownHostException) {
            listOf(Result.failure(e))
        }
    }
}