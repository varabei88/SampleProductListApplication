package by.varabei.yury.sample.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import by.varabei.yury.domain.model.Product
import by.varabei.yury.sample.SampleApplication
import by.varabei.yury.sample.databinding.FragmentProductListBinding
import by.varabei.yury.sample.view.adapter.ProductListAdapter
import by.varabei.yury.sample.viewmodel.ProductViewModel

class ProductListFragment : Fragment() {

    private val viewModel: ProductViewModel by viewModels()

    private lateinit var viewBinding: FragmentProductListBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context.applicationContext as SampleApplication).applicationComponent.inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentProductListBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        viewModel.observeProductList().observe(viewLifecycleOwner,
            Observer<List<Product>> { productList ->
                //TODO : Just for sample to set adapter each time when product list is available
                viewBinding.productList.adapter =
                    ProductListAdapter(
                        productList
                    )
            })
        viewModel.fetchProductList()
    }

    private fun initUi() {
        viewBinding.productList.apply {
            //TODO: Just for sample to use layout margins between items. In fact, to have equal space between left and right sides and between list items it's better to set margins in extending GridLayoutManager
            layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }
}