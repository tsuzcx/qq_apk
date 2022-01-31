package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharePreferenceUtils
{
  private static final String a = "c_profile_sharepreference";
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext != null) {
      return paramContext.getSharedPreferences("c_profile_sharepreference", 0).getString(paramString, "");
    }
    return "";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    b(paramContext, paramString1, paramString2);
  }
  
  private static void b(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = paramContext.getSharedPreferences("c_profile_sharepreference", 0).edit();
    paramContext.putString(paramString1, paramString2);
    paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.util.SharePreferenceUtils
 * JD-Core Version:    0.7.0.1
 */