package cn.spacexc.wearbili.remake.ui.main.dynamic.domain.remote.list


import com.google.gson.annotations.SerializedName

data class Like(
    @SerializedName("count")
    val count: Int,
    @SerializedName("forbidden")
    val forbidden: Boolean,
    @SerializedName("status")
    val status: Boolean
)