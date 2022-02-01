package com.tencent.token;

import android.os.Handler;
import com.tencent.halley.DownloaderConfig;

public final class mc
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
      Object localObject = lv.a();
      if (localObject == null) {
        return;
      }
      localObject = new StringBuilder("downloader init. config:");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getMassTaskNum());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getEaseTaskNum());
      lo.b("DownloaderBaseInfo", ((StringBuilder)localObject).toString());
      le.a(paramDownloaderConfig.getMassTaskNum());
      le.b(paramDownloaderConfig.getEaseTaskNum());
      me.b();
      lv.h().post(new md());
      a = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mc
 * JD-Core Version:    0.7.0.1
 */