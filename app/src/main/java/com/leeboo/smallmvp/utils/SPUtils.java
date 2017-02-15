package com.leeboo.smallmvp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.leeboo.smallmvp.base.BaseApplication;

/**
 * SharedPreference utils
 */
public class SPUtils {

    private static final String SP_NAME = "lena_sp";

    public static void putString(String key, String value) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, 0);
        Editor edit = sp.edit();
        edit.putString(key, value);
        edit.commit();
    }

    public static void putInt(String key, int value) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void putBoolean(String key, boolean value) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static void putFloat(String key, float value) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putFloat(key, value);
        edit.commit();
    }

    public static void putLong(String key, long value) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.putLong(key, value);
        edit.commit();
    }

    public static String getString(String key) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, "");
    }

    public static Long getLong(String key) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, -1);
    }

    public static Integer getInt(String key) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, -1);
    }

    public static Float getFloat(String key) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getFloat(key, -1);
    }

    public static Boolean getBoolean(String key, boolean def) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, def);
    }

    public static void remove(String key) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        Editor edit = sp.edit();
        edit.remove(key);
        edit.commit();
    }

    public static Boolean contains(String key) {
        SharedPreferences sp = BaseApplication.getMyApplication().getSharedPreferences(SP_NAME, 0);
        return sp.contains(key);
    }

}
