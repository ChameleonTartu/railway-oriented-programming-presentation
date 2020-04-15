package no.example.service

import java.lang.IllegalArgumentException

class UrlSecurity {

    fun validate(uri: URI) {

        return
        uri.getUri().flatMap {
            url -> checkHttps(url).map {
                it
//                return@forEach it.recoverCatching {
//                    checkFtps(url)
//                }.getOrDefault(
//                    Result.failure(IllegalArgumentException("Protocol is not defined")
//                    )
//                )
            }
        }

    }

    private fun check(url: String, prefix: String): List<Result<String>> {
        if (url.startsWith(prefix)) {
            return listOf(Result.success("Page is secure"))
        }
        return listOf(Result.failure(IllegalArgumentException("API accepts only $prefix calls")))
    }

    private fun checkHttps(url: String): List<Result<String>> {
        return check(url, "https")
    }

    private fun checkFtps(url: String): List<Result<String>> {
        return check(url, "ftps")
    }

}
