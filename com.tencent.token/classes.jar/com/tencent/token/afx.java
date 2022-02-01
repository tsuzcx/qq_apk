package com.tencent.token;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class afx
{
  public static Map<String, a> a;
  public static afy b;
  public static String c;
  
  static
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    a = localConcurrentHashMap;
    localConcurrentHashMap.put("C892BA2", new a(new agd()));
    a.put("43780D5", new a(new agd()));
    a.put("7CD3AF2", new a(new agd()));
    a.put("22792AF", new a(new agc()));
    c = "";
    try
    {
      c = ahr.a(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    public aft a;
    public int b = 0;
    
    public a(aft paramaft)
    {
      this.a = paramaft;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.afx
 * JD-Core Version:    0.7.0.1
 */