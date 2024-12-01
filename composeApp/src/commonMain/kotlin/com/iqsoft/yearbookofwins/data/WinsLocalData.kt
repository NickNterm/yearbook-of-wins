package com.iqsoft.yearbookofwins.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.transform

interface WinsLocalData {
    suspend fun saveWins(newWins: List<WinObject>)

    suspend fun saveWin(win: WinObject): WinObject

    fun getWinById(objectId: Int): Flow<WinObject?>

    fun getWins(): Flow<List<WinObject>>

    fun removeWin(winId: Int)
}

class WinsLocalDataImpl(
    private val db: AppDatabase
) : WinsLocalData {
    override suspend fun saveWins(newWins: List<WinObject>) {
        newWins.forEach {
            db.getDao().insert(it.toWinEntity())
        }
    }

    override suspend fun saveWin(win: WinObject): WinObject {
        db.getDao().insert(win.toWinEntity())
        return win;
    }

    override fun getWinById(objectId: Int): Flow<WinObject?> {
        return db.getDao().getSingleWin(objectId).map { it ->
            if (it.isNotEmpty()) {
                it[0].toWinObject()
            } else {
                null
            }
        }
    }

    override fun getWins(): Flow<List<WinObject>> {
        return db.getDao().getAllWins().map { list ->
            list.map { entity ->
                entity.toWinObject()
            }
        }
    }

    override fun removeWin(winId: Int) {
        db.getDao().deleteWin(winId)
    }
}
