package no.example.service.throwexceptionsfunctions

import java.io.BufferedReader
import java.util.stream.Collectors


class Page {
    var page: String

    constructor(inputStream: BufferedReader) {
        page = inputStream.lines().collect(Collectors.joining("\n"))
    }
}
