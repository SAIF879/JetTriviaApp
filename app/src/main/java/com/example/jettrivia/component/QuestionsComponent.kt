package com.example.jettrivia.component

import android.util.Log
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import com.example.jettrivia.screens.QuestionsViewModel

@Composable
fun Questions(viewModel: QuestionsViewModel){
    val questions = viewModel.data.value.data?.toMutableList()
    if (viewModel.data.value.loading==true) {
        CircularProgressIndicator()
        Log.d("Loading", "Questions: Loading .... ")}

    else
//     Log.d("SIZE", "Questions: ${questions?.size}")
        Log.d("Loading", "Questions: Loading Stopped ")

    questions?.forEach{item->
        Log.d("Result", "Questions: ${item.question}")
    }
}