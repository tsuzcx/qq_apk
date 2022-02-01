package com.tencent.biz.pubaccount.readinjoy.common;

import aewh;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import cooperation.qzone.util.NetworkState;
import kvr;
import kxm;
import lad;

public final class KBPDUtils$1
  implements Runnable
{
  public void run()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject == null)
    {
      QLog.i("KBPreDownloadUtils", 1, "[run]  won't download since context is null");
      return;
    }
    try
    {
      if (aewh.g("com.tencent.reading", (Context)localObject))
      {
        QLog.i("KBPreDownloadUtils", 1, "won't download since app is already installed.");
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("KBPreDownloadUtils", 1, "[run] ", localException);
      return;
    }
    if (!NetworkState.isWifiConn())
    {
      AppNetConnInfo.registerConnectionChangeReceiver((Context)localObject, kvr.a());
      QLog.i("KBPreDownloadUtils", 1, "won't download since wifi not connected. register NetInfoHandler");
      return;
    }
    if (!kvr.b(kxm.getAppRuntime(), "sp_key_enable_pre_download"))
    {
      QLog.i("KBPreDownloadUtils", 1, "won't download since predownload is disabled");
      return;
    }
    String str = kvr.b(kxm.getAppRuntime(), "sp_key_kb_download_url");
    if (TextUtils.isEmpty(str))
    {
      QLog.e("KBPreDownloadUtils", 1, "won't download since url is null");
      return;
    }
    if (kvr.an((Context)localObject))
    {
      QLog.i("KBPreDownloadUtils", 1, "won't download since current apk is up to date");
      return;
    }
    kvr.access$600();
    localObject = new DownloadInfo();
    ((DownloadInfo)localObject).appId = "101480433";
    ((DownloadInfo)localObject).ekZ = 2;
    ((DownloadInfo)localObject).urlStr = str;
    ((DownloadInfo)localObject).packageName = "com.tencent.reading";
    ((DownloadInfo)localObject).via = "ANDROIDQQ.QNREADING";
    ((DownloadInfo)localObject).isAutoInstall = false;
    ((DownloadInfo)localObject).ell = TMAssistantDownloadConst.SHOW_NOTIFICATION_FALSE;
    ((DownloadInfo)localObject).isAutoInstallBySDK = false;
    ((DownloadInfo)localObject).source = "biz_src_feeds_kandian";
    kvr.A(System.currentTimeMillis());
    lad.a().c(kvr.a());
    lad.a().b((DownloadInfo)localObject);
    QLog.d("KBPreDownloadUtils", 2, "[maybePDKB] startDownload");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.KBPDUtils.1
 * JD-Core Version:    0.7.0.1
 */