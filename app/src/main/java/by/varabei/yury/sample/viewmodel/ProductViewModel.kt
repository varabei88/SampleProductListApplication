package by.varabei.yury.sample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.varabei.yury.domain.ProductRepository
import by.varabei.yury.domain.model.Product
import by.varabei.yury.domain.net.result.Error
import by.varabei.yury.domain.net.result.Success
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel : ViewModel() {

    @Inject
    lateinit var repository: ProductRepository

    private val productListLiveData = MutableLiveData<List<Product>>()
    private val errorLiveData = MutableLiveData<String>()

    fun observeProductList(): LiveData<List<Product>> = productListLiveData
    fun observeError(): LiveData<String> = errorLiveData

    fun fetchProductList() {
        viewModelScope.launch {
            repository.getProducts().let { result ->
                when (result) {
                    is Success ->
                        productListLiveData.value = result.data
                    //TODO: Handle errors
                    is Error -> errorLiveData.value = result.exception.message
                }
            }
        }
    }
}