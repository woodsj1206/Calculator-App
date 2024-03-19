package com.example.calculatorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.FragmentButtonKeyboardBinding
import com.example.calculatorapp.databinding.FragmentDisplayBarBinding

class ButtonKeyboardFragment : Fragment() {
    private lateinit var binding : FragmentButtonKeyboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentButtonKeyboardBinding.inflate(inflater, container, false)
        return binding.root
    }
}