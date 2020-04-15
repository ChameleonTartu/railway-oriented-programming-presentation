package no.example

import no.example.service.DownloadPage
import no.example.service.Page
import java.io.BufferedReader

fun main(urls: Array<String>) {

    // Happy scenario
//    val happyPages = urls
//        .map { DownloadPage(it).content() }
//        .map { Page(it).page }
//        .forEach { println(it.substring(0, 20)) }

    // Railway Oriented Programming scenario
    val sadPages = urls
        .map { DownloadPage(it).wrappedContent() }
        .map { it.first() }
        .map { p -> p.recoverCatching {
                    e -> e.message?.let {
                         when(e.message) {
                             "gol.com" -> DownloadPage("https://google.com").content()
                             "uah-rate.xyz" -> DownloadPage("http://xe352.com").content()
                             else -> DownloadPage("https://duckduckgo.com").content()
                         }
                    }
                }
        }
        .map { p ->
            p.onFailure {
                println(it.message)
            }
        }
        .forEach { p -> p.onSuccess {
            println(Page(it as BufferedReader).page.substring(0, 20))
        } }

}
