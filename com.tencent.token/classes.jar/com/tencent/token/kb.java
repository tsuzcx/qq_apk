package com.tencent.token;

public final class kb
{
  private static Object a = new Object();
  private static kb b;
  private jy c = new jy();
  
  public static kb a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new kb();
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.kb
 * JD-Core Version:    0.7.0.1
 */