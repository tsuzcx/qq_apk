package c.b.a;

import tmsdk.common.c.a.g;

public class a
{
  static Object a = new Object();
  static b b = null;
  private static boolean c = false;
  
  public static b a()
  {
    if (b == null) {}
    synchronized (a)
    {
      if (b == null) {
        b = new b();
      }
      return b;
    }
  }
  
  public static void b()
  {
    if (c) {
      return;
    }
    g.a(tmsdk.common.a.a(), "TccCryptor");
    c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     c.b.a.a
 * JD-Core Version:    0.7.0.1
 */