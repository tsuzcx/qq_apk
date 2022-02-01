package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public final class acs
{
  public static final String a;
  public static String b = "";
  public static String c = "";
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder("turingfd_shark_");
    localStringBuilder.append(agh.a);
    localStringBuilder.append("_qps");
    a = localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(c)) {
      return c;
    }
    String str = "";
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(b);
      localStringBuilder.append(a);
      paramContext = paramContext.getSharedPreferences(localStringBuilder.toString(), 0).getString("g", "");
      if (!TextUtils.isEmpty(paramContext)) {
        c = paramContext;
      }
      return paramContext;
    }
    finally
    {
      for (;;)
      {
        paramContext = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acs
 * JD-Core Version:    0.7.0.1
 */