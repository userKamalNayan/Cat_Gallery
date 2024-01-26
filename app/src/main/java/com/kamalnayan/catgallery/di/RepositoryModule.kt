package com.kamalnayan.catgallery.di

import com.kamalnayan.data.repository.CatRepository
import com.kamalnayan.domain.repository.ICatRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** @Author Kamal Nayan
Created on: 25/01/24
 **/
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindCharacterRepository(catRepository: CatRepository): ICatRepository

}