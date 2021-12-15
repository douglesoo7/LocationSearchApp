package dougles.project.addresssearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dougles.project.addresssearch.model.ResponseDTO
import dougles.project.addresssearch.repository.LocationsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationsViewModel(private val locationsRepository: LocationsRepository) : ViewModel() {

    fun getLocations(stringQuery: String, city: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = locationsRepository.getLocations(stringQuery, city)
        }
    }

    val location:LiveData<ResponseDTO>
    get() = locationsRepository.location
}