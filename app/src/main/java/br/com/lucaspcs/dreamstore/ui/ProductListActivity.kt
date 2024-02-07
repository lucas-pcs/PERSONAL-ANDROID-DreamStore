package br.com.lucaspcs.dreamstore.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.lucaspcs.dreamstore.R
import br.com.lucaspcs.dreamstore.dao.ProductDAO
import br.com.lucaspcs.dreamstore.databinding.ActivityProductListBinding
import br.com.lucaspcs.dreamstore.model.Product
import br.com.lucaspcs.dreamstore.ui.recyclerview.ProductListAdapter

class ProductListActivity : AppCompatActivity() {
    private val productListBinding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(productListBinding.root)

        var productDAO = ProductDAO()
        productDAO.addProduct(Product("teste", "teste", R.drawable.ic_launcher_foreground))
        productDAO.addProduct(Product("teste", "teste", R.drawable.ic_launcher_foreground))
        productDAO.addProduct(Product("teste", "teste", R.drawable.ic_launcher_foreground))

        var activityProductListRecyclerView = productListBinding.activityProductListRecyclerView
        activityProductListRecyclerView.adapter = ProductListAdapter(this, productDAO.getProductList())
        activityProductListRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}