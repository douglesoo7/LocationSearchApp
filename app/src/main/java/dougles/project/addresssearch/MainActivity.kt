package dougles.project.addresssearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.arlib.floatingsearchview.FloatingSearchView
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import dougles.project.addresssearch.adaptersandviewholders.LocationsAdapter
import dougles.project.addresssearch.api.RetrofitBuilder
import dougles.project.addresssearch.api.RetrofitInterface
import dougles.project.addresssearch.model.AddressListDTO
import dougles.project.addresssearch.model.ResponseDTO
import dougles.project.addresssearch.model.Suggestions
import dougles.project.addresssearch.repository.LocationsRepository
import dougles.project.addresssearch.viewmodel.LocationsViewModel
import dougles.project.addresssearch.viewmodel.LocationsViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: LocationsViewModel
    lateinit var repository: LocationsRepository
    val addressList = ArrayList<AddressListDTO>()
    lateinit var locationsAdapters: LocationsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationApi =
            RetrofitBuilder.getRetrofitInstance().create(RetrofitInterface::class.java)

        repository = LocationsRepository(locationApi)
        val locationFactory = LocationsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, locationFactory).get(LocationsViewModel::class.java)

        floating_search_view.setOnQueryChangeListener(FloatingSearchView.OnQueryChangeListener { oldQuery, newQuery ->
            viewModel.getLocations(oldQuery, "")
            viewModel.location.observe(this, Observer {
                Log.d("DataIsComing", viewModel.location.toString())

                floating_search_view.swapSuggestions(getSuggestions(it))
                addressList.clear()
                addressList.addAll(it.data?.addressList as List<AddressListDTO>)

                Log.d("DataIsComing", addressList.toString())
            })

        })

    }

    private fun getSuggestions(it: ResponseDTO?): MutableList<out SearchSuggestion>? {
        val suggestionsList = ArrayList<Suggestions>()
        val list = it?.data?.addressList

        list?.forEach {
            val suggestion = Suggestions(it?.addressString)
            suggestionsList.add(suggestion)
        }

        return suggestionsList
    }

    private fun setRecyclerView() {
        locationsAdapters = LocationsAdapter(this, addressList)
        recyclerView.adapter=locationsAdapters
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}