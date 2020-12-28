package by.varabei.yury.domain.model

data class Product(
    val id: String?,
    val name: String?,
    val price: Int?,
    val imageUrl: String?,
    val description: String? = null
)