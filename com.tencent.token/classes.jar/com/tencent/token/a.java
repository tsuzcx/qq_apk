package com.tencent.token;

public class a
{
  private static Object a = new Object();
  private static e b;
  
  public Object a(int paramInt)
  {
    if (5 == paramInt)
    {
      if (b == null) {}
      synchronized (a)
      {
        if (b == null) {
          b = new e(0L);
        }
        return b;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.a
 * JD-Core Version:    0.7.0.1
 */