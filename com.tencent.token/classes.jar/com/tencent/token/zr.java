package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;

public final class zr
{
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        return paramContext.getStreamVolume(1);
      }
      int i = zl.b;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zl.b;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getVoiceMailNumber();
      }
      paramContext = zl.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zl.a;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getVoiceMailAlphaTag();
      }
      paramContext = zl.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zl.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zr
 * JD-Core Version:    0.7.0.1
 */