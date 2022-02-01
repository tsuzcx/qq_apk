package com.tencent.token;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class adz
{
  public static Map<String, a> a;
  public static aeb b;
  public static String c;
  
  static
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    a = localConcurrentHashMap;
    localConcurrentHashMap.put("C892BA2", new a(new aef()));
    a.put("43780D5", new a(new aef()));
    a.put("22792AF", new a(new aee()));
    c = "";
    try
    {
      c = aez.c(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static final class a
  {
    public adx a;
    public int b = 0;
    
    public a(adx paramadx)
    {
      this.a = paramadx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adz
 * JD-Core Version:    0.7.0.1
 */