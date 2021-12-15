package dougles.project.addresssearch.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseDTO(

	@field:SerializedName("requestId")
	val requestId: String? = null,

	@field:SerializedName("data")
	val data: DataDTO? = null
)