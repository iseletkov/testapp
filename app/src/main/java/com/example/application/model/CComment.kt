package com.example.application.model
import org.threeten.bp.LocalDateTime

data class CComment (
        var author                          : String, //CUser
        var text                            : String,
        var time                            : LocalDateTime
)