package com.tencent.token.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.token.global.RqdApplication;

public class i
{
  private static final String a;
  private static SharedPreferences b = RqdApplication.l().getSharedPreferences(a, 0);
  private static SharedPreferences.Editor c = b.edit();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SharedPreferencesHelper.for.");
    localStringBuilder.append(RqdApplication.l().getPackageName());
    a = localStringBuilder.toString();
  }
  
  public static int a(String paramString, int paramInt)
  {
    return b.getInt(paramString, paramInt);
  }
  
  public static long a(String paramString, long paramLong)
  {
    return b.getLong(paramString, paramLong);
  }
  
  public static SharedPreferences.Editor a(String paramString)
  {
    return c.remove(paramString);
  }
  
  public static void a(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    b.registerOnSharedPreferenceChangeListener(paramOnSharedPreferenceChangeListener);
  }
  
  public static SharedPreferences.Editor b(String paramString, int paramInt)
  {
    return c.putInt(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.i
 * JD-Core Version:    0.7.0.1
 */