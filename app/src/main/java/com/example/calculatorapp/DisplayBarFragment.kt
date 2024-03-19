package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.FragmentButtonKeyboardBinding
import com.example.calculatorapp.databinding.FragmentDisplayBarBinding

class DisplayBarFragment : Fragment() {

    private lateinit var binding : FragmentDisplayBarBinding

    private var cleared = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDisplayBarBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun updateDisplay(text: String){
        when(text){
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"-> {
                if(cleared){
                    binding.tvDisplay.text = text
                    cleared = false
                }
                else{
                    binding.tvDisplay.text = binding.tvDisplay.text.toString() + text
                }
            }
            "CE"-> {
                val stringLength = binding.tvDisplay.text.toString().length
                if(stringLength - 1 > 0){
                    binding.tvDisplay.text = binding.tvDisplay.text.toString().substring(0, stringLength - 1)
                }
                else {
                    binding.tvDisplay.text = "0"
                    cleared = true
                }
                //Log.d("VALUE", "${binding.tvDisplay.text.toString().length - 1}")
            }
            "C"->{
                binding.tvDisplay.text = "0"
                cleared = true
            }

        }
    }

}