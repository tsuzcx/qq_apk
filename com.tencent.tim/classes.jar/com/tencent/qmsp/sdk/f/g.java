package com.tencent.qmsp.sdk.f;

import android.util.Log;

public class g
{
  public static String a = "Qp.Log";
  private static boolean b;
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    if (b) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    if (b) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    if (b) {
      Log.v(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    if (b) {
      Log.w(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.g
 * JD-Core Version:    0.7.0.1
 */