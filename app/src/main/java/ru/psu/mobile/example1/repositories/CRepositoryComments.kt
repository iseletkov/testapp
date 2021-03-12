package ru.psu.mobile.example1.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import ru.psu.mobile.example1.dao.CDAOComments
import ru.psu.mobile.example1.model.CComment
import ru.psu.mobile.example1.room.CDatabase
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
