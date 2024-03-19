/*
App Name: CalculatorApp
Author: woodsj1206 (https://github.com/woodsj1206)
Description: A simple calculator app that uses fragments.
Course: CIS 436
Date Created: 3/17/24
Last Modified: 3/19/24
*/
package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}