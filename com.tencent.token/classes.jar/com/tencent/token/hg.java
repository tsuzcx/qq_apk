package com.tencent.token;

import java.util.List;
import java.util.regex.Pattern;
import okhttp3.ad;
import okhttp3.af;
import okhttp3.ap;
import okhttp3.at;
import okhttp3.s;
import okhttp3.t;

public final class hg
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
  
  public static long a(ad paramad)
  {
    return a(paramad.a("Content-Length"));
  }
  
  public static long a(at paramat)
  {
    return a(paramat.d());
  }
  
  public static void a(t paramt, af paramaf, ad paramad)
  {
    if (paramt == t.a) {}
    do
    {
      return;
      paramad = s.a(paramaf, paramad);
    } while (paramad.isEmpty());
    paramt.a(paramaf, paramad);
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
  
  public static boolean b(at paramat)
  {
    if (paramat.a().b().equals("HEAD")) {}
    do
    {
      return false;
      int i = paramat.b();
      if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
        return true;
      }
    } while ((a(paramat) == -1L) && (!"chunked".equalsIgnoreCase(paramat.a("Transfer-Encoding"))));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.hg
 * JD-Core Version:    0.7.0.1
 */