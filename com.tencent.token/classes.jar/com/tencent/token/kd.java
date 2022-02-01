package com.tencent.token;

public final class kd
{
  static Object a = new Object();
  static ke b = null;
  private static boolean c = false;
  
  public static ke a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new ke();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kd
 * JD-Core Version:    0.7.0.1
 */