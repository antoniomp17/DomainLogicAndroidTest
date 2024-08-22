package com.example.domainlogicandroidtest.platform.di

import com.example.domainlogicandroidtest.data.api.GetUsersApiImpl
import com.example.domainlogicandroidtest.domain.usecase.GetUsers
import com.example.domainlogicandroidtest.platform.App
import com.example.domainlogicandroidtest.platform.interactor.Executor
import com.example.domainlogicandroidtest.platform.interactor.GetUsersInteractor
import com.example.domainlogicandroidtest.platform.interactor.MainThread
import com.example.domainlogicandroidtest.platform.interactor.impl.MainThreadImpl
import com.example.domainlogicandroidtest.platform.interactor.impl.ThreadExecutor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {


    @Provides
    @Singleton
    fun provideGetUsers(): GetUsers {
        return GetUsersApiImpl()
    }

    @Provides
    @Singleton
    fun provideExecutor(): Executor {
        return ThreadExecutor()
    }

    @Provides
    @Singleton
    fun provideMainThread(): MainThread {
        return MainThreadImpl()
    }


    @Provides
    @Singleton
    fun provideGetUsersInteractor(
        dataSource: GetUsers,
        executor: Executor,
        mainThread: MainThread
    ): GetUsersInteractor {
        return GetUsersInteractor(dataSource, executor, mainThread)
    }
}