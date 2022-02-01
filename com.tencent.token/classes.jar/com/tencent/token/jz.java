package com.tencent.token;

public final class jz
{
  private static Object a = new Object();
  private static kd b;
  
  public static Object a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new kd();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.jz
 * JD-Core Version:    0.7.0.1
 */