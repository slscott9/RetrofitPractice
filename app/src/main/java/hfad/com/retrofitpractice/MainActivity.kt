package hfad.com.retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.annotations.SerializedName

import timber.log.Timber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    addDummyUser()

    }
}



data class UserInfo(
    @SerializedName("user_id") val userId: Int?,
    @SerializedName("user_name") val userName: String?,
    @SerializedName("user_email") val userEmail: String?,
    @SerializedName("user_age") val userAge: Int,
    @SerializedName("user_uid") val userUid: String?
)






fun addDummyUser() {
    val apiService = RestApiService()
    val userInfo = UserInfo(  userId = null,
        userName = "Alex",
        userEmail = "alex@gmail.com",
        userAge = 32,
        userUid = "164E92FC-D37A-4946-81CB-29DE7EE4B124" )

    apiService.addUser(userInfo) {
        if (it?.userId != null) {
            // it = newly added user parsed as response
            // it?.id = newly added user ID
        } else {
            Timber.d("Error registering new user")
        }
    }
}