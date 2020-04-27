package no.example.supervisoryfunctions

import no.example.service.supervisoryfunctions.SentryLogin
import no.example.service.supervisoryfunctions.SentryLoginResult
import org.junit.jupiter.api.Test

class SentryLoginTest {

    private val sentryLogin = SentryLogin()
    private val sentryLoginResult = SentryLoginResult()

    /**
     * This chapter is not finished and should be considerably improved.
     */
    @Test
    fun `Sentry Login`() {
        sentryLogin.log("London message", "hello@sentry.io")
    }

    @Test
    fun `Sentry Login (ROP style)`() {
        println(sentryLoginResult.log(Result.success("Test message"), null).first())
    }
}