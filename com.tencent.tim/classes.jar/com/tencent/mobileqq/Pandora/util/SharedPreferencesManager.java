package com.tencent.mobileqq.Pandora.util;

import alld;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;

public class SharedPreferencesManager
{
  public static final String KEY_ACTIVITYLIST = "activitylist";
  public static final String KEY_ACTIVITY_LAST_UPDATE_TIME = "activityList_last_update_time";
  public static final String KEY_ANDROIDID = "android_id";
  public static final String KEY_APPLICATION = "applicationlist";
  public static final String KEY_APPLICATIONLIST_LAST_UPDATE_TIME = "applicationList_last_update_time";
  public static final String KEY_DEVICEID = "deviceId";
  public static final String KEY_FIRSTIN = "first";
  public static final String KEY_HARDWAREADDRESS = "hardware_mac_address";
  public static final String KEY_IMEI = "imei";
  public static final String KEY_IMSI = "imsi";
  public static final String KEY_MACADDRESS = "mac_address";
  public static final String KEY_MEID = "meid";
  public static final String KEY_MODEL = "model";
  public static final String KEY_ONBACKGROUND = "onApplicationBackground";
  public static final String KEY_REALMACADDRESS = "real_mac_address";
  public static final String SP_PANDORAMANAGER = "PandoraManager";
  private static final String TAG = "SharedPreferencesManager";
  public static final String TAG_NOT_CONTAINS = "data is null";
  public static final String VALUE_ONBACKGROUND_FALSE = "onbackground_false";
  public static final String VALUE_ONBACKGROUND_TRUE = "onbackground_true";
  public static volatile SharedPreferences sharedPreferences;
  
  public static Boolean contain(Context paramContext, String paramString)
  {
    if (!getData(paramContext, paramString).equals("data is null")) {}
    for (boolean bool = true;; bool = false) {
      return Boolean.valueOf(bool);
    }
  }
  
  public static String getData(Context paramContext, String paramString)
  {
    try
    {
      Uri localUri = Uri.parse(getFileProviderName(paramContext));
      paramString = alld.query(paramContext.getContentResolver(), localUri, new String[] { "KEY", "VALUE" }, null, new String[] { paramString, "" }, null);
      if (paramString == null) {
        return "data is null";
      }
    }
    catch (Exception paramContext)
    {
      Log.e("SharedPreferencesManager", "ContentProvider get data error: ", paramContext);
      return "";
    }
    if (paramString.getCount() == 0)
    {
      paramString.close();
      return "data is null";
    }
    paramContext = "data is null";
    try
    {
      if (paramString.moveToFirst()) {
        paramContext = paramString.getString(1);
      }
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("SharedPreferencesManager", "cursor query data exception is ", paramContext);
      return "data is null";
    }
    finally
    {
      paramString.close();
    }
    return "data is null";
  }
  
  public static String getDataFromSp(Context paramContext, String paramString)
  {
    if (!getInstance(paramContext).contains(paramString)) {
      return null;
    }
    return getInstance(paramContext).getString(paramString, "");
  }
  
  private static String getFileProviderName(Context paramContext)
  {
    return "content://com.tencent.mobileqq.Pandora." + paramContext.getPackageName() + "/" + "SharedPreferences";
  }
  
  private static SharedPreferences getInstance(Context paramContext)
  {
    if (sharedPreferences == null) {}
    try
    {
      if (sharedPreferences == null) {
        sharedPreferences = paramContext.getSharedPreferences("PandoraManager", 4);
      }
      return sharedPreferences;
    }
    finally {}
  }
  
  public static Boolean isSaveInSp(Context paramContext, String paramString)
  {
    return Boolean.valueOf(getInstance(paramContext).contains(paramString));
  }
  
  public static void save(Context paramContext, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put(paramString1, paramString2);
    try
    {
      paramString1 = Uri.parse(getFileProviderName(paramContext));
      paramContext.getContentResolver().insert(paramString1, localContentValues);
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("SharedPreferencesManager", "ContentProvider save data error: ", paramContext);
    }
  }
  
  public static void saveDataToSp(Context paramContext, String paramString1, String paramString2)
  {
    getInstance(paramContext).edit().putString(paramString1, paramString2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.Pandora.util.SharedPreferencesManager
 * JD-Core Version:    0.7.0.1
 */