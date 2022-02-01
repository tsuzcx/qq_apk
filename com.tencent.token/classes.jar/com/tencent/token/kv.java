package com.tencent.token;

public final class kv
{
  static Object a = new Object();
  static kw b = null;
  private static boolean c = false;
  
  public static kw a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new kw();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kv
 * JD-Core Version:    0.7.0.1
 */