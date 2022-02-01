package com.tencent.token;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class ady
{
  public static Map<String, a> a;
  public static aea b;
  public static String c;
  
  static
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    a = localConcurrentHashMap;
    localConcurrentHashMap.put("C892BA2", new a(new aee()));
    a.put("43780D5", new a(new aee()));
    a.put("22792AF", new a(new aed()));
    c = "";
    try
    {
      c = aey.c(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static final class a
  {
    public adw a;
    public int b = 0;
    
    public a(adw paramadw)
    {
      this.a = paramadw;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ady
 * JD-Core Version:    0.7.0.1
 */