package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Map;

final class TbsDownloader$2
  extends Handler
{
  TbsDownloader$2(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = null;
    boolean bool3 = true;
    switch (paramMessage.what)
    {
    }
    label85:
    label254:
    do
    {
      boolean bool1;
      Object localObject2;
      for (;;)
      {
        return;
        if (paramMessage.arg1 == 1)
        {
          i = 1;
          if (paramMessage.arg2 != 1) {
            break label254;
          }
          bool1 = true;
          bool1 = TbsDownloader.a(true, false, false, bool1);
          if ((paramMessage.obj != null) && ((paramMessage.obj instanceof TbsDownloader.TbsDownloaderCallback)))
          {
            TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish needStartDownload=" + bool1);
            localObject2 = "";
            localObject1 = localObject2;
            if (TbsDownloader.a() != null)
            {
              localObject1 = localObject2;
              if (TbsDownloader.a().getApplicationContext() != null)
              {
                localObject1 = localObject2;
                if (TbsDownloader.a().getApplicationContext().getApplicationInfo() != null) {
                  localObject1 = TbsDownloader.a().getApplicationContext().getApplicationInfo().packageName;
                }
              }
            }
            if ((bool1) && (i == 0)) {
              break label259;
            }
            ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
          }
        }
        for (;;)
        {
          if ((!TbsShareManager.isThirdPartyApp(TbsDownloader.a())) || (!bool1)) {
            break label334;
          }
          TbsDownloader.startDownload(TbsDownloader.a());
          return;
          i = 0;
          break;
          bool1 = false;
          break label85;
          if (("com.tencent.mm".equals(localObject1)) || ("com.tencent.mobileqq".equals(localObject1)))
          {
            TbsLog.i("TbsDownload", "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = " + bool1);
            ((TbsDownloader.TbsDownloaderCallback)paramMessage.obj).onNeedDownloadFinish(bool1, TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0));
          }
        }
      }
      if ((Apn.getApnType(TbsDownloader.a()) != 3) && (!QbSdk.getDownloadWithoutWifi()))
      {
        TbsLog.i("TbsDownload", "not wifi,no need send request");
        return;
      }
      Object localObject3;
      if (!TbsShareManager.isThirdPartyApp(TbsDownloader.a()))
      {
        localObject2 = "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0) + ".txt";
        localObject2 = FileUtil.b(TbsDownloader.a(), false, (String)localObject2);
        if (localObject2 != null)
        {
          localObject3 = FileUtil.a(TbsDownloader.a(), (FileOutputStream)localObject2);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            QbSdk.n.onDownloadFinish(177);
            TbsLog.i("TbsDownload", "file lock locked,wx or qq is downloading");
            TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-203);
            TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
          }
        }
        else if (FileUtil.a(TbsDownloader.a()))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-204);
          TbsLog.i("TbsDownload", "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
        }
      }
      else
      {
        localObject2 = null;
      }
      boolean bool2;
      if (paramMessage.arg1 == 1)
      {
        bool1 = true;
        localObject3 = TbsDownloadConfig.getInstance(TbsDownloader.a());
        if (108 != paramMessage.what) {
          break label726;
        }
        bool2 = true;
        boolean bool4 = TbsDownloader.a(false, bool1, bool2, true);
        StringBuilder localStringBuilder = new StringBuilder().append("needStartDownload is ").append(bool4).append(" forDecoupleCore is ");
        if (108 != paramMessage.what) {
          break label732;
        }
        bool2 = true;
        TbsLog.i("TbsDownload", bool2);
        TbsLog.i("TbsDownload", "idownloadConfig.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) is " + ((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false));
        if (!bool4) {
          break label845;
        }
        if ((!bool1) || (!q.a().b(TbsDownloader.a(), TbsDownloadConfig.getInstance(TbsDownloader.a()).mPreferences.getInt("tbs_download_version", 0)))) {
          break label738;
        }
        TbsLog.i("TbsDownload", "in needStartDownload true #1");
        QbSdk.n.onDownloadFinish(122);
        ((TbsDownloadConfig)localObject3).setDownloadInterruptCode(-213);
      }
      for (;;)
      {
        TbsLog.i("TbsDownload", "------freeFileLock called :");
        FileUtil.a((FileLock)localObject1, (FileOutputStream)localObject2);
        return;
        bool1 = false;
        break;
        bool2 = false;
        break label546;
        bool2 = false;
        break label592;
        if (((TbsDownloadConfig)localObject3).mPreferences.getBoolean("tbs_needdownload", false))
        {
          TbsDownloadConfig.getInstance(TbsDownloader.a()).setDownloadInterruptCode(-215);
          if (108 == paramMessage.what)
          {
            ((TbsDownloadConfig)localObject3).mSyncMap.put("tbs_cpu_type_other_stable_core", Integer.valueOf(0));
            ((TbsDownloadConfig)localObject3).commit();
          }
          localObject3 = TbsDownloader.b();
          if (108 == paramMessage.what) {}
          for (bool2 = bool3;; bool2 = false)
          {
            ((m)localObject3).b(bool1, bool2);
            break;
          }
        }
        QbSdk.n.onDownloadFinish(110);
        continue;
        QbSdk.n.onDownloadFinish(110);
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
      if (TbsShareManager.isThirdPartyApp(TbsDownloader.a())) {}
      for (int i = TbsShareManager.a(TbsDownloader.a(), false);; i = q.a().n(TbsDownloader.a()))
      {
        TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] localTbsVersion=" + i);
        TbsDownloader.b().a(i);
        TbsLogReport.getInstance(TbsDownloader.a()).dailyReport();
        return;
      }
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
      TbsLogReport.getInstance(TbsDownloader.a()).reportTbsLog();
      return;
      TbsLog.i("TbsDownload", "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
      if (paramMessage.arg1 == 0)
      {
        q.a().a((Context)paramMessage.obj, true);
        return;
      }
      q.a().a((Context)paramMessage.obj, false);
      return;
    } while (TbsDownloader.b() == null);
    label259:
    label334:
    label592:
    label726:
    label732:
    label738:
    TbsDownloader.b().f();
    label546:
    label845:
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.TbsDownloader.2
 * JD-Core Version:    0.7.0.1
 */