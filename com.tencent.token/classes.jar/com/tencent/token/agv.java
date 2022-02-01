package com.tencent.token;

public abstract class agv
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
    finally {}
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.agv
 * JD-Core Version:    0.7.0.1
 */