package com.example.retrofitbykotlinusigjsonplaceholder.dataModel


import com.google.gson.annotations.SerializedName

data class UsersDataModel(@SerializedName("id") val userId: Int, @SerializedName("name") val userFullName: String, @SerializedName(
    "username"
) val userShortName: String, @SerializedName("email") val userEmail: String, @SerializedName("address") var address: Address
) {
    data class Address(
        @SerializedName("street") val street: String,
        @SerializedName("suite") val suite: String,
        @SerializedName("city") val city: String,
        @SerializedName("zipcode") val zipcode: String,
        @SerializedName("geo") val geo: Geo
    ) {
        data class Geo(
            @SerializedName("lat") val lat: Double,
            @SerializedName("lng") val lng: Double
        )
    }
}
