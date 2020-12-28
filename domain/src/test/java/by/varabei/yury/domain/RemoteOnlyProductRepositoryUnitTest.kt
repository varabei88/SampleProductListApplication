package by.varabei.yury.domain

import by.varabei.yury.domain.source.remote.RemoteDataSource
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class RemoteOnlyProductRepositoryUnitTest {

    @Mock private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var repository: ProductRepository

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)
        repository = RemoteOnlyProductRepository(remoteDataSource)
    }

    @Test
    fun `verify get products`() = runBlocking {
        repository.getProducts()
        Mockito.verify(remoteDataSource, Mockito.times(1)).getProducts()
        Mockito.verify(remoteDataSource, Mockito.never()).getProduct(Mockito.anyString())
        Unit
    }

    @Test
    fun `verify get product by id`() = runBlocking {
        repository.getProduct("1")
        Mockito.verify(remoteDataSource, Mockito.times(1)).getProduct("1")
        Mockito.verify(remoteDataSource, Mockito.never()).getProducts()
        Unit
    }

}