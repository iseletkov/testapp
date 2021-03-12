package ru.psu.mobile.example1.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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