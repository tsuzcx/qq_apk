package com.tencent.tmassistantsdk.openSDK.QQDownloader;

import android.content.Context;

final class b
  implements Runnable
{
  b(QQDownloaderInstalled paramQQDownloaderInstalled, Context paramContext) {}
  
  public final void run()
  {
    if (this.b.a != null) {
      this.b.a.onQQDownloaderInstalled(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.openSDK.QQDownloader.b
 * JD-Core Version:    0.7.0.1
 */