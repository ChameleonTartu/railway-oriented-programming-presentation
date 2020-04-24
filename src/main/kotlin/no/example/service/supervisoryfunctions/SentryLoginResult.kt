package no.example.service.supervisoryfunctions

import kotlin.reflect.typeOf

class SentryLoginResult {

    /**
     * TODO: Finalize this code.
     */
    fun log(message: Result<Any?>): List<Result<Any?>> {
        return listOf(message.mapCatching {
                m -> println(m)
                SentryLogin().log(m)
                return@mapCatching m
        })
    }
}