package com.tencent.token.upload;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;

public class r
{
  public static int a(Context paramContext)
  {
    try
    {
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext != null) {
        return paramContext.getStreamVolume(1);
      }
      int i = g.b;
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.b;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getVoiceMailNumber();
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
  }
  
  public static String c(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getVoiceMailAlphaTag();
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.r
 * JD-Core Version:    0.7.0.1
 */