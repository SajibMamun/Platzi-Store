package com.example.platzistore.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.example.platzistore.R
import com.example.platzistore.databinding.FragmentLoginBinding
import com.example.platzistore.databinding.FragmentRegisterBinding
import com.example.platzistore.ui.auth.login.LoginViewModel
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

        binding.registerButton.setOnClickListener {


            val email = binding.emailEditText?.text.toString()
            val name = binding.nameEditText?.text.toString()
            val password = binding.passwordEditText?.text.toString()
            val conPass = binding.confirmPasswordEditText?.text.toString()
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
                handleRegister(name, email, password)
            }


        }
    }

    private fun handleRegister(name: String, email: String, password: String) {

    }
}