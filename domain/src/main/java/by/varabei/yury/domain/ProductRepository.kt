package by.varabei.yury.domain

import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.result.DataResult

interface ProductRepository {

    suspend fun getProducts(): DataResult<List<Product>>
    suspend fun getProduct(id: String): DataResult<Product>
}