package com.tencent.token;

public final class ke
{
  static Object a = new Object();
  static kf b = null;
  private static boolean c = false;
  
  public static kf a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new kf();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ke
 * JD-Core Version:    0.7.0.1
 */