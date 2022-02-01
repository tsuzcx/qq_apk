package com.tencent.tmdownloader.internal.downloadclient;

import android.content.Context;
import android.content.Intent;
import com.tencent.tmdownloader.TMAssistantDownloadService;

class b
  implements Runnable
{
  b(MobileQQCloseServiceReceiver paramMobileQQCloseServiceReceiver, Context paramContext) {}
  
  public void run()
  {
    try
    {
      Intent localIntent = new Intent(this.a, TMAssistantDownloadService.class);
      this.a.stopService(localIntent);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.downloadclient.b
 * JD-Core Version:    0.7.0.1
 */