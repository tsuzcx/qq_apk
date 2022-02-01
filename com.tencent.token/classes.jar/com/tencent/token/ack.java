package com.tencent.token;

public abstract class ack
  implements Runnable
{
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
 * Qualified Name:     com.tencent.token.ack
 * JD-Core Version:    0.7.0.1
 */