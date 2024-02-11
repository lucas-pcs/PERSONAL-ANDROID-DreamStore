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
import java.math.BigDecimal

class ProductListActivity : AppCompatActivity() {
    private val productListBinding by lazy {
        ActivityProductListBinding.inflate(layoutInflater)
    }
    private val activityProductListRecyclerView by lazy {
        productListBinding.activityProductListRecyclerView
    }
    private val productListAdapter: ProductListAdapter by lazy {
        activityProductListRecyclerView.adapter as ProductListAdapter
    }
    private val productDAO = ProductDAO()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(productListBinding.root)

        // testing
        addDummyProductsToProductList()
        configureRecyclerView()
        configureFABbutton()
    }

    private fun addDummyProductsToProductList() {
        for (i in 0 until 3) {
            productDAO.addProduct(
                Product(
                    "teste",
                    BigDecimal("19.99"),
                    R.drawable.ic_launcher_background
                )
            )
        }
    }

    private fun configureRecyclerView() {
        activityProductListRecyclerView.adapter =
            ProductListAdapter(this, productDAO.getProductList().toMutableList())
        activityProductListRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun configureFABbutton() {
        productListBinding.activityProductListFab.setOnClickListener {
            val goToProductForm = Intent(this, ProductFormActivity::class.java)
            startActivity(goToProductForm)
        }
    }

    override fun onResume() {
        super.onResume()
        productListAdapter.updateDataSet(productDAO.getProductList())
    }
}