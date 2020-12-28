package by.varabei.yury.sample.di.module

import by.varabei.yury.data.retrofit.net.ProductRetrofitApiService
import by.varabei.yury.data.retrofit.net.RetrofitProductApi
import by.varabei.yury.domain.net.ProductApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule(private val baseUrl : String, private val isDebug: Boolean) {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            if(isDebug) addInterceptor(HttpLoggingInterceptor().apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            })
        }.build()
    }

    @Singleton
    @Provides
    fun provideProductRetrofitApiService(okHttpClient: OkHttpClient) : ProductRetrofitApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ProductRetrofitApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideProductApi(productRetrofitApiService: ProductRetrofitApiService): ProductApi =
        RetrofitProductApi(productRetrofitApiService)
}