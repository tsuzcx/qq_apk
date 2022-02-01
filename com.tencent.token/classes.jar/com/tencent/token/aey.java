package com.tencent.token;

import android.os.Build;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aey
{
  public static Map<String, a> a;
  public static aez b;
  public static String c;
  
  static
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    a = localConcurrentHashMap;
    localConcurrentHashMap.put("C892BA2", new a(new afd()));
    a.put("43780D5", new a(new afd()));
    a.put("22792AF", new a(new afc()));
    c = "";
    try
    {
      c = agn.c(Build.MANUFACTURER.toLowerCase().getBytes()).substring(0, 7);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    public aew a;
    public int b = 0;
    
    public a(aew paramaew)
    {
      this.a = paramaew;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aey
 * JD-Core Version:    0.7.0.1
 */