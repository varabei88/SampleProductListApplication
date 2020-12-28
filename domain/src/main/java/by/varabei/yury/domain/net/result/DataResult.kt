package by.varabei.yury.domain.net.result

import java.lang.Exception

sealed class DataResult<out T>
data class Success<T>(val data: T?) : DataResult<T>()
data class Error<T>(val data: T?, val exception: Exception) : DataResult<T>()