package com.tencent.tmassistantsdk.downloadclient;

import android.content.Context;
import com.tencent.tmassistantsdk.f.k;

final class b
  implements Runnable
{
  b(MobileQQCloseServiceReceiver paramMobileQQCloseServiceReceiver, Context paramContext) {}
  
  public final void run()
  {
    try
    {
      boolean bool = TMAssistantDownloadSDKManager.getInstance(this.a).getDownloadSDKSettingClient().isAllDownloadFinished();
      k.b("MobileQQCloseServiceReceiver", "onReceive broadcase isAllDownloadFinished = " + bool);
      if (bool) {
        TMAssistantDownloadSDKManager.closeAllService(this.a);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.b
 * JD-Core Version:    0.7.0.1
 */