package com.rahul.cubeassignment.network

import com.rahul.cubeassignment.model.Result

sealed class NetworkHelper {

    data class OnSuccess(val responseList: List<Result>) : NetworkHelper()

    data class OnFailure(val error: String) : NetworkHelper()
}