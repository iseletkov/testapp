package com.example.application.model
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDateTime
import java.util.*

@Entity(tableName = "comments")
data class CComment (
        @PrimaryKey
        @ColumnInfo(name                    = "id")
        var id                              : Int?
                                        = null,
        var author                          : String, //CUser
        var text                            : String,
        var time                            : String
)