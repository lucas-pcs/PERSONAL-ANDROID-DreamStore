package br.com.lucaspcs.dreamstore.ui.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import br.com.lucaspcs.dreamstore.databinding.ItemProductBinding
import br.com.lucaspcs.dreamstore.model.Product

class ProductListAdapter(private val context: Context, productList: MutableList<Product>) : RecyclerView.Adapter<ProductListAdapter.ProductViewHolder>() {
    private val productListDataSet = productList

    class ProductViewHolder(itemProductBinding: ItemProductBinding) : ViewHolder(itemProductBinding.root){
        private val name = itemProductBinding.itemProductName
        private val value = itemProductBinding.itemProductValue
        private val image = itemProductBinding.itemProductImage

        fun bind(product: Product){
            name.text = product.name
            value.text = product.value
            image.setImageResource(product.image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(context), parent, false)
        return ProductViewHolder(itemProductBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product: Product = productListDataSet[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productListDataSet.size
    }

    fun updateDataSet(newProductList: List<Product>){
        productListDataSet.clear()
        productListDataSet.addAll(newProductList)
        notifyDataSetChanged()
    }
}