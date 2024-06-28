package dev.sunriseydy.acgn.db.anime

import dev.sunriseydy.acgn.anime.dto.Rss
import org.jetbrains.exposed.dao.ULongEntity
import org.jetbrains.exposed.dao.ULongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.ULongIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.CurrentDateTime
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

/**
 * @author SunriseYDY
 * @date 2024-06-28 00:11
 */
object RssTable : ULongIdTable("anime_rss") {
    val link = varchar("link", 255)
    val title = varchar("title", 255)
    val description = text("description").nullable()
    val ttl = integer("ttl")
    val lastFetchAt = datetime("lastFetchAt")
    val createdAt = datetime("createdAt").defaultExpression(CurrentDateTime)
    val updatedAt = datetime("updatedAt").defaultExpression(CurrentDateTime)
    val version = integer("version").default(0)
}

class RssDAO(id: EntityID<ULong>) : ULongEntity(id) {
    companion object : ULongEntityClass<RssDAO>(RssTable)

    var link by RssTable.link
    var title by RssTable.title
    var description by RssTable.description
    var ttl by RssTable.ttl
    var lastFetchAt by RssTable.lastFetchAt
    var createdAt by RssTable.createdAt
    var updatedAt by RssTable.updatedAt
    var version by RssTable.version

    fun toDTO(): Rss {
        return Rss(
            id = id.value,
            link = link,
            title = title,
            description = description,
            ttl = ttl,
            lastFetchAt = lastFetchAt,
            createdAt = createdAt,
            updatedAt = updatedAt,
            version = version,
        )
    }
}