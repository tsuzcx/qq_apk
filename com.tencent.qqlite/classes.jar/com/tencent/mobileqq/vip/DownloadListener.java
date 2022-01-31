package com.tencent.mobileqq.vip;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class DownloadListener
{
  String wifiFlow;
  String xgFlow;
  
  public DownloadListener() {}
  
  public DownloadListener(String paramString1, String paramString2)
  {
    this.wifiFlow = paramString1;
    this.xgFlow = paramString2;
  }
  
  public void onCancel(DownloadTask paramDownloadTask) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.h = System.currentTimeMillis();
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetMobile2None...");
    }
  }
  
  public void onNetWifi2Mobile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetWifi2Mobile...");
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloadListener", 2, "onNetWifi2None...");
    }
  }
  
  public void onPause(DownloadTask paramDownloadTask) {}
  
  public void onProgress(DownloadTask paramDownloadTask) {}
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    paramDownloadTask.g = System.currentTimeMillis();
    return true;
  }
  
  public void report(AppInterface paramAppInterface, long paramLong)
  {
    Object localObject;
    if ((this.wifiFlow != null) && (this.xgFlow != null))
    {
      localObject = ((ConnectivityManager)BaseApplicationImpl.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null) {
        break label166;
      }
      if (!NetworkUtil.a((NetworkInfo)localObject)) {
        break label137;
      }
      localObject = new String[3];
      localObject[0] = this.xgFlow;
      localObject[1] = "param_XGFlow";
      localObject[2] = "param_Flow";
    }
    for (;;)
    {
      if ((localObject != null) && (paramAppInterface != null) && (paramLong > 0L))
      {
        if (QLog.isColorLevel()) {
          QLog.d("com.tencent.mobileqq.vip.DownloadListener", 2, "report | tags=" + localObject + ",len=" + paramLong);
        }
        paramAppInterface.a(paramAppInterface.a(), (String[])localObject, paramLong);
      }
      return;
      label137:
      localObject = new String[3];
      localObject[0] = this.wifiFlow;
      localObject[1] = "param_WIFIFlow";
      localObject[2] = "param_Flow";
      continue;
      label166:
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadListener
 * JD-Core Version:    0.7.0.1
 */