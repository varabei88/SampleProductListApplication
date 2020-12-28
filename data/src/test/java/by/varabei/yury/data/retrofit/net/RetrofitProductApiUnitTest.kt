package by.varabei.yury.data.retrofit.net

import by.varabei.yury.domain.net.ProductApi
import by.varabei.yury.domain.net.result.Error
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.net.UnknownHostException

class RetrofitProductApiUnitTest {

    @Mock
    private lateinit var retrofitApiService: ProductRetrofitApiService
    private lateinit var retrofitRemoteDataSource: ProductApi

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        retrofitRemoteDataSource = RetrofitProductApi(retrofitApiService)
    }

    @Test
    fun `verify fetch product list`() = runBlocking {
        kotlin.runCatching {
            Mockito.`when`(retrofitApiService.getProducts()).thenThrow(UnknownHostException::class.java)
        }
        Assert.assertTrue(retrofitRemoteDataSource.getProducts() is Error)
        //TODO: check different Responses
        Unit
    }

    @Test
    fun `test fetch product by id`() = runBlocking {
        kotlin.runCatching {
            Mockito.`when`(retrofitApiService.getProduct(Mockito.anyString())).thenThrow(UnknownHostException::class.java)
        }
        Assert.assertTrue(retrofitRemoteDataSource.getProducts() is Error)
        //TODO: check different Responses
        Unit
    }

}