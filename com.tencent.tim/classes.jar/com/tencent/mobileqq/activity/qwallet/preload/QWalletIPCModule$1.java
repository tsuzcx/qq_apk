package com.tencent.mobileqq.activity.qwallet.preload;

import aacv;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class QWalletIPCModule$1
  implements Runnable
{
  public QWalletIPCModule$1(aacv paramaacv, Bundle paramBundle, int paramInt, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    String str = this.val$params.getString("id");
    QWalletIPCModule.1.1 local1 = new QWalletIPCModule.1.1(this, null);
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)this.a).getManager(151);
    if (localPreloadManager != null)
    {
      localPreloadManager.c(str, local1);
      return;
    }
    local1.send(-7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.1
 * JD-Core Version:    0.7.0.1
 */