package com.example.a2pageapp.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.a2pageapp.R
import com.example.a2pageapp.databinding.FragmentFirstPageBinding
import com.example.a2pageapp.databinding.FragmentSecondPageBinding

class SecondPage: Fragment() {

    private val argument: SecondPageArgs by navArgs()

    private val secondPageViewModel by viewModels<SecondPageViewModel>()
    private lateinit var binding: FragmentSecondPageBinding
    private var fragmentView: View? = null
    private lateinit var navController: NavController

    private lateinit var newFirst : String
    private lateinit var newLast : String
    private lateinit var newEmail : String
    private lateinit var newDob : String


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (fragmentView != null) {
            return fragmentView
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_page, container, false)
        fragmentView = binding.root
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        binding.toolbarItem.tvCancel.setOnClickListener {
            navController.navigateUp()
        }

        binding.root

        newFirst = argument.firstName
        newLast = argument.lastName
        newEmail = argument.email
        newDob = argument.dob

        binding.etFirstName.setText(argument.firstName)
        binding.etLastName.setText(argument.lastName)
        binding.etEmail.setText(argument.email)
        binding.etDob.setText(argument.dob)

        binding.etFirstName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                newFirst = s.toString()
            }
        })

        binding.etLastName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                newLast = s.toString()
            }
        })

        binding.etEmail.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                newEmail = s.toString()
            }
        })

        binding.etDob.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                newDob = s.toString()
            }
        })

        binding.toolbarItem.tvSave.setOnClickListener {
            navController.navigate(
                SecondPageDirections.actionSecondPageToFirstPage(
                    newFirst,
                    newLast,
                    newEmail,
                    newDob
                )
            )
        }





    }

}