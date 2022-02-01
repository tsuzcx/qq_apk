package com.tencent.token;

import android.os.Handler;
import com.tencent.halley.DownloaderConfig;
import com.tencent.halley.common.b;
import com.tencent.halley.common.f;

public final class w
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
      Object localObject = f.a();
      if (localObject == null) {
        return;
      }
      localObject = new StringBuilder("downloader init. config:");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getMassTaskNum());
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramDownloaderConfig.getEaseTaskNum());
      b.b("DownloaderBaseInfo", ((StringBuilder)localObject).toString());
      l.a(paramDownloaderConfig.getMassTaskNum());
      l.b(paramDownloaderConfig.getEaseTaskNum());
      y.a();
      f.h().post(new x());
      a = true;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.w
 * JD-Core Version:    0.7.0.1
 */