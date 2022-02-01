package com.tencent.mm.sdk.b;

import java.util.TimeZone;

public final class f
{
  private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
  public static final long[] t = { 300L, 200L, 300L, 200L };
  private static final long[] u = { 300L, 50L, 300L, 50L };
  private static final char[] v = { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
  private static final String[] w = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */