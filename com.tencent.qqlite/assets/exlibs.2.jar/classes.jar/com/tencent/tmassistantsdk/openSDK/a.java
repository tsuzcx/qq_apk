package com.tencent.tmassistantsdk.openSDK;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;

final class a
  implements Runnable
{
  a(DownloadStateChangedReceiver paramDownloadStateChangedReceiver, Intent paramIntent) {}
  
  public final void run()
  {
    d locald = new d();
    this.a.getStringExtra("hostPackageName");
    this.a.getStringExtra("hostVersion");
    locald.b = this.a.getStringExtra("taskId");
    locald.d = Integer.parseInt(this.a.getStringExtra("errorCode"));
    locald.e = this.a.getStringExtra("errorMsg");
    locald.c = Integer.parseInt(this.a.getStringExtra("state"));
    Object localObject = new TMQQDownloaderOpenSDKParam();
    ((TMQQDownloaderOpenSDKParam)localObject).SNGAppId = this.a.getStringExtra("sngAppId");
    ((TMQQDownloaderOpenSDKParam)localObject).taskAppId = this.a.getStringExtra("taskAppId");
    ((TMQQDownloaderOpenSDKParam)localObject).taskApkId = this.a.getStringExtra("taskApkId");
    ((TMQQDownloaderOpenSDKParam)localObject).taskPackageName = this.a.getStringExtra("taskPackageName");
    ((TMQQDownloaderOpenSDKParam)localObject).taskVersion = Integer.parseInt(this.a.getStringExtra("taskVersion"));
    ((TMQQDownloaderOpenSDKParam)localObject).via = this.a.getStringExtra("via");
    ((TMQQDownloaderOpenSDKParam)localObject).uin = this.a.getStringExtra("uin");
    ((TMQQDownloaderOpenSDKParam)localObject).uinType = this.a.getStringExtra("uinType");
    locald.a = ((TMQQDownloaderOpenSDKParam)localObject);
    localObject = this.b.a.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((b)((Iterator)localObject).next()).onDownloadStateChanged(locald);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.a
 * JD-Core Version:    0.7.0.1
 */