package dougles.project.addresssearch.adaptersandviewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dougles.project.addresssearch.R
import dougles.project.addresssearch.model.AddressListDTO

class LocationsAdapter(
    private val context: Context,
    private val locationsList: MutableList<AddressListDTO>
) :
    RecyclerView.Adapter<LocationsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return LocationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        val address = locationsList[position]
        holder.setData(address)
    }

    override fun getItemCount(): Int {
        return locationsList.size
    }


}