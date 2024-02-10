package br.com.lucaspcs.dreamstore.dao

import br.com.lucaspcs.dreamstore.model.Product

class ProductDAO {

    fun addProduct(product: Product) {
        productList.add(product)
    }

    fun getProductList(): List<Product> {
        return productList
    }

    companion object {
        private val productList: ArrayList<Product> = ArrayList<Product>()
    }
}