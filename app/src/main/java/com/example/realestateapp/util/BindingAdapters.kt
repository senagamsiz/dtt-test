package com.example.realestateapp.util

import com.example.realestateapp.R

import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.NumberFormat



@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.splash_dtt)
                    .error(R.drawable.splash_dtt)
            )
            .into(imageView)
    }
}

@BindingAdapter("price")
fun bindCurrencyText(textView: TextView, price: Int){
    val format: NumberFormat = NumberFormat.getCurrencyInstance()
    format.setMaximumFractionDigits(0)
    val housePrice = format.format(price)
    textView.text = housePrice
}