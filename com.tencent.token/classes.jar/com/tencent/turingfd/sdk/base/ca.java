package com.tencent.turingfd.sdk.base;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ca
{
  public static Map a = new ConcurrentHashMap();
  public static cc b;
  public static String c;
  
  static
  {
    a.put("22C4185", new cb(new ck()));
    a.put("C892BA2", new cb(new cl()));
    a.put("43780D5", new cb(new cl()));
    c = "";
    try
    {
      c = ed.d(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ca
 * JD-Core Version:    0.7.0.1
 */