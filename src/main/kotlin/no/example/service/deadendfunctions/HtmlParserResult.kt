package no.example.service.deadendfunctions

class HtmlParserResult {

    private lateinit var htmlParser: HtmlParser

    constructor(html: String) {
        htmlParser = HtmlParser(html)
    }

    fun parse(): List<Result<String>> {
        return listOf(try {
            Result.success(htmlParser.parse())
        } catch(e: Error) {
            /**
             * Error shouldn't be called because it is rare JVM-related failure. It should propagate further up.
             */
            throw e
        })
    }
}