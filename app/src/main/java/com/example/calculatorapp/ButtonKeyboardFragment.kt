package com.example.calculatorapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.calculatorapp.databinding.FragmentButtonKeyboardBinding
import com.example.calculatorapp.databinding.FragmentDisplayBarBinding


class ButtonKeyboardFragment : Fragment() {
    private lateinit var binding: FragmentButtonKeyboardBinding
    private var buttonClickListener: OnButtonClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentButtonKeyboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnButtonClickListener) {
            buttonClickListener = context
        } else {
            throw RuntimeException("$context must implement OnButtonClickListener")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Digits
        binding.btn0.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn1.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn2.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn3.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn4.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn5.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn6.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn7.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn8.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btn9.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        //Operators
        binding.btnSqrt.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btnMod.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btnDivide.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btnMultiply.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btnSubtract.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btnAdd.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        //Clear
        binding.btnCE.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        binding.btnC.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        //Decimal
        binding.btnDecimal.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        //Sign
        binding.btnSign.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

        //Equals
        binding.btnSign.setOnClickListener {
            buttonClickListener?.onButtonClick(getButtonText(it as Button))
        }

    }

    private fun getButtonText(button: Button): String {
        return button.text.toString()
    }

    interface OnButtonClickListener {
        fun onButtonClick(text: String)
    }
}
