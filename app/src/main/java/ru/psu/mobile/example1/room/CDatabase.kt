package ru.psu.mobile.example1.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.psu.mobile.example1.dao.CDAOComments
import ru.psu.mobile.example1.model.CComment

@Database(entities = [CComment::class], version = 1, exportSchema = false)
abstract class CDatabase : RoomDatabase()
{
    abstract fun daoComments(): CDAOComments

    companion object {
        private var INSTANCE: CDatabase? = null

        fun getDatabase(context: Context): CDatabase?
        {
            if (INSTANCE == null) {
                synchronized(CDatabase::class.java)
                {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            CDatabase::class.java,
                            "db"
                        ) // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}

