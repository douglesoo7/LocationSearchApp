package dougles.project.addresssearch.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class DataDTO(

	@field:SerializedName("autoCompleteRequestString")
	val autoCompleteRequestString: String? = null,

	@field:SerializedName("focusWord")
	val focusWord: String? = null,

	@field:SerializedName("addressList")
	val addressList: List<AddressListDTO?>? = null,

	@field:SerializedName("totalFindByRSUHits")
	val totalFindByRSUHits: Int? = null,

	@field:SerializedName("totalNoRSUReturned")
	val totalNoRSUReturned: Int? = null
)