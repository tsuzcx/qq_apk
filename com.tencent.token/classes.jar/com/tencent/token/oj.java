package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class oj
{
  public String a;
  public String b;
  
  public static void a(String paramString1, String paramString2)
  {
    mj.a().getSharedPreferences("Access_Preferences", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("detectTaskCode:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("ipInfo:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.oj
 * JD-Core Version:    0.7.0.1
 */