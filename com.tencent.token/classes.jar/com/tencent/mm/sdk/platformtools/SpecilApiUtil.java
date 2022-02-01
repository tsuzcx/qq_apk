package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;

public class SpecilApiUtil
{
  public static final String LINE_SEP = "\n";
  public static final String LINE_SEP_W = "\r\n";
  public static final String LINE_TRIM = "                                                                                                                                                                                                                                                                                                                        ";
  public static final String TAG = "MicroMsg.SpecilApiUtil";
  
  public static CharSequence fixInAPI16(CharSequence paramCharSequence)
  {
    if (paramCharSequence == null) {
      return paramCharSequence;
    }
    Object localObject = paramCharSequence;
    if (Build.VERSION.SDK_INT == 16)
    {
      localObject = paramCharSequence;
      if (paramCharSequence.toString().contains("\n"))
      {
        if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) > 0) {
          return paramCharSequence;
        }
        localObject = paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
      }
    }
    return localObject;
  }
  
  public static String killsplitAPI16(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    String str = paramString;
    if (Build.VERSION.SDK_INT == 16)
    {
      str = paramString;
      if (paramString.toString().contains("\n"))
      {
        if (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) > 0) {
          return paramString;
        }
        str = paramString.toString().replace("\n", " ");
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SpecilApiUtil
 * JD-Core Version:    0.7.0.1
 */