package com.tencent.token;

import java.util.List;
import java.util.regex.Pattern;

public final class ami
{
  private static final Pattern a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
  
  public static int a(String paramString, int paramInt)
  {
    while (paramInt < paramString.length())
    {
      int i = paramString.charAt(paramInt);
      if ((i != 32) && (i != 9)) {
        break;
      }
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static int a(String paramString1, int paramInt, String paramString2)
  {
    while ((paramInt < paramString1.length()) && (paramString2.indexOf(paramString1.charAt(paramInt)) == -1)) {
      paramInt += 1;
    }
    return paramInt;
  }
  
  public static long a(all paramall)
  {
    return a(paramall.f.a("Content-Length"));
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
  
  public static void a(akx paramakx, ald paramald, alc paramalc)
  {
    if (paramakx == akx.a) {
      return;
    }
    if (akw.a(paramald, paramalc).isEmpty()) {}
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
  
  public static boolean b(all paramall)
  {
    if (paramall.a.b.equals("HEAD")) {
      return false;
    }
    int i = paramall.c;
    if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
      return true;
    }
    if (a(paramall) == -1L) {
      return "chunked".equalsIgnoreCase(paramall.a("Transfer-Encoding"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ami
 * JD-Core Version:    0.7.0.1
 */