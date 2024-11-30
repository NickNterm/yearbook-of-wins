package com.iqsoft.yearbookofwins.data

import kotlinx.coroutines.flow.Flow
import androidx.room.ConstructedBy
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Entity
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor


@Database(entities = [WinEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): WinDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}

@Dao
interface WinDao {
    @Insert
    suspend fun insert(item: WinEntity)

    @Query("SELECT count(*) FROM WinEntity")
    suspend fun count(): Int

    @Query("SELECT * FROM WinEntity")
    fun getAllWins(): Flow<List<WinEntity>>

    @Query("SELECT * FROM WinEntity WHERE id = :id")
    fun getSingleWin(id: Int): Flow<WinEntity?>

    @Query("DELETE FROM WinEntity WHERE id = :id")
    fun deleteWin(id: Int)
}

@Entity
data class WinEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String,
    val description: String,
    val date: String
)
