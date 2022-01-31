package com.tencent.open.downloadnew;

import android.os.Handler;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2;
import ffu;
import ffv;

public class MyAppApi$QQDownloadListener
  implements ITMQQDownloaderOpenSDKListener
{
  protected MyAppApi$QQDownloadListener(MyAppApi paramMyAppApi) {}
  
  public void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, long paramLong1, long paramLong2)
  {
    Log.i("MyAppApi", "OnDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    DownloadManager localDownloadManager = DownloadManager.a();
    DownloadInfo localDownloadInfo2 = localDownloadManager.a(paramTMQQDownloaderOpenSDKParam.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = this.a.a(paramTMQQDownloaderOpenSDKParam, null);
      localDownloadManager.e(localDownloadInfo1);
    }
    localDownloadInfo1.k = i;
    localDownloadInfo1.a(2);
    localDownloadManager.a(2, localDownloadInfo1);
    LogUtility.a("MyAppApi", "OnDownloadTaskProgressChanged info state=" + localDownloadInfo1.a() + " progress=" + localDownloadInfo1.k);
  }
  
  public void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, int paramInt1, int paramInt2, String paramString)
  {
    this.a.b = true;
    Log.i("MyAppApi", "OnDownloadTaskStateChanged");
    ThreadManager.b().post(new ffu(this, paramTMQQDownloaderOpenSDKParam, paramInt1, paramInt2, paramString));
  }
  
  public void OnQQDownloaderInvalid()
  {
    Log.i("MyAppApi", "应用宝挂了");
    ThreadManager.b().post(new ffv(this));
  }
  
  public void OnServiceFree()
  {
    Log.i("MyAppApi", "OnServiceFree");
    try
    {
      ((TMQQDownloaderOpenSDK_V2)this.a.a).releaseIPCConnected();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.QQDownloadListener
 * JD-Core Version:    0.7.0.1
 */