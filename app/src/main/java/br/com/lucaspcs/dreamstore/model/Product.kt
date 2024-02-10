package br.com.lucaspcs.dreamstore.model

import android.graphics.drawable.Drawable
import java.math.BigDecimal

data class Product(
    val name: String,
    val value: BigDecimal,
    val image: Int
) {
}