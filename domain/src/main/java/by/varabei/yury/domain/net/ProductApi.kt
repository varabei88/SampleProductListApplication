package by.varabei.yury.domain.net

import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.result.DataResult

interface ProductApi {

    suspend fun getProducts(): DataResult<List<Product>>
    suspend fun getProduct(productId: String): DataResult<Product>
}