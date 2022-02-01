package com.tencent.token;

public final class jy
{
  private static Object a = new Object();
  private static kc b;
  
  public static Object a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new kc();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jy
 * JD-Core Version:    0.7.0.1
 */