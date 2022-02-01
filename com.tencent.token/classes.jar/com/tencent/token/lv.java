package com.tencent.token;

import android.os.Handler;
import com.tencent.halley.DownloaderConfig;

public final class lv
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
      Object localObject = lo.a();
      if (localObject == null) {
        return;
      }
      localObject = new StringBuilder("downloader init. config:");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getMassTaskNum());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getEaseTaskNum());
      lh.b("DownloaderBaseInfo", ((StringBuilder)localObject).toString());
      kx.a(paramDownloaderConfig.getMassTaskNum());
      kx.b(paramDownloaderConfig.getEaseTaskNum());
      lx.b();
      lo.h().post(new lw());
      a = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.lv
 * JD-Core Version:    0.7.0.1
 */