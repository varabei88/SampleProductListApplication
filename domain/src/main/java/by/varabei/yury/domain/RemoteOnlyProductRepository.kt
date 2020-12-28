package by.varabei.yury.domain

import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.result.DataResult
import by.varabei.yury.domain.source.remote.RemoteDataSource

//TODO: To have cache mechanism, just create RemoteLocalProductRepository with adding remoteDataSource and localDataSource implementations.
class RemoteOnlyProductRepository(private val remoteDataSource: RemoteDataSource) :
    ProductRepository {

    override suspend fun getProducts(): DataResult<List<Product>> = remoteDataSource.getProducts()

    override suspend fun getProduct(id: String): DataResult<Product> = remoteDataSource.getProduct(id)
}