package com.dataline.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

public class DataLineConfig
{
  public static final String a = "dataline_setting";
  
  public static int a(String paramString, int paramInt)
  {
    return a().getInt(paramString, paramInt);
  }
  
  private static Context a()
  {
    return BaseApplication.getContext();
  }
  
  public static SharedPreferences.Editor a()
  {
    return a().edit();
  }
  
  @SuppressLint({"InlinedApi"})
  public static SharedPreferences a()
  {
    int i = Build.VERSION.SDK_INT;
    Context localContext = a();
    if (i > 10) {}
    for (i = 4;; i = 0) {
      return localContext.getSharedPreferences("dataline_setting", i);
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return a().getString(paramString1, paramString2);
  }
  
  public static void a(String paramString)
  {
    SharedPreferences.Editor localEditor = a();
    localEditor.remove(paramString);
    localEditor.commit();
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = a();
    localEditor.putInt(paramString, paramInt);
    localEditor.commit();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = a();
    localEditor.putString(paramString1, paramString2);
    localEditor.commit();
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
  }
  
  public static boolean a(String paramString)
  {
    return a().contains(paramString);
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a().getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.dataline.util.DataLineConfig
 * JD-Core Version:    0.7.0.1
 */