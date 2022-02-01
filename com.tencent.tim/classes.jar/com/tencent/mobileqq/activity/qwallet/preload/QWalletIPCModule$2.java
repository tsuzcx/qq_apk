package com.tencent.mobileqq.activity.qwallet.preload;

import aacv;
import aacy;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class QWalletIPCModule$2
  implements Runnable
{
  public QWalletIPCModule$2(aacv paramaacv, Bundle paramBundle, AppRuntime paramAppRuntime, String paramString) {}
  
  public void run()
  {
    String str1 = this.val$params.getString("config_str");
    String str2 = this.val$params.getString("id");
    aacy localaacy = new aacy(this, (ResultReceiver)this.val$params.getParcelable("receiver"));
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)this.a).getManager(151);
    if ("downloadModule".equals(this.val$action)) {
      localPreloadManager.b(str2, str1, localaacy);
    }
    while (!"downloadRes".equals(this.val$action)) {
      return;
    }
    localPreloadManager.a(str2, str1, localaacy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.2
 * JD-Core Version:    0.7.0.1
 */