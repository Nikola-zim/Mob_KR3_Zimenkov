package com.example.kr3_zimenkov

import android.os.Parcel
import android.os.Parcelable

class Visitor(var name: String?, var last_name: String?, val height: String?, val weight: String?, val year: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(last_name)
        parcel.writeString(height)
        parcel.writeString(weight)
        parcel.writeString(year)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Visitor> {
        override fun createFromParcel(parcel: Parcel): Visitor {
            return Visitor(parcel)
        }

        override fun newArray(size: Int): Array<Visitor?> {
            return arrayOfNulls(size)
        }
    }

}





//, var last_name: String, var weigh: Int, var bith: String