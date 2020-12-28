package by.varabei.yury.sample.di.component

import by.varabei.yury.domain.ProductRepository
import by.varabei.yury.sample.MainActivity
import by.varabei.yury.sample.di.module.ApiModule
import by.varabei.yury.sample.di.module.DataSourceModule
import by.varabei.yury.sample.di.module.RepositoryModule
import by.varabei.yury.sample.viewmodel.ProductViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, DataSourceModule::class, RepositoryModule::class])
interface ApplicationComponent {

    fun inject(viewModel: ProductViewModel)
}