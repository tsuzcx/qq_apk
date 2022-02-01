package com.tencent.token;

public class d
{
  private static Object a = new Object();
  private static d b;
  private a c = new a();
  
  public static d a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new d();
        }
      }
    }
    return b;
  }
  
  public a b()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.d
 * JD-Core Version:    0.7.0.1
 */