package br.com.lucaspcs.dreamstore.dao

import br.com.lucaspcs.dreamstore.model.Product

class ProductDAO {
    fun getProductList(): List<Product> {
        return Companion.productList
    }

    fun addProduct(product: Product) {
        productList.add(product)
    }

    companion object {
        private val productList: ArrayList<Product> = ArrayList<Product>()
    }
}