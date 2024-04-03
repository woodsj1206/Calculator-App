/*
App Name: CalculatorApp
Author: woodsj1206 (https://github.com/woodsj1206)
Description: A simple calculator app that uses fragments.
Course: CIS 436
Date Created: 3/17/24
Last Modified: 4/2/24
*/
package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ButtonKeyboardFragment.OnButtonClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onButtonClick(text: String) {
        val displayBarFragment = supportFragmentManager.findFragmentById(R.id.fcvDisplayBar) as DisplayBarFragment
        displayBarFragment.updateDisplay(text)
    }
}
