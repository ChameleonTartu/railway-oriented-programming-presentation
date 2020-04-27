package no.example.service.supervisoryfunctions

import io.sentry.Sentry
import io.sentry.SentryClient
import io.sentry.SentryClientFactory
import io.sentry.context.Context
import io.sentry.event.BreadcrumbBuilder
import io.sentry.event.UserBuilder


/**
 * SentryLogin is example of logging with Sentry from its <a href="https://docs.sentry.io/clients/java/">docs</a>
 */
class SentryLogin {

    /**
     * This is Supervisory function which doesn't return anything. Inside itself it contains number of issues,
     * what if Sentry will not be initialized? what if while sending Timeout will happen? and more.
     */
    fun log(message: Any?, email: String?): Unit {
        Sentry.init()
        var sentry: SentryClient = SentryClientFactory.sentryClient()
        val context: Context = sentry.context

        // Record a breadcrumb in the current context. By default the last 100 breadcrumbs are kept.
        context.recordBreadcrumb(BreadcrumbBuilder().setMessage("User made an action").build())

        // Set the user in the current context.
        context.user = UserBuilder().setEmail(email).build()

        // This sends a simple event to Sentry.
        sentry.sendMessage("$message")
    }
}