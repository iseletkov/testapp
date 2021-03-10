package com.example.application.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.application.dao.CDAOComments
import com.example.application.model.CComment
import com.example.application.room.CDatabase
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class CRepositoryComments (application: Application)
{
    private val mDaoComments: CDAOComments
    private val mComments: LiveData<List<CComment>>

    init {
        val db = CDatabase.getDatabase(application)

        mDaoComments = db!!.daoComments()
        mComments = mDaoComments.getAllComments()
    }

    val comments: LiveData<List<CComment>>
        get() = mComments

    fun insert(comment: CComment)
    {
        Single.fromCallable {
            mDaoComments.insert(comment)
        }
            .subscribeOn(Schedulers.io())
            .subscribe()
    }
}
