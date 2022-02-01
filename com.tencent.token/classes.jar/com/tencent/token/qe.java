package com.tencent.token;

import java.util.TimeZone;

public final class qe
{
  private static final long[] a = { 300L, 200L, 300L, 200L };
  private static final TimeZone b = TimeZone.getTimeZone("GMT");
  private static final char[] c = { 9, 10, 13 };
  private static final char[] d = { 60, 62, 34, 39, 38 };
  private static final String[] e = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;" };
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static boolean b(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qe
 * JD-Core Version:    0.7.0.1
 */