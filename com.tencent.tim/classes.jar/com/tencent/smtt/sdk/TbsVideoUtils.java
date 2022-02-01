package com.tencent.smtt.sdk;

import android.content.Context;

public class TbsVideoUtils
{
  private static u a = null;
  
  private static void a(Context paramContext)
  {
    Object localObject = null;
    try
    {
      if (a == null)
      {
        g.a(true).a(paramContext, false, false, null);
        w localw = g.a(true).a();
        paramContext = localObject;
        if (localw != null) {
          paramContext = localw.b();
        }
        if (paramContext != null) {
          a = new u(paramContext);
        }
      }
      return;
    }
    finally {}
  }
  
  public static void deleteVideoCache(Context paramContext, String paramString)
  {
    a(paramContext);
    if (a != null) {
      a.a(paramContext, paramString);
    }
  }
  
  public static String getCurWDPDecodeType(Context paramContext)
  {
    a(paramContext);
    if (a != null) {
      return a.a(paramContext);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsVideoUtils
 * JD-Core Version:    0.7.0.1
 */