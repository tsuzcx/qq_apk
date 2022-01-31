package com.tencent.halley.common;

public abstract class a
{
  private static a a;
  
  public static a a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  public abstract void a(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.a
 * JD-Core Version:    0.7.0.1
 */