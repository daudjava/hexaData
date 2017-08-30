package com.hexadata.prototype.hexadata.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Daud on 7/15/2016.
 */
public class Utilities {

    public static void saveBoolean(Context activity, String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        if (editor.commit()) {
            Log.d("SP", "commited " + value);
        } else {
            Log.d("SP", "not commited");
        }
    }

    public static boolean haveLooged(Context ctx) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(ctx);
        boolean value = sharedPreferences.getBoolean(
                "login", false);
        return value;
    }

}
