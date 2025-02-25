package com.example.lab0314bt01

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar


class FirstFragment : Fragment(R.layout.fragment_first) {

    private val products = listOf("Product 1", "Product 2", "Product 3", "Product 4")
    private val cart = mutableListOf<String>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = ProductAdapter(products) { product ->
            // Hiển thị Dialog xác nhận thêm sản phẩm vào giỏ hàng
            AlertDialog.Builder(requireContext())
                .setTitle("Add to Cart")
                .setMessage("Do you want to add $product to your cart?")
                .setPositiveButton("Yes") { dialog, _ ->
                    // Thêm sản phẩm vào giỏ hàng
                    cart.add(product)
                    Snackbar.make(view, "$product added to cart",
                        Snackbar.LENGTH_SHORT).show()
                }
                .setNegativeButton("No", null)
                .show()
        }



     //    Nút điều hướng tới giỏ hàng
        view.findViewById<Button>(R.id.buttonViewCart).setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(cart.toTypedArray())
            findNavController().navigate(action)
        }
    }
}