package com.example.application.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.application.model.CComment

@Dao
interface CDAOComments {

    @Query("SELECT * from comments ORDER BY time ASC")
    fun getAllComments(): LiveData<List<CComment>>

    @Insert
    fun insert(comments: CComment?)

}