package com.tencent.token;

public final class kc
{
  private static Object a = new Object();
  private static kc b;
  private jz c = new jz();
  
  public static kc a()
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
 * Qualified Name:     com.tencent.token.kc
 * JD-Core Version:    0.7.0.1
 */