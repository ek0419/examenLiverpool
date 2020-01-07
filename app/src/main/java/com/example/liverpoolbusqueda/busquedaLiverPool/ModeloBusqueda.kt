package com.example.liverpoolbusqueda.busquedaLiverPool
import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class ModeloBusqueda(

    @SerializedName("status")
    var status: Status? = null,
    @SerializedName("pageType")
    var pageType: String? = null,
    @SerializedName("plpResults")
    var plpResults: PlpResults? = null
)


data class PlpResults(

    @SerializedName("label")
    var label: String? = null,
    @SerializedName("plpState")
    var plpState: PlpState? = null,
    @SerializedName("sortOptions")
    var sortOptions: List<SortOption>? = null,
    @SerializedName("refinementGroups")
    var refinementGroups: List<RefinementGroup>? = null,
    @SerializedName("records")
    var records: List<Record>? = null

)

data class PlpState(

    @SerializedName("categoryId")
    var categoryId: String? = null,
    @SerializedName("currentSortOption")
    var currentSortOption: String? = null,
    @SerializedName("currentFilters")
    var currentFilters: String? = null,
    @SerializedName("firstRecNum")
    var firstRecNum: Int? = null,
    @SerializedName("lastRecNum")
    var lastRecNum: Int? = null,
    @SerializedName("recsPerPage")
    var recsPerPage: Int? = null,
    @SerializedName("totalNumRecs")
    var totalNumRecs: Int? = null
)


data class Record(

    @SerializedName("productId")
    var productId: String? = null,
    @SerializedName("skuRepositoryId")
    var skuRepositoryId: String? = null,
    @SerializedName("productDisplayName")
    var productDisplayName: String? = null,
    @SerializedName("productType")
    var productType: String? = null,
    @SerializedName("productRatingCount")
    var productRatingCount: Int? = null,
    @SerializedName("productAvgRating")
    var productAvgRating: Double? = null,
    @SerializedName("listPrice")
    var listPrice: Double? = null,
    @SerializedName("minimumListPrice")
    var minimumListPrice: Double? = null,
    @SerializedName("maximumListPrice")
    var maximumListPrice: Double? = null,
    @SerializedName("promoPrice")
    var promoPrice: Double? = null,
    @SerializedName("minimumPromoPrice")
    var minimumPromoPrice: Double? = null,
    @SerializedName("maximumPromoPrice")
    var maximumPromoPrice: Double? = null,
    @SerializedName("isHybrid")
    var isHybrid: Boolean? = null,
    @SerializedName("marketplaceSLMessage")
    var marketplaceSLMessage: String? = null,
    @SerializedName("marketplaceBTMessage")
    var marketplaceBTMessage: String? = null,
    @SerializedName("isMarketPlace")
    var isMarketPlace: Boolean? = null,
    @SerializedName("smImage")
    var smImage: String? = null,
    @SerializedName("lgImage")
    var lgImage: String? = null,
    @SerializedName("xlImage")
    var xlImage: String? = null,
    @SerializedName("groupType")
    var groupType: String? = null,
    @SerializedName("plpFlags")
    var plpFlags: List<Any>? = null,
    @SerializedName("variantsColor")
    var variantsColor: List<VariantsColor>? = null

)

data class Refinement(

    @SerializedName("count")

    var count: Int? = null,
    @SerializedName("label")

    var label: String? = null,
    @SerializedName("refinementId")

    var refinementId: String? = null,
    @SerializedName("selected")

    var selected: Boolean? = null,
    @SerializedName("colorHex")

    var colorHex: String? = null
)



data class RefinementGroup(

    @SerializedName("name")

    var name: String? = null,
    @SerializedName("refinement")

    var refinement: List<Refinement>? = null,
    @SerializedName("multiSelect")

    var multiSelect: Boolean? = null,
    @SerializedName("dimensionName")

    var dimensionName: String? = null
)


data class SortOption(

    @SerializedName("sortBy")

    var sortBy: String? = null,
    @SerializedName("label")

    var label: String? = null

)

data class Status(

    @SerializedName("status")

    var status: String? = null,
    @SerializedName("statusCode")

    var statusCode: Int? = null

)

data class VariantsColor(

    @SerializedName("colorName")

    var colorName: String? = null,
    @SerializedName("colorHex")

    var colorHex: String? = null,
    @SerializedName("colorImageURL")

    var colorImageURL: String? = null

)

data class ProductosBusquedaEncontrados(var titulo :String,var precio :String, var Imagen :String )



