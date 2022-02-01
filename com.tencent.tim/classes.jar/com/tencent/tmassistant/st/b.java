package com.tencent.tmassistant.st;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.tmassistant.common.jce.BoutiqueGameConfig;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.k;
import com.tencent.tmdownloader.internal.downloadservice.ApkDownloadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class b
{
  private static volatile b a;
  
  private b()
  {
    k.a().postDelayed(new c(this), 10000L);
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  private void a(String paramString, com.tencent.tmdownloader.internal.downloadservice.c paramc, long paramLong)
  {
    ab.c("BoutiqueGameRT", "[doInstallReportDir]:" + paramString);
    long l2 = 0L;
    Object localObject = GlobalUtil.getInstance().getContext();
    String str2 = "";
    String str1 = str2;
    long l1 = l2;
    if (localObject != null)
    {
      str1 = str2;
      l1 = l2;
    }
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir;
      str1 = str2;
      l1 = l2;
      l2 = new File((String)localObject).length();
      str1 = str2;
      l1 = l2;
      long l3 = System.currentTimeMillis();
      str1 = str2;
      l1 = l2;
      str2 = com.tencent.dlsdk.yybutil.apkchannel.a.a((String)localObject);
      str1 = str2;
      l1 = l2;
      ab.c("BoutiqueGameRT", "[doInstallReportDir] Read channelId time cost:" + (System.currentTimeMillis() - l3) + "ms, path = " + (String)localObject);
      l1 = l2;
      str1 = str2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.e("BoutiqueGameRT", "[doInstallReportDir] read installed fileSize error:" + localThrowable.getMessage());
      }
    }
    paramString = paramLong + "|" + Build.BRAND + "|" + Build.MODEL + "|" + GlobalUtil.getInstance().getImei() + "|" + paramString + "|" + str1 + "|" + paramc.b + "|" + l1 + "|" + paramc.x + "|" + GlobalUtil.getInstance().getAppVersionCode() + "|" + paramc.u;
    SDKReportManager2.getInstance().postReport(2005, paramString);
    paramc.A += "SENDED";
    com.tencent.tmdownloader.internal.storage.a.a().a(paramc);
  }
  
  private void b()
  {
    ab.c("BoutiqueGameRT", "do init task");
    Object localObject = (BoutiqueGameConfig)com.tencent.tmdownloader.internal.storage.b.a().a("key_recommend_games_config", BoutiqueGameConfig.class);
    if ((localObject != null) && (((BoutiqueGameConfig)localObject).pkgList != null) && (((BoutiqueGameConfig)localObject).pkgList.size() != 0)) {
      localObject = ((BoutiqueGameConfig)localObject).pkgList.iterator();
    }
    for (;;)
    {
      String str;
      com.tencent.tmdownloader.internal.downloadservice.c localc;
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        localc = ApkDownloadManager.getInstance().queryDownloadInfoByPkgName(str);
        if ((localc == null) || (localc.g != 4)) {
          continue;
        }
        if ((!TextUtils.isEmpty(localc.A)) && (localc.A.endsWith("SENDED")))
        {
          ab.c("BoutiqueGameRT", str + ": task SENDED!" + localc.A);
          continue;
        }
        if (!com.tencent.tmdownloader.internal.downloadservice.a.a(str, 0)) {}
      }
      try
      {
        PackageInfo localPackageInfo = GlobalUtil.getInstance().getContext().getPackageManager().getPackageInfo(str, 0);
        long l = localPackageInfo.lastUpdateTime - localc.u;
        if ((l > 0L) && (l < 86400000L))
        {
          a(str, localc, localPackageInfo.lastUpdateTime);
          continue;
        }
        ab.c("BoutiqueGameRT", str + ": time ERROR, packageInfo.lastUpdateTime=" + localPackageInfo.lastUpdateTime + "di.mEndTime=" + localc.u + "time distance=" + l);
      }
      catch (Throwable localThrowable) {}
      ab.c("BoutiqueGameRT", str + ": NOT INSTALLED!");
      continue;
      ab.c("BoutiqueGameRT", "config pkg is empty!");
      return;
    }
  }
  
  public void a(com.tencent.tmdownloader.internal.downloadservice.c paramc, DownloaderTask paramDownloaderTask)
  {
    paramc.u = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(paramc.r)) && (GlobalUtil.isRecommendGame(paramc.r)))
    {
      ab.c("BoutiqueGameRT", "[doDownloadSuccReport]" + paramc.r + "is bgg");
      l2 = 0L;
      l1 = l2;
      for (;;)
      {
        try
        {
          com.tencent.tmdownloader.internal.storage.a.a().a(paramc);
          l1 = l2;
          String str = paramDownloaderTask.getSavePath();
          l1 = l2;
          l2 = new File(str).length();
          l1 = l2;
          long l3 = System.currentTimeMillis();
          l1 = l2;
          paramDownloaderTask = com.tencent.dlsdk.yybutil.apkchannel.a.a(str);
          ab.e("BoutiqueGameRT", "[doDownloadSuccReport] read dowloaded fileSize error:" + localThrowable1.getMessage());
        }
        catch (Throwable localThrowable1)
        {
          try
          {
            ab.c("BoutiqueGameRT", "[doDownloadSuccReport] Read channelId time cost:" + (System.currentTimeMillis() - l3) + "ms, path = " + str);
            l1 = l2;
            paramc = paramc.u + "|" + Build.BRAND + "|" + Build.MODEL + "|" + GlobalUtil.getInstance().getImei() + "|" + paramc.r + "|" + paramc.s + "|" + paramDownloaderTask + "|" + paramc.b + "|" + l1 + "|" + paramc.x + "|" + GlobalUtil.getInstance().getAppVersionCode();
            SDKReportManager2.getInstance().postReport(2004, paramc);
            return;
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              l1 = l2;
            }
          }
          localThrowable1 = localThrowable1;
          paramDownloaderTask = "";
        }
      }
    }
    ab.e("BoutiqueGameRT", "download complete, mTaskPackageName is empty! || not bgg");
  }
  
  public void a(String paramString)
  {
    com.tencent.tmdownloader.internal.downloadservice.c localc = ApkDownloadManager.getInstance().queryDownloadInfoByPkgName(paramString);
    if ((localc == null) || (localc.g != 4) || ((!TextUtils.isEmpty(localc.A)) && (localc.A.endsWith("SENDED"))))
    {
      ab.e("BoutiqueGameRT", "[doInstallSuccReport] di is NULL OR di.mStatus != DOWNLOAD_STATUS_SUCCEED OR SENDED!");
      return;
    }
    ab.c("BoutiqueGameRT", "[doInstallSuccReport] di = " + localc.r + "|" + localc.I + "|" + localc.s + "|" + localc.j + "|" + localc.x + "|" + localc.b);
    if ((!TextUtils.isEmpty(paramString)) && (GlobalUtil.isRecommendGame(paramString)))
    {
      ab.c("BoutiqueGameRT", "install complete, " + paramString + " is bgg");
      long l2 = 0L;
      Object localObject = GlobalUtil.getInstance().getContext();
      String str2 = "";
      String str1 = str2;
      long l1 = l2;
      if (localObject != null)
      {
        str1 = str2;
        l1 = l2;
      }
      try
      {
        localObject = ((Context)localObject).getPackageManager().getPackageInfo(paramString, 0).applicationInfo.sourceDir;
        str1 = str2;
        l1 = l2;
        l2 = new File((String)localObject).length();
        str1 = str2;
        l1 = l2;
        long l3 = System.currentTimeMillis();
        str1 = str2;
        l1 = l2;
        str2 = com.tencent.dlsdk.yybutil.apkchannel.a.a((String)localObject);
        str1 = str2;
        l1 = l2;
        ab.c("BoutiqueGameRT", "[doInstallSuccReport] Read channelId time cost:" + (System.currentTimeMillis() - l3) + "ms, path = " + (String)localObject);
        l1 = l2;
        str1 = str2;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ab.e("BoutiqueGameRT", "[doInstallSuccReport] read installed fileSize error:" + localThrowable.getMessage());
        }
      }
      paramString = System.currentTimeMillis() + "|" + Build.BRAND + "|" + Build.MODEL + "|" + GlobalUtil.getInstance().getImei() + "|" + paramString + "|" + localc.s + "|" + str1 + "|" + localc.b + "|" + l1 + "|" + localc.x + "|" + GlobalUtil.getInstance().getAppVersionCode() + "|" + localc.u;
      SDKReportManager2.getInstance().postReport(2005, paramString);
      localc.A += "SENDED";
      com.tencent.tmdownloader.internal.storage.a.a().a(localc);
      return;
    }
    ab.e("BoutiqueGameRT", "install complete, pkgName is empty!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.st.b
 * JD-Core Version:    0.7.0.1
 */