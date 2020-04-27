package no.example.service.supervisoryfunctions

import kotlin.reflect.typeOf

class SentryLoginResult {

    /**
     * TODO: Finalize this code.
     */
    fun log(message: Result<Any?>, email: String?): List<Result<Any?>> {
        return listOf(message.mapCatching {
                m -> SentryLogin().log(m, email)
                return@mapCatching m
        })
    }
}
