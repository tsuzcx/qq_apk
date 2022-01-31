package com.tencent.open.settings;

import android.content.Context;
import android.content.SharedPreferences;

public class OpensdkPreference
{
  protected static final String a = "sdk_preference";
  
  public static SharedPreferences a(Context paramContext, String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() != 0) {}
    }
    else
    {
      str = "sdk_preference";
    }
    return paramContext.getSharedPreferences(str, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.settings.OpensdkPreference
 * JD-Core Version:    0.7.0.1
 */