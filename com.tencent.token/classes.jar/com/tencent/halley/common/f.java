package com.tencent.halley.common;

final class f
  extends Thread
{
  private final Process a;
  
  public f(Process paramProcess)
  {
    this.a = paramProcess;
    setDaemon(true);
  }
  
  public final void run()
  {
    try
    {
      try
      {
        wait(5000L);
        this.a.destroy();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.f
 * JD-Core Version:    0.7.0.1
 */