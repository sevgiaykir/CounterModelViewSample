package com.sevgiaykir.viewmodelsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.sevgiaykir.viewmodelsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    //ya da
    //private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel=viewModel

        val clickMeButton=findViewById<Button>(R.id.clickMeButton)
        //ya da val clickMeButton : Button=findViewById(R.id.clickMeButton)
        val counterText=findViewById<TextView>(R.id.counterText)


        //********************************************
        //observer pattern
        viewModel.counter.observe(this){
            counterText.text= it
        }

        //counterText.text= viewModel.convertCounter()

        clickMeButton.setOnClickListener{
            viewModel.incrementCounter()
            //counterText.text= viewModel.convertCounter()
        }
        Log.e("MainActivity", "is onCreate")
    }
}