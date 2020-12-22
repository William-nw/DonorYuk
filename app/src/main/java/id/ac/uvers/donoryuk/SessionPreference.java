package id.ac.uvers.donoryuk;

import android.content.Context;
import android.content.SharedPreferences;

import id.ac.uvers.donoryuk.models.User;

public class SessionPreference {
    private static final String PREFS_NAME = "user_pref";
    private static final String KEY_ID = "user_id";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_NAME= "name";
    private static final String KEY_PHONE= "phone_number";
    private static final String KEY_LOCATION= "location";
    private static final String KEY_PROFILE = "profile_picture";
    private static final String KEY_TOKEN = "api_token";
    private static final String IS_LOGIN = "login_status";
    private static final String KEY_BLOOD = "blood";
    private static final String KEY_RHESUS = "rhesus";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_STATUS = "status";

    private SharedPreferences preferences;
    public SessionPreference(Context context) {
        preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void setLogin(boolean isLogin) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(IS_LOGIN, isLogin);
        editor.apply();
    }

    public boolean getLogin() {
        return preferences.getBoolean(IS_LOGIN, false);
    }

    public void setUser(User value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(KEY_ID, value.getId());
        editor.putString(KEY_USERNAME, value.getUsername());
        editor.putString(KEY_PHONE, value.getPhone());
        editor.putString(KEY_NAME, value.getName());
        editor.putString(KEY_LOCATION, value.getLocation());
        editor.putString(KEY_BLOOD, value.getBlood());
        editor.putString(KEY_RHESUS, value.getRhesus());
        editor.putString(KEY_GENDER, value.getGender());
        editor.putString(KEY_STATUS, value.getStatus());
        editor.apply();
    }

    public User getUser() {
        User user = new User();
        user.setId(preferences.getInt(KEY_ID, 0));
        user.setUsername(preferences.getString(KEY_USERNAME, ""));
        user.setPhone(preferences.getString(KEY_PHONE, ""));
        user.setName(preferences.getString(KEY_NAME, ""));
        user.setLocation(preferences.getString(KEY_LOCATION, ""));
        user.setBlood(preferences.getString(KEY_BLOOD, ""));
        user.setRhesus(preferences.getString(KEY_RHESUS, ""));
        user.setGender(preferences.getString(KEY_GENDER, ""));
        user.setStatus(preferences.getString(KEY_STATUS, ""));
        return user;
    }

    public void logout() {
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
