package com.tencent.mobileqq.voicechange;

import java.io.File;

public class VoiceTuneUtil
{
  public static final int a = 6;
  
  public static String a(String paramString)
  {
    String str = paramString.substring(0, paramString.lastIndexOf(".")).concat(".pcm");
    new File(paramString).renameTo(new File(str));
    return str;
  }
  
  public static String a(String paramString, int paramInt)
  {
    int i = paramString.lastIndexOf(".");
    return paramString.substring(0, i).concat("_" + paramInt).concat(paramString.substring(i, paramString.length()));
  }
  
  public static void a(String paramString1, String paramString2)
  {
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    while (i < 6)
    {
      new File(a(paramString1, i)).delete();
      i += 1;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = null;
    new File(paramString1).delete();
    new File(paramString2).delete();
    int i = 0;
    paramString2 = str;
    if (i < 6)
    {
      str = a(paramString1, i);
      if (i == paramInt) {
        paramString2 = str;
      }
      for (;;)
      {
        i += 1;
        break;
        new File(str).delete();
      }
    }
    new File(paramString2).renameTo(new File(paramString1));
  }
  
  public static void b(String paramString1, String paramString2)
  {
    new File(paramString1).deleteOnExit();
    new File(paramString2).deleteOnExit();
    int i = 0;
    while (i < 6)
    {
      new File(a(paramString1, i)).deleteOnExit();
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.voicechange.VoiceTuneUtil
 * JD-Core Version:    0.7.0.1
 */