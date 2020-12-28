package by.varabei.yury.data.retrofit.net.model

import by.varabei.yury.domain.model.Product

data class ProductListResponse(
    val products : List<ProductResponse>?
)

internal fun ProductListResponse.toProductList(): List<Product> = products?.map { productResponse ->
    productResponse.toProduct()
}?: emptyList()