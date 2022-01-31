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
    if (paramCharSequence == null) {}
    while ((Build.VERSION.SDK_INT != 16) || (!paramCharSequence.toString().contains("\n")) || (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) > 0)) {
      return paramCharSequence;
    }
    return paramCharSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
  }
  
  public static String killsplitAPI16(String paramString)
  {
    if (paramString == null) {}
    while ((Build.VERSION.SDK_INT != 16) || (!paramString.toString().contains("\n")) || (Util.nullAs(Build.MANUFACTURER, "").toLowerCase().indexOf("meizu".toLowerCase()) > 0)) {
      return paramString;
    }
    return paramString.toString().replace("\n", " ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SpecilApiUtil
 * JD-Core Version:    0.7.0.1
 */