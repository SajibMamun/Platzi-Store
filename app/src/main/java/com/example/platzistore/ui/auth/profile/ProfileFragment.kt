package com.example.platzistore.ui.auth.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.platzistore.R
import com.example.platzistore.databinding.FragmentLoginBinding
import com.example.platzistore.databinding.FragmentProfileBinding
import com.example.platzistore.ui.auth.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : Fragment() {
lateinit var binding: FragmentProfileBinding

    private val viewModel: ProfileViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getProfile()
        viewModel.profileResponse.observe(viewLifecycleOwner)
        {
            if(it.isSuccessful)
            {


                it.body()?.let {profile ->
                    binding.nameTextView.text=profile.name
                    binding.emailTextView.text=profile.email

                    binding.profileImage.load(profile.avatar)
                }

            }
        }




    }
}