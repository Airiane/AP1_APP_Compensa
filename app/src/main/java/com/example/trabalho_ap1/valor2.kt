package com.example.trabalho_ap1

import android.os.Parcel
import android.os.Parcelable

data class valor2(var finalValue: String?, var highValue: String?, var cheapBeer: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(finalValue)
        parcel.writeString(highValue)
        parcel.writeString(cheapBeer)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<valor2> {
        override fun createFromParcel(parcel: Parcel): valor2 {
            return valor2(parcel)
        }

        override fun newArray(size: Int): Array<valor2?> {
            return arrayOfNulls(size)
        }
    }
}