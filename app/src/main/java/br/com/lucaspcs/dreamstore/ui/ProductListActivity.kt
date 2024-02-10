package br.com.lucaspcs.dreamstore.ui

import android.content.Intent
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
    private val activityProductListRecyclerView by lazy { productListBinding.activityProductListRecyclerView }
    private val productDAO = ProductDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(productListBinding.root)

        // testing
        for (i in 0 until 3){
            productDAO.addProduct(Product("teste", "teste", R.drawable.ic_launcher_background))
        }
        activityProductListRecyclerView.adapter = ProductListAdapter(this, productDAO.getProductList().toMutableList())
        activityProductListRecyclerView.layoutManager = LinearLayoutManager(this)

        productListBinding.activityProductListFab.setOnClickListener{
            val goToProductForm = Intent(this, ProductFormActivity::class.java)
            startActivity(goToProductForm)
        }
    }

    override fun onResume() {
        super.onResume()
        val productListAdapter = activityProductListRecyclerView.adapter as ProductListAdapter
        productListAdapter.updateDataSet(productDAO.getProductList())
    }
}