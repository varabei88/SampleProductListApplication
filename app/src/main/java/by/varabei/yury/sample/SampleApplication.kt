package by.varabei.yury.sample

import android.app.Application
import android.os.StrictMode
import by.varabei.yury.sample.di.component.ApplicationComponent
import by.varabei.yury.sample.di.component.DaggerApplicationComponent
import by.varabei.yury.sample.di.module.ApiModule

class SampleApplication : Application() {

    val applicationComponent: ApplicationComponent = DaggerApplicationComponent.builder().apiModule(
        ApiModule(
            "https://s3-eu-west-1.amazonaws.com/developer-application-test/",
            BuildConfig.DEBUG
        )
    ).build()

    override fun onCreate() {
        super.onCreate()
        setUpStrictMode(BuildConfig.DEBUG)
    }

    private fun setUpStrictMode(isNeededStrictMode: Boolean) {
        if (isNeededStrictMode) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder()
                    .detectAll()
                    .penaltyLog()
                    .build()
            )
        }
    }
}