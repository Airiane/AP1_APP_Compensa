package com.example.trabalho_ap1

import android.os.Parcel
import android.os.Parcelable

data class valor1(var value1: String?, var size: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(value1)
        parcel.writeString(size)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<valor1> {
        override fun createFromParcel(parcel: Parcel): valor1 {
            return valor1(parcel)
        }

        override fun newArray(size: Int): Array<valor1?> {
            return arrayOfNulls(size)
        }
    }
}