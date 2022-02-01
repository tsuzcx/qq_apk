package com.tencent.token;

public final class kt
{
  private static Object a = new Object();
  private static kt b;
  private kq c = new kq();
  
  public static kt a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new kt();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kt
 * JD-Core Version:    0.7.0.1
 */