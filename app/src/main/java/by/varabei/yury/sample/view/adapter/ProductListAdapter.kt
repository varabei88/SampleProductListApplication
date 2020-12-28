package by.varabei.yury.sample.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import by.varabei.yury.domain.model.Product
import by.varabei.yury.sample.R
import by.varabei.yury.sample.databinding.ProductListItemBinding
import com.bumptech.glide.Glide

class ProductListAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder =
        ProductViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_list_item, parent, false)
        )

    override fun getItemCount(): Int =
        productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(productList[position])
    }

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ProductListItemBinding.bind(view)
    }

    private fun ProductViewHolder.bindProduct(product: Product) {
        binding.productImage.loadFromUrl(product.imageUrl)
        binding.productName.text = product.name ?: ""
        binding.productPrice.text = product.price?.toString() ?: ""
    }

    private fun ImageView.loadFromUrl(url: String?) {
        url?.let {
            Glide.with(this).load(url).into(this)
        }//TODO: Put error placeholder
    }
}