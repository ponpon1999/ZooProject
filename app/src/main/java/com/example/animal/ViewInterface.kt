package com.example.animal

interface ViewInterface {
    fun show(name:MutableList<String>, info:MutableList<String>, pic_url:MutableList<String>)
}

interface ViewInterfacePresenter{
    fun processCall()
}

interface PlantViewInterfacePresenter{
    fun processCall()
}