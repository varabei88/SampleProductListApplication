package by.varabei.yury.domain.source.remote

import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.result.DataResult

interface RemoteDataSource {

    suspend fun getProducts(): DataResult<List<Product>>
    suspend fun getProduct(id: String): DataResult<Product>
}