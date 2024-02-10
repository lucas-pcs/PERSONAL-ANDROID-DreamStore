package br.com.lucaspcs.dreamstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import br.com.lucaspcs.dreamstore.R
import br.com.lucaspcs.dreamstore.dao.ProductDAO
import br.com.lucaspcs.dreamstore.databinding.ActivityProductFormBinding
import br.com.lucaspcs.dreamstore.model.Product

class ProductFormActivity : AppCompatActivity() {
    private val activityProductFormBinding by lazy { ActivityProductFormBinding.inflate(layoutInflater) }
    private val productDAO = ProductDAO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityProductFormBinding.root)

        activityProductFormBinding.activityProductFormSave.setOnClickListener {
            val productName = activityProductFormBinding.activityProductFormName.text.toString()
            val productValue = activityProductFormBinding.activityProductFormValue.text.toString()
            productDAO.addProduct(Product(productName, productValue, R.drawable.ic_launcher_background))
            finish()
        }
    }
}