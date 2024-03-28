package com.example.calculatorapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculatorapp.databinding.FragmentButtonKeyboardBinding
import com.example.calculatorapp.databinding.FragmentDisplayBarBinding
import kotlin.math.sqrt

class DisplayBarFragment : Fragment() {
    private lateinit var binding : FragmentDisplayBarBinding

    private var leftOperand = 0.0
    private var rightOperand = 0.0
    private var operator = ' '

    private var cleared = true
    private var calculated = false
    private var setOperator = false
    private var addedDecimal = false
    private var isNegative = false

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
        val displayText = binding.tvDisplay.text.toString()

        when(text){
            "0"->{
                if(displayText != "0"){
                    if(cleared){
                        if(isNegative){
                            binding.tvDisplay.text = "-" + text
                        }
                        else{
                            binding.tvDisplay.text = text
                        }
                    }
                    else{
                        binding.tvDisplay.text = displayText + text
                    }
                }
            }
            "1", "2", "3", "4", "5", "6", "7", "8", "9"-> {
                if(cleared){
                    if(isNegative){
                        binding.tvDisplay.text = "-" + text
                    }
                    else{
                        binding.tvDisplay.text = text
                    }
                    cleared = false
                    addedDecimal = false
                    calculated = false
                }
                else{
                    binding.tvDisplay.text = displayText + text
                }
            }
            "+","-","x","/","%"->{
                if(!setOperator){
                    leftOperand = displayText.toDouble()

                    operator = text.single()
                    setOperator = true

                    cleared = true
                    calculated = false
                    addedDecimal = false

                    isNegative = false
                }
            }
            "√"->{
                leftOperand = displayText.toDouble()
                binding.tvDisplay.text = sqrt(leftOperand).toString()

                cleared = true
                addedDecimal = false
                setOperator = false

                calculated = true
            }
            "CE"-> {
                if(calculated){
                    binding.tvDisplay.text = "0"

                    cleared = true
                    addedDecimal = false
                    setOperator = false

                    calculated = false
                }
                else{
                    if(displayText.length - 1 > 0){
                        if(displayText.last().toString() == "."){
                            addedDecimal = false
                        }

                        binding.tvDisplay.text = displayText.substring(0, displayText.length - 1)

                        if(binding.tvDisplay.text == "-"){
                            binding.tvDisplay.text = "0"
                            cleared = true
                        }
                    }
                    else {
                        binding.tvDisplay.text = "0"
                        cleared = true
                    }
                }
            }
            "C"->{
                binding.tvDisplay.text = "0"

                cleared = true
                addedDecimal = false
                setOperator = false

                calculated = false
                isNegative = false
            }
            "."->{
                if(!addedDecimal){
                    if(cleared){
                        if(isNegative){
                            binding.tvDisplay.text = "-0."
                        }
                        else{
                            binding.tvDisplay.text = "0."
                        }
                    }
                    else{
                        binding.tvDisplay.text = displayText + "."
                    }

                    addedDecimal = true
                    cleared = false
                }
            }
            "+/-"->{
                if(calculated || cleared){
                    binding.tvDisplay.text = "-0"
                    isNegative = true
                }
                else{
                    isNegative = displayText.first().toString() == "-"
                    binding.tvDisplay.text = if (!isNegative) "-${displayText}" else displayText.drop(1)
                }
            }
            "="->{
                if(setOperator){
                    rightOperand = displayText.toDouble()
                    binding.tvDisplay.text = computeAnswer(leftOperand, operator, rightOperand).toString()

                    cleared = true
                    setOperator = false
                    addedDecimal = false

                    calculated = true
                    isNegative = false
                }
            }
        }
        Log.d("VALUE", "${binding.tvDisplay.text.toString().toDouble()}")
        //Log.d("VALUE", "${binding.tvDisplay.text.toString().length}")
    }

    private fun computeAnswer(leftOperand : Double, operator : Char, rightOperand : Double): Double {
        return when(operator){
            '+'-> leftOperand + rightOperand
            '-'-> leftOperand - rightOperand
            'x'-> leftOperand * rightOperand
            '/'-> leftOperand / rightOperand
            '%'-> leftOperand % rightOperand
            else-> -1.0
        }
    }
}