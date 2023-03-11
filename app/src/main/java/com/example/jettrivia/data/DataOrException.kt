package com.example.jettrivia.data


// here we'll definge generics
data class DataOrException<T, Boolean , E: Exception>(
    var data : T? =null,
    var loading : Boolean? = null,
    var e : E? = null


)


