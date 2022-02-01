package com.tencent.turingfd.sdk.base;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class bm
{
  public static Map<String, a> a = new ConcurrentHashMap();
  public static bo b;
  public static String c;
  
  static
  {
    a.put("C892BA2", new a(new bs()));
    a.put("43780D5", new a(new bs()));
    a.put("22792AF", new a(new br()));
    c = "";
    try
    {
      c = cm.d(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static class a
  {
    public bk a;
    public int b = 0;
    
    public a(bk parambk)
    {
      this.a = parambk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.bm
 * JD-Core Version:    0.7.0.1
 */