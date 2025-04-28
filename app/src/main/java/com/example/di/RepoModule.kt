package com.example.di

import com.example.data.repo.RepoImpl
import com.example.data.repo.RepoNote
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class  RepoModule {
    @Binds
    @Singleton
    abstract  fun bindRepoNote(repoNote: RepoImpl): RepoNote

}