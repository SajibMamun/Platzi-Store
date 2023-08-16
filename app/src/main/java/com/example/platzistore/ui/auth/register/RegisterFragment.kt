package com.example.platzistore.ui.auth.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.platzistore.R

import com.example.platzistore.databinding.FragmentRegisterBinding
import com.example.platzistore.model.data.register.RequestRegister
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding


    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.loginTextView.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }



        binding.registerButton.setOnClickListener {


            val email = binding.emailEditText?.text.toString().trim()
            val name = binding.nameEditText?.text.toString().trim()
            val password = binding.passwordEditText?.text.toString().trim()
            val conPass = binding.confirmPasswordEditText?.text.toString().trim()
            val imageAvatar = "https://wallpaperaccess.com/full/2362086.png"
            if (name.isEmpty()) {
                binding.nameEditText.error = "Enter Name"
            } else if (email.isEmpty()) {
                binding.emailEditText.error = "Enter Email"
            } else if (password.isEmpty()) {
                binding.passwordEditText.error = "Enter Password"
            } else if (conPass.isEmpty()) {
                binding.passwordEditText.error = "Enter Password"
            } else if (conPass != password) {
                binding.passwordEditText.error = "Password Not Matched"
            } else {
                handleRegister(name, email, password, imageAvatar)
            }


        }



        viewModel.registerresponse.observe(viewLifecycleOwner) {
            if (it.isSuccessful()) {
                Toast.makeText(requireContext(), "User Create Successfully", Toast.LENGTH_SHORT)
                    .show()
                Log.d("TAG", "${it.body()}")
            }


        }
    }

    private fun handleRegister(name: String, email: String, password: String, imageAvatar: String) {
        val request =
            RequestRegister(name = name, email = email, password = password, avatar = imageAvatar)

        viewModel.register(request)
    }
}