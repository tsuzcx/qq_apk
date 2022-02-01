package com.tencent.token.global.taiji;

import android.os.HandlerThread;

public class d
  extends HandlerThread
{
  private long a;
  private boolean b = false;
  
  public d(String paramString, int paramInt, long paramLong)
  {
    super(paramString, paramInt);
    this.a = paramLong;
  }
  
  public d(String paramString, int paramInt, long paramLong, boolean paramBoolean)
  {
    super(paramString, paramInt);
    this.a = paramLong;
    this.b = paramBoolean;
  }
  
  public void destroy()
  {
    if (this.b) {
      return;
    }
    super.destroy();
  }
  
  public void interrupt()
  {
    if (this.b) {
      return;
    }
    super.interrupt();
  }
  
  public boolean quit()
  {
    if (this.b) {
      return false;
    }
    return super.quit();
  }
  
  public void run()
  {
    super.run();
  }
  
  public void start()
  {
    try
    {
      boolean bool = isAlive();
      if (bool) {
        return;
      }
      super.start();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.global.taiji.d
 * JD-Core Version:    0.7.0.1
 */