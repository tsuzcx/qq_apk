package com.tencent.token;

public final class kf
{
  private static Object a = new Object();
  private static kf b;
  private kc c = new kc();
  
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
 * Qualified Name:     com.tencent.token.kf
 * JD-Core Version:    0.7.0.1
 */