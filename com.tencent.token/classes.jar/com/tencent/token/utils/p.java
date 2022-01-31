package com.tencent.token.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.token.global.RqdApplication;

public final class p
{
  private static final String a = "SharedPreferencesHelper.for." + RqdApplication.i().getPackageName();
  private static SharedPreferences b;
  private static SharedPreferences.Editor c;
  
  static
  {
    SharedPreferences localSharedPreferences = RqdApplication.i().getSharedPreferences(a, 0);
    b = localSharedPreferences;
    c = localSharedPreferences.edit();
  }
  
  public static int a(String paramString, int paramInt)
  {
    return b.getInt(paramString, paramInt);
  }
  
  public static long a(String paramString)
  {
    return b.getLong(paramString, 604800000L);
  }
  
  public static void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    b.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public static SharedPreferences.Editor b(String paramString)
  {
    return c.remove(paramString);
  }
  
  public static SharedPreferences.Editor b(String paramString, int paramInt)
  {
    return c.putInt(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.p
 * JD-Core Version:    0.7.0.1
 */