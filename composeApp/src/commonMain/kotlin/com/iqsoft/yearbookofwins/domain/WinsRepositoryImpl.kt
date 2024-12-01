package com.iqsoft.yearbookofwins.domain

import com.iqsoft.yearbookofwins.data.WinObject
import com.iqsoft.yearbookofwins.data.WinsLocalData
import com.iqsoft.yearbookofwins.data.WinsRepository
import kotlinx.coroutines.flow.Flow

class WinsRepositoryImpl(
    private val localData: WinsLocalData,
) : WinsRepository {
    override fun getWins(): Flow<List<WinObject>> {
        return localData.getWins()
    }

    override suspend fun addOrEditWin(win: WinObject): WinObject {
        return localData.saveWin(win);
    }

    override suspend fun removeWin(winId: Int) {
        return localData.removeWin(winId)
    }
}