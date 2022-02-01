package com.tencent.token;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;

public final class aam
{
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        return paramContext.getStreamVolume(1);
      }
      int i = aah.b;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.b;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getVoiceMailNumber();
      }
      paramContext = aah.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.a;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getVoiceMailAlphaTag();
      }
      paramContext = aah.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return aah.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aam
 * JD-Core Version:    0.7.0.1
 */