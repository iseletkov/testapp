package ru.psu.mobile.example1.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ru.psu.mobile.example1.model.CComment

@Dao
interface CDAOComments {

    @Query("SELECT * from comments ORDER BY time ASC")
    fun getAllComments(): LiveData<List<CComment>>

    @Insert
    fun insert(comments: CComment?)

}