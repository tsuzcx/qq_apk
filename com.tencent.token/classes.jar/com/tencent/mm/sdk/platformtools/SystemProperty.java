package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class SystemProperty
{
  private static final HashMap bl = new HashMap();
  
  public static String getProperty(String paramString)
  {
    return (String)bl.get(paramString);
  }
  
  public static void setProperty(String paramString1, String paramString2)
  {
    bl.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SystemProperty
 * JD-Core Version:    0.7.0.1
 */