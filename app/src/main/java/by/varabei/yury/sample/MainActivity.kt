package by.varabei.yury.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.varabei.yury.sample.view.ProductListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container, ProductListFragment()).commit()
    }
}