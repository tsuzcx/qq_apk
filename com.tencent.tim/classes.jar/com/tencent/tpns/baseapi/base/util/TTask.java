package com.tencent.tpns.baseapi.base.util;

public abstract class TTask
  implements Runnable
{
  protected String a;
  
  protected TTask()
  {
    this("undefined");
  }
  
  protected TTask(String paramString)
  {
    this.a = paramString;
  }
  
  public abstract void TRun();
  
  public void run()
  {
    try
    {
      TRun();
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.base.util.TTask
 * JD-Core Version:    0.7.0.1
 */