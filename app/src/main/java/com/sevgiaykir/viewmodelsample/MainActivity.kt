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
        //setContentView(R.layout.activity_main)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel=viewModel
        //Tüm live data'ları otomatik observe eder
        binding.lifecycleOwner=this

        //val clickMeButton=findViewById<Button>(R.id.clickMeButton)
        //ya da val clickMeButton : Button=findViewById(R.id.clickMeButton)
        //val counterText=findViewById<TextView>(R.id.counterText)

        //1. View Binding (replaces findViewById)
        //2. Data Binding
        //3. (Deprecated) synthetic imports (kotlin-android-extensions)
        //********************************************
        //observer pattern
        //

        //counterText.text= viewModel.convertCounter()

//        clickMeButton.setOnClickListener{
//            viewModel.incrementCounter()
//            //counterText.text= viewModel.convertCounter()
//        }
    }
}