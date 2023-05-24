package com.example.data.repositoriesContracts.Sprays

import com.example.data.database.ValorantDatabase
import com.example.data.model.toSprayItemDTO
import com.example.data.repositoriesContracts.WebServices
import com.example.domain.entities.Resource
import com.example.domain.entities.SprayItemDTO
import com.example.domain.repository.SpraysOnlineDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class SpraysOnlineDataSourceImpl @Inject constructor(val webServices: WebServices,
val valorantDatabase: ValorantDatabase) : SpraysOnlineDataSource {
    override suspend fun getSprays(): Flow<Resource<List<SprayItemDTO>>> {



        val response = webServices.getSprays()

        response.data?.let { valorantDatabase.getSpraysDao().saveSprays(it) }

        return flow<Resource<List<SprayItemDTO>>> {

            val successfulResponse = Resource.Success(response.data?.map {
                it.toSprayItemDTO()
            }!!)
            emit(successfulResponse)
        }.onStart {
            emit(Resource.Loading())
        }.catch {
            emit(Resource.Error(it.message ?: "error"))
        }
    }
}