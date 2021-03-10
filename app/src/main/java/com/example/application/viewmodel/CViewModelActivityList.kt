package com.example.application.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.application.model.CComment
import com.example.application.repositories.CRepositoryComments
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter


class CViewModelActivityList(
    application: Application
) : AndroidViewModel(application)
{
    private val mRepository: CRepositoryComments = CRepositoryComments(application)
    private val mComments: LiveData<List<CComment>> = mRepository.comments

    init {
        insert( CComment(
            null,
            "Пушкин А.С.", "Я не плохой поэт", LocalDateTime.parse(
                "1738-12-03T10:15:30",
                DateTimeFormatter.ISO_LOCAL_DATE_TIME
            ).toString()
        ))

        insert(
            CComment(
                null,
                "123", "456", LocalDateTime.parse(
                    "2021-12-03T10:15:30",
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME
                ).toString()

             )
        )
        insert(
            CComment(
                null,
                "Вася Пупкин", "Мне нравится Пушкин", LocalDateTime.parse(
                    "2020-12-03T11:15:30",
                    DateTimeFormatter.ISO_LOCAL_DATE_TIME
                ).toString()

        )
        )
    }


    val comments: LiveData<List<CComment>>
        get() = mComments

    fun insert(comment: CComment) {
        mRepository.insert(comment)
    }
}
