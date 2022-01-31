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
  String a;
  String b;
  
  public DownloadListener() {}
  
  public DownloadListener(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("com.tencent.mobileqq.vip.DownloadListener", 2, "onNetWifi2Mobile");
    }
  }
  
  public void a(AppInterface paramAppInterface, long paramLong)
  {
    Object localObject;
    if ((this.a != null) && (this.b != null))
    {
      localObject = ((ConnectivityManager)BaseApplicationImpl.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      if (localObject == null) {
        break label166;
      }
      if (!NetworkUtil.a((NetworkInfo)localObject)) {
        break label137;
      }
      localObject = new String[3];
      localObject[0] = this.b;
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
      localObject[0] = this.a;
      localObject[1] = "param_WIFIFlow";
      localObject[2] = "param_Flow";
      continue;
      label166:
      localObject = null;
    }
  }
  
  public void a(DownloadTask paramDownloadTask) {}
  
  public boolean a(DownloadTask paramDownloadTask)
  {
    return true;
  }
  
  public void b(DownloadTask paramDownloadTask) {}
  
  public abstract void c(DownloadTask paramDownloadTask);
  
  public void d(DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vip.DownloadListener
 * JD-Core Version:    0.7.0.1
 */