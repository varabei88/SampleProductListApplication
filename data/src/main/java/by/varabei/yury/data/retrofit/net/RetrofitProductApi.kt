package by.varabei.yury.data.retrofit.net

import by.varabei.yury.data.retrofit.net.model.toProduct
import by.varabei.yury.data.retrofit.net.model.toProductList
import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.ProductApi
import by.varabei.yury.domain.net.result.Error
import by.varabei.yury.domain.net.result.DataResult
import by.varabei.yury.domain.net.result.Success
import retrofit2.Response
import java.lang.Exception
import java.lang.RuntimeException

class RetrofitProductApi(
    private val retrofitApiService: ProductRetrofitApiService
) : ProductApi {

    override suspend fun getProducts(): DataResult<List<Product>> =
        try {
            retrofitApiService.getProducts().convertToResult { productListResponse ->
                productListResponse.toProductList()
            }
        } catch (e: Exception) {
            Error(null, e)
        }

    override suspend fun getProduct(
        productId: String
    ): DataResult<Product> =
        try {
            retrofitApiService.getProduct(productId).convertToResult { productResponse ->
                productResponse.toProduct()
            }
        } catch (e: Exception) {
            Error(null, e)
        }

    private fun <T, R> Response<T>.convertToResult(parseFunction: (T) -> R): DataResult<R> =
        body()?.let {
            if (this.isSuccessful) Success(parseFunction(it)) else Error(null, RuntimeException())
        } ?: Error(null, RuntimeException())

}