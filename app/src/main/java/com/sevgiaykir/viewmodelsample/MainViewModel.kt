package com.sevgiaykir.viewmodelsample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    //private var counter=0
    private val counter=MutableLiveData<Int>()

    //value yi transform etmek
    val counterString:LiveData<String> = Transformations.map(counter) {
        it.toString()
    }

    init {
        //Log.e("ViewModel", "is Created")
        counter.value=0
    }

    fun incrementCounter(){
        //counter++
        counter.value=counter.value!!+1 //bu değer null ise programı crush et
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("ViewModel", "is Cleared")
    }
}