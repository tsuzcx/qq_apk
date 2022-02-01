package com.tencent.analysis.d.a;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class c
{
  private static final d a;
  private static d b;
  private static Map c = new ConcurrentHashMap();
  
  static
  {
    d locald = new d(0, new byte[] { 37, 36, 35, 41, 64, 56, 72, 71, 80, 76, 62, 60, 78, 82, 77, 118 });
    a = locald;
    b = locald;
  }
  
  public static d a()
  {
    return b;
  }
  
  public static d a(int paramInt)
  {
    return (d)c.get(Integer.valueOf(paramInt));
  }
  
  public static void a(int paramInt, String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label12:
      break label12;
    }
    paramString = paramString.getBytes();
    b = new d(paramInt, paramString);
    c.put(Integer.valueOf(paramInt), b);
  }
  
  public static d b()
  {
    return a;
  }
  
  public static Map c()
  {
    return c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.analysis.d.a.c
 * JD-Core Version:    0.7.0.1
 */