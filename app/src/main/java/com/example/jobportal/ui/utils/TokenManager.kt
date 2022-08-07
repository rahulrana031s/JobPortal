package com.example.jobportal.ui.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.jobportal.ui.utils.Constants.AVATAR
import com.example.jobportal.ui.utils.Constants.EMAIl
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class TokenManager @Inject constructor(@ApplicationContext context: Context) {
    private var mail: SharedPreferences =
        context.getSharedPreferences(EMAIl, Context.MODE_PRIVATE)
    private var profile: SharedPreferences =
        context.getSharedPreferences(AVATAR, Context.MODE_PRIVATE)

    fun saveEmail(token: String) {
        val editor = mail.edit()
        editor.putString(EMAIl, token)
        editor.apply()
    }

    fun getEmail(): String? {
        return mail.getString(EMAIl, null)
    }
    fun saveProfile(token: String) {
        val editor = profile.edit()
        editor.putString(AVATAR, token)
        editor.apply()
    }

    fun getProfile(): String? {
        return profile.getString(AVATAR, null)
    }
}