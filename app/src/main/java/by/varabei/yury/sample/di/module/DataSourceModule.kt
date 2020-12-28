package by.varabei.yury.sample.di.module

import by.varabei.yury.data.retrofit.source.remote.RetrofitRemoteDataSource
import by.varabei.yury.domain.net.ProductApi
import by.varabei.yury.domain.source.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun providesRemoteDataSource(productApi: ProductApi): RemoteDataSource =
        RetrofitRemoteDataSource(productApi)
}