package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import com.tencent.token.global.RqdApplication;

public final class aav
{
  private static final String a;
  private static SharedPreferences b;
  private static SharedPreferences.Editor c;
  
  static
  {
    Object localObject = new StringBuilder("SharedPreferencesHelper.for.");
    ((StringBuilder)localObject).append(RqdApplication.n().getPackageName());
    a = ((StringBuilder)localObject).toString();
    localObject = RqdApplication.n().getSharedPreferences(a, 0);
    b = (SharedPreferences)localObject;
    c = ((SharedPreferences)localObject).edit();
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
 * Qualified Name:     com.tencent.token.aav
 * JD-Core Version:    0.7.0.1
 */