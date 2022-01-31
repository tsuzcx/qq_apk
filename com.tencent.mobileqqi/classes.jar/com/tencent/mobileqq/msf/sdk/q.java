package com.tencent.mobileqq.msf.sdk;

import java.io.PrintStream;

final class q
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.q
 * JD-Core Version:    0.7.0.1
 */