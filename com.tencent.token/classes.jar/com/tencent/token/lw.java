package com.tencent.token;

import android.os.Handler;
import com.tencent.halley.DownloaderConfig;

public final class lw
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
      Object localObject = lp.a();
      if (localObject == null) {
        return;
      }
      localObject = new StringBuilder("downloader init. config:");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getMassTaskNum());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getEaseTaskNum());
      li.b("DownloaderBaseInfo", ((StringBuilder)localObject).toString());
      ky.a(paramDownloaderConfig.getMassTaskNum());
      ky.b(paramDownloaderConfig.getEaseTaskNum());
      ly.b();
      lp.h().post(new lx());
      a = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lw
 * JD-Core Version:    0.7.0.1
 */