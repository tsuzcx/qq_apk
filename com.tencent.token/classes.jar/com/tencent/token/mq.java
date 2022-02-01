package com.tencent.token;

import android.os.Handler;
import com.tencent.halley.DownloaderConfig;

public final class mq
{
  private static boolean a = false;
  
  public static void a(DownloaderConfig paramDownloaderConfig)
  {
    try
    {
      boolean bool = a;
      if (bool) {
        return;
      }
      Object localObject = mj.a();
      if (localObject == null) {
        return;
      }
      localObject = new StringBuilder("downloader init. config:");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getMassTaskNum());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getEaseTaskNum());
      mc.b("DownloaderBaseInfo", ((StringBuilder)localObject).toString());
      ls.a(paramDownloaderConfig.getMassTaskNum());
      ls.b(paramDownloaderConfig.getEaseTaskNum());
      ms.b();
      mj.h().post(new mr());
      a = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mq
 * JD-Core Version:    0.7.0.1
 */