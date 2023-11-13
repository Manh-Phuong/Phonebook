package vn.edu.hust.activityexamples

//data class UserModel(val idUser: String, val fullName: String, val numberPhone: String, val email: String)
import android.os.Parcel
import android.os.Parcelable

data class UserModel(
    val idUser: String,
    val fullName: String,
    val numberPhone: String,
    val email: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(idUser)
        parcel.writeString(fullName)
        parcel.writeString(numberPhone)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserModel> {
        override fun createFromParcel(parcel: Parcel): UserModel {
            return UserModel(parcel)
        }

        override fun newArray(size: Int): Array<UserModel?> {
            return arrayOfNulls(size)
        }
    }
}
