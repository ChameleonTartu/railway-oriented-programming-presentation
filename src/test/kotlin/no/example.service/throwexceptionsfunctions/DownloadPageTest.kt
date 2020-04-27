package no.example.throwexceptionsfunctions

import no.example.service.throwexceptionsfunctions.DownloadPage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Disabled
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DownloadPageTest {

    private val googlePage = DownloadPage("https://google.com")
    private val stockExchangePage = DownloadPage("https://www.xe256.com")

    @Test
    fun `Download page successful scenario`() {
        assertNotNull(googlePage.content())
    }

    @Test
    fun `Download page successful scenario (ROP style)`() {
        val page = googlePage.wrappedContent().first()
        assertTrue(page.isSuccess)
        assertNotNull(page.getOrNull()!!)
    }

    @Disabled("Test runs more than 1 minute")
    @Test
    fun `Download page failure scenario`() {
        Assertions.assertThrows(Exception::class.java) {
            stockExchangePage.content()
        }
    }

    @Disabled("Test runs more than 1 minute")
    @Test
    fun `Download page failure scenario (ROP style)`() {
        val page = stockExchangePage.wrappedContent().first()
        assertTrue(page.isFailure)
        Assertions.assertThrows(Exception::class.java) {
            page.getOrThrow()
        }
    }
}