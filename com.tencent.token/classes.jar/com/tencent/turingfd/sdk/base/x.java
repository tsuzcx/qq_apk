package com.tencent.turingfd.sdk.base;

public abstract class x
  implements Runnable
{
  public x(String paramString) {}
  
  public abstract void a();
  
  public void run()
  {
    try
    {
      System.currentTimeMillis();
      a();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.x
 * JD-Core Version:    0.7.0.1
 */