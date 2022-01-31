package com.tencent.token;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.halley.common.h;

public final class bn
{
  public String a;
  public String b;
  
  public static void a(String paramString1, String paramString2)
  {
    h.a().getSharedPreferences("Access_Preferences", 0).edit().putString(paramString1, paramString2).commit();
  }
  
  public final String toString()
  {
    return "detectTaskCode:" + this.a + "ipInfo:" + this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bn
 * JD-Core Version:    0.7.0.1
 */