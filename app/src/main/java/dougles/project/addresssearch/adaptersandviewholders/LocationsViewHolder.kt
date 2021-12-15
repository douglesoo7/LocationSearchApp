package dougles.project.addresssearch.adaptersandviewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import dougles.project.addresssearch.model.AddressListDTO
import kotlinx.android.synthetic.main.item_layout.view.*

class LocationsViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(address: AddressListDTO) {
        itemView.apply {
            tvAddress.text = address.addressString
        }
    }
}