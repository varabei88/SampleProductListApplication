package by.varabei.yury.data.retrofit.source.remote

import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.ProductApi
import by.varabei.yury.domain.net.result.DataResult
import by.varabei.yury.domain.source.remote.RemoteDataSource

class RetrofitRemoteDataSource(private val api: ProductApi) : RemoteDataSource {
    override suspend fun getProducts(): DataResult<List<Product>> = api.getProducts()
    override suspend fun getProduct(id: String): DataResult<Product> = api.getProduct(id)
}