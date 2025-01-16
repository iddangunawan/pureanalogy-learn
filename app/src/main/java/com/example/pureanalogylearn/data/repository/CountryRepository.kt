package com.example.pureanalogylearn.data.repository

import com.example.pureanalogylearn.data.model.Country
import com.example.pureanalogylearn.utils.AppConstant
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryRepository @Inject constructor() {

    fun getCountry(): Flow<List<Country>> {
        return flow {
            emit(AppConstant.COUNTRIES)
        }
    }

}