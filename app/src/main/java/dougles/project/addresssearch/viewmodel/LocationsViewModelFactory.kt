package dougles.project.addresssearch.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dougles.project.addresssearch.repository.LocationsRepository

class LocationsViewModelFactory(private val locationsRepository: LocationsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LocationsViewModel(locationsRepository) as T
    }


}