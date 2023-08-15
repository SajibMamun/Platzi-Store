package com.example.platzistore.ui.auth.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import com.example.platzistore.R
import com.example.platzistore.databinding.FragmentLoginBinding
import com.example.platzistore.model.data.login.RequestLogin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding


    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding=FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener { 
            
            
            val email=binding.emailEditText?.text.toString()
            val password=binding.passwordEditText?.text.toString()
            
            handleLogin(email,password)

        }

        viewModel.loginresponse.observe(viewLifecycleOwner) {

            if (!it.accessToken.isNullOrBlank()) {
                Toast.makeText(requireContext(), "Login success ! ", Toast.LENGTH_SHORT).show()

            }
            Log.d("TAG", "Token: $it ")

        }


    }



    private fun handleLogin(email: String, password: String) {
        val requestLogin=RequestLogin(email = email, password = password)
        viewModel.login(requestLogin)


    }
}