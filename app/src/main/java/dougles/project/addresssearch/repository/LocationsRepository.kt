package dougles.project.addresssearch.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dougles.project.addresssearch.api.RetrofitInterface
import dougles.project.addresssearch.model.ResponseDTO

class LocationsRepository(private val locationApi: RetrofitInterface) {
    private val locationsLiveData = MutableLiveData<ResponseDTO>()
    val location: LiveData<ResponseDTO>
        get() = locationsLiveData

    suspend fun getLocations(queryString: String, city: String) {
        val result = locationApi.getAllPlaces(queryString, city)
        if (result.body()!=null){
            locationsLiveData.postValue(result.body())
        }

    }

}