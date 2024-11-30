package com.iqsoft.yearbookofwins

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iqsoft.yearbookofwins.data.AppDatabase

fun getDatabaseBuilder(ctx: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = ctx.applicationContext
    val dbFile = appContext.getDatabasePath("wins_room.db")
    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}
