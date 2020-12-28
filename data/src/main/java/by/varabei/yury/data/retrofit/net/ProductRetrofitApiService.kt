package by.varabei.yury.data.retrofit.net

import by.varabei.yury.data.retrofit.net.model.ProductListResponse
import by.varabei.yury.data.retrofit.net.model.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductRetrofitApiService {

    @GET("cart/list")
    suspend fun getProducts(): Response<ProductListResponse>

    @GET("cart/{product_id}/detail")
    suspend fun getProduct(@Path("product_id") productId: String): Response<ProductResponse>


}