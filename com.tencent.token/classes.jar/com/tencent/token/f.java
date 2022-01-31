package com.tencent.token;

import tmsdk.common.a;

public class f
{
  static Object a = new Object();
  static g b = null;
  private static boolean c = false;
  
  public static g a()
  {
    if (b == null) {}
    synchronized (a)
    {
      if (b == null) {
        b = new g();
      }
      return b;
    }
  }
  
  public static void b()
  {
    if (c) {
      return;
    }
    tmsdk.common.c.a.g.a(a.a(), "TccCryptor");
    c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.f
 * JD-Core Version:    0.7.0.1
 */