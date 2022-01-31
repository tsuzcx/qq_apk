package com.tencent.mobileqq.msf.core;

import com.tencent.msf.boot.config.NativeConfigStore;

class m
  extends Thread
{
  m(l paraml) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(180000L);
      k.a().removeConfig("LOGLEVEL_");
      k.a().removeConfig("LOGLEVELTIME");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.m
 * JD-Core Version:    0.7.0.1
 */