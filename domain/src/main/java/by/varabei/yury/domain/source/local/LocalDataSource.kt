package by.varabei.yury.domain.source.local

import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.result.DataResult

interface LocalDataSource {

    suspend fun putProducts(products: List<Product>)
    suspend fun putProduct(product: Product)
    suspend fun getProducts(): DataResult<List<Product>>
    suspend fun getProduct(id: String): DataResult<Product>
}