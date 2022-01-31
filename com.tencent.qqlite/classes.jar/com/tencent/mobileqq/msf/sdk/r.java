package com.tencent.mobileqq.msf.sdk;

import java.io.PrintStream;

final class r
  extends Thread
{
  public void run()
  {
    try
    {
      for (;;)
      {
        String str = (String)n.h.k();
        if (str != null) {
          n.d(str);
        }
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      System.out.println("write log file error." + localInterruptedException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.r
 * JD-Core Version:    0.7.0.1
 */