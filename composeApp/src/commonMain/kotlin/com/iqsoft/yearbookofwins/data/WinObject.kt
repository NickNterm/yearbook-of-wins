package com.iqsoft.yearbookofwins.data

data class WinObject(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
)

fun WinObject.toWinEntity(): WinEntity {
    return WinEntity(
        this.id.toLong(),
        this.title,
        this.description,
        this.date
    )
}

fun WinEntity.toWinObject(): WinObject {
    return WinObject(
        id = this.id.toInt(),
        title = this.title,
        description = this.description,
        date = this.date,
    );
}