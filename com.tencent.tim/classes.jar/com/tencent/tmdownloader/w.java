package com.tencent.tmdownloader;

import android.os.Handler;
import com.tencent.tmassistantbase.util.ab;

class w
  implements Runnable
{
  w(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(10000L);
      TMAssistantDownloadService.access$000(this.a).sendEmptyMessage(0);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      ab.b("TMADownloadSDKService", "exception:", localInterruptedException);
      localInterruptedException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.w
 * JD-Core Version:    0.7.0.1
 */