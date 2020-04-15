package no.example.service

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter
import java.nio.charset.Charset
import java.util.stream.Collectors


class Page {
    lateinit var page: String

    constructor(inputStream: BufferedReader) {
        page = inputStream.lines().collect(Collectors.joining("\n"))
    }
}
