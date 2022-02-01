package com.tencent.mobileqq.bigbrother.RockDownloader;

import adxa;
import com.tencent.qphone.base.util.QLog;

public class RockDownloaderManager$1
  implements Runnable
{
  public RockDownloaderManager$1(adxa paramadxa) {}
  
  public void run()
  {
    try
    {
      adxa.a(this.this$0);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RockDownloaderManager", 2, "autoCleanOverdueFile exception, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderManager.1
 * JD-Core Version:    0.7.0.1
 */