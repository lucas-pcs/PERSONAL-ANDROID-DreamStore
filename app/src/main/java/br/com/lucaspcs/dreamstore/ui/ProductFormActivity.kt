package br.com.lucaspcs.dreamstore.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.com.lucaspcs.dreamstore.R
import br.com.lucaspcs.dreamstore.dao.ProductDAO
import br.com.lucaspcs.dreamstore.databinding.ActivityProductFormBinding
import br.com.lucaspcs.dreamstore.model.Product
import java.math.BigDecimal

class ProductFormActivity : AppCompatActivity() {
    private val activityProductFormBinding by lazy { ActivityProductFormBinding.inflate(layoutInflater) }
    private val productDAO = ProductDAO()
    private val TAG = "ProductFormActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityProductFormBinding.root)

        activityProductFormBinding.activityProductFormSave.setOnClickListener {
            val productName = activityProductFormBinding.activityProductFormName.text.toString()
            val productValueString = activityProductFormBinding.activityProductFormValue.text.toString()

            if(productName.isNullOrBlank()){
                Toast.makeText(this, "Please, enter a valid name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(productValueString.isNullOrBlank()){
                Toast.makeText(this, "Please, enter a valid value number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            val productValue = BigDecimal(productValueString)

            productDAO.addProduct(Product(productName, productValue, R.drawable.ic_launcher_background))

            Log.d(TAG, "onCreate: productList: ${productDAO.getProductList()}")
            finish()
        }
    }
}