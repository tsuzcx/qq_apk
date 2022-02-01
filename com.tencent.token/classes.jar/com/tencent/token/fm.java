package com.tencent.token;

import java.util.List;
import java.util.regex.Pattern;
import okhttp3.l;
import okhttp3.m;
import okhttp3.r;
import okhttp3.s;
import okhttp3.x;
import okhttp3.z;

public final class fm
{
  private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
  
  public static int a(String paramString, int paramInt)
  {
    for (;;)
    {
      if (paramInt < paramString.length())
      {
        int i = paramString.charAt(paramInt);
        if ((i == 32) || (i == 9)) {}
      }
      else
      {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      if ((paramInt >= paramString1.length()) || (paramString2.indexOf(paramString1.charAt(paramInt)) != -1)) {
        return paramInt;
      }
      paramInt += 1;
    }
  }
  
  private static long a(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static long a(r paramr)
  {
    return a(paramr.a("Content-Length"));
  }
  
  public static long a(z paramz)
  {
    return a(paramz.d());
  }
  
  public static void a(m paramm, s params, r paramr)
  {
    if (paramm == m.a) {}
    do
    {
      return;
      paramr = l.a(params, paramr);
    } while (paramr.isEmpty());
    paramm.a(params, paramr);
  }
  
  public static int b(String paramString, int paramInt)
  {
    try
    {
      long l = Long.parseLong(paramString);
      if (l > 2147483647L) {
        return 2147483647;
      }
      if (l < 0L) {
        return 0;
      }
      return (int)l;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static boolean b(z paramz)
  {
    if (paramz.a().b().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramz.b();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((a(paramz) == -1L) && (!"chunked".equalsIgnoreCase(paramz.a("Transfer-Encoding"))));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fm
 * JD-Core Version:    0.7.0.1
 */