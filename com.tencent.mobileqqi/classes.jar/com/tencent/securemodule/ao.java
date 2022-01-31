package com.tencent.securemodule;

import android.os.Process;

public final class ao
  implements Runnable
{
  public final void run()
  {
    try
    {
      Thread.sleep(2000L);
      Process.killProcess(Process.myPid());
      System.exit(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.ao
 * JD-Core Version:    0.7.0.1
 */