package by.varabei.yury.data.retrofit.net.model

import by.varabei.yury.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("product_id") val id: String?,
    val name: String?,
    val price: Int?,
    val image: String?,
    val description: String?
)

internal fun ProductResponse.toProduct(): Product = Product(id, name, price, image, description)