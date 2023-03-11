package com.example.jettrivia.repository

import android.util.Log
import com.example.jettrivia.data.DataOrException
import com.example.jettrivia.model.QuestionItem
import com.example.jettrivia.network.QuestionApi
import javax.inject.Inject
import java.lang.Exception

class QuestionRepository @Inject constructor(private val api :QuestionApi){


                  //    private val dataOrException = ArrayList<QuestionItem>(emptyList())

    // although this  above will work , as we are getting arrayList of question items , but we need
    // to make sure to handle cases of other info we may need as for ex any meta data like exception
    //or loading status

    // what we need to do is we have to wrap this around a different object

    // new way ->
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean , Exception>()

    suspend fun getAllQuestion():DataOrException<ArrayList<QuestionItem>,Boolean, Exception>{
        try {
            dataOrException.loading=true
            dataOrException.data = api.getAllQuestion()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        }catch (exception:Exception){
            dataOrException.e = exception
            Log.d("Exc", "getAllQuestion: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}