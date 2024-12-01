package com.iqsoft.yearbookofwins.data

import kotlinx.coroutines.flow.Flow

interface WinsRepository {
    fun getWins(): Flow<List<WinObject>>

    suspend fun addOrEditWin(win: WinObject): WinObject

    suspend fun removeWin(winId: Int)
}