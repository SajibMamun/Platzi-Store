package com.example.platzistore.ui.Product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.platzistore.R
import com.example.platzistore.databinding.FragmentProductBinding
import com.example.platzistore.databinding.FragmentRegisterBinding
import com.example.platzistore.ui.auth.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {
    lateinit var binding: FragmentProductBinding
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        viewModel.getAllProduct()
        return binding.root



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.productResponse.observe(viewLifecycleOwner){

            if(it.isSuccessful)
            {
                val adapter=ProductAdapter()
                adapter.submitList(it.body())
                binding.Recyclerviewid.adapter=adapter

            }
        }
    }
}
