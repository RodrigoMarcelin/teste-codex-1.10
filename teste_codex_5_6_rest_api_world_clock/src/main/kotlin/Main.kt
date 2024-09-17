package org.example

import io.javalin.Javalin
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.example.repository.model.WorldClockResponse
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.ZoneId

fun main() {
    val mapper = jacksonObjectMapper()
    val app = Javalin.create ().start(8080)

    app.get("/utc") { ctx ->
        val utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"))
        val response = WorldClockResponse(utcDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        ctx.json(response)
    }

    app.get("/local") { ctx ->
        val utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"))
        val localDateTime = utcDateTime.withZoneSameInstant(ZoneId.systemDefault())
        val response = WorldClockResponse(localDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
        ctx.json(response)
    }
}