package by.varabei.yury.data.retrofit.net.model

import by.varabei.yury.domain.model.Product
import org.junit.Assert
import org.junit.Test

class ProductListResponseUnitTest {

    @Test
    fun `verify product list response to product list`() {
        ProductListResponse(generateTestProductListResponse()).toProductList().apply {
            Assert.assertFalse(size == 0)
            Assert.assertEquals(2, size)
            get(0).let {
                it == Product("1", "Apple", 100, "https://test.com/apple", null)
            }
            get(1).let {
                it == Product("2", "Orange", 150, "https://test.com/orange", null)
            }
        }
    }

    @Test
    fun `verify product response to product`() {
        ProductResponse("3", "Onion", 50, "https://test.com/onion", null).toProduct().let {
            it == Product("3", "Onion", 50, "https://test.com/onion", null)
        }
    }

    private fun generateTestProductListResponse() =
        listOf(
            ProductResponse("1", "Apple", 100, "https://test.com/apple", null),
            ProductResponse("2", "Orange", 150, "https://test.com/orange", null)
        )
}