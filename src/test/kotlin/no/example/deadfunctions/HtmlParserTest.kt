package no.example.deadfunctions

import no.example.service.deadendfunctions.HtmlParser
import no.example.service.deadendfunctions.HtmlParserResult
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HtmlParserTest {

    private val html: String = "<html></html>"

    @Test
    fun `HTML parser throws StackOverflowError`() {
        Assertions.assertThrows(StackOverflowError::class.java) {
            HtmlParser(html).parse()
        }
    }

    @Test
    fun `HTML parser throws StackOverflowError (ROP style)`() {
        Assertions.assertThrows(StackOverflowError::class.java) {
            HtmlParserResult(html).parse()
        }
    }

}