package com.tencent.token;

public final class kh
{
  static Object a = new Object();
  static ki b = null;
  private static boolean c = false;
  
  public static ki a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new ki();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kh
 * JD-Core Version:    0.7.0.1
 */