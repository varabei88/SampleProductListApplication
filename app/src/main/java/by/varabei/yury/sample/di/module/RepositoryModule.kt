package by.varabei.yury.sample.di.module

import by.varabei.yury.domain.ProductRepository
import by.varabei.yury.domain.RemoteOnlyProductRepository
import by.varabei.yury.domain.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesRepository(remoteDataSource: RemoteDataSource) : ProductRepository {
        return RemoteOnlyProductRepository(
            remoteDataSource
        )
    }
}