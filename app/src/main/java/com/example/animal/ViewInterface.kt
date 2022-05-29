package com.example.animal

interface ViewInterface {
    fun show(name:MutableList<String>, info:MutableList<String>, pic_url:MutableList<String>)
}

interface ViewInterfacePresenter{
    fun processCall()
}

interface PlantViewInterface {
    fun show(AlsoKnown:MutableList<String>, Location:MutableList<String>, Pic_url:MutableList<String>)
}

interface PlantViewInterfacePresenter{
    fun processCall()
}