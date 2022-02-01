package com.tencent.token;

public final class kq
{
  private static Object a = new Object();
  private static ku b;
  
  public static Object a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new ku();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kq
 * JD-Core Version:    0.7.0.1
 */