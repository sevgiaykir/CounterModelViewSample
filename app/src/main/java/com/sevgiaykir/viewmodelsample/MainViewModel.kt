package com.sevgiaykir.viewmodelsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    //private var counter=0
    //Polymorphism
    private val _counter=MutableLiveData<Int>()
    val counter:LiveData<String> = Transformations.map(_counter) {
        it.toString()
    }

    /*
    init {
        Log.e("ViewModel", "is Created")
    }  */

    init {
        _counter.value=0
    }

    fun incrementCounter(){
        //counter++
        _counter.value=_counter.value!!+1 //bu değer null ise programı crush et
    }

//    fun convertCounter():String{
//        //return counter.toString()
//        return _counter.value.toString()
//    }
    //fun counter()=counter.toString()

    override fun onCleared() {
        super.onCleared()
        Log.e("ViewModel", "is Cleared")
    }
}