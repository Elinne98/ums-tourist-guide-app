package app.umstouristguide.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import app.umstouristguide.R;

public class SharedPref {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences prefs;
    public static final int MAX_OPEN_COUNTER = 0;

    private static final String FCM_PREF_KEY = "app.umstouristguide.data.FCM_PREF_KEY";
    private static final String SERVER_FLAG_KEY = "app.umstouristguide.data.SERVER_FLAG_KEY";
    private static final String THEME_COLOR_KEY = "app.umstouristguide.data.THEME_COLOR_KEY";
    private static final String LAST_PLACE_PAGE = "LAST_PLACE_PAGE_KEY";

    // need refresh
    public static final String REFRESH_PLACES = "app.umstouristguide.data.REFRESH_PLACES";

    public SharedPref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("MAIN_PREF", Context.MODE_PRIVATE);
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void setFcmRegId(String gcmRegId) {
        sharedPreferences.edit().putString(FCM_PREF_KEY, gcmRegId).apply();
    }

    public String getFcmRegId() {
        return sharedPreferences.getString(FCM_PREF_KEY, null);
    }

    public boolean isFcmRegIdEmpty() {
        return TextUtils.isEmpty(getFcmRegId());
    }

    public void setRegisteredOnServer(boolean registered) {
        sharedPreferences.edit().putBoolean(SERVER_FLAG_KEY, registered).apply();
    }

    public boolean isRegisteredOnServer() {
        return sharedPreferences.getBoolean(SERVER_FLAG_KEY, false);
    }

    public boolean isNeedRegisterFcm() {
        return (isFcmRegIdEmpty() || !isRegisteredOnServer());
    }

    /**
     * For notifications flag
     */
    public boolean getNotification() {
        return prefs.getBoolean(context.getString(R.string.pref_key_notif), true);
    }

    public String getRingtone() {
        return prefs.getString(context.getString(R.string.pref_key_ringtone), "content://settings/system/notification_sound");
    }

    public boolean getVibration() {
        return prefs.getBoolean(context.getString(R.string.pref_key_vibrate), true);
    }

    public boolean isRefreshPlaces() {
        return sharedPreferences.getBoolean(REFRESH_PLACES, false);
    }

    public void setRefreshPlaces(boolean need_refresh) {
        sharedPreferences.edit().putBoolean(REFRESH_PLACES, need_refresh).apply();
    }

    public void setThemeColor(String color) {
        sharedPreferences.edit().putString(THEME_COLOR_KEY, color).apply();
    }

    public String getThemeColor() {
        return sharedPreferences.getString(THEME_COLOR_KEY, "");
    }

    public int getThemeColorInt() {
        if (getThemeColor().equals("")) {
            return context.getResources().getColor(R.color.colorPrimary);
        }
        return Color.parseColor(getThemeColor());
    }

    public void setLastPlacePage(int page) {
        sharedPreferences.edit().putInt(LAST_PLACE_PAGE, page).apply();
    }

    public int getLastPlacePage() {
        return sharedPreferences.getInt(LAST_PLACE_PAGE, 1);
    }

    public void setNeverAskAgain(String key, boolean value) {
        sharedPreferences.edit().putBoolean(key, value).apply();
    }

    public boolean getNeverAskAgain(String key) {
        return sharedPreferences.getBoolean(key, false);
    }

}
