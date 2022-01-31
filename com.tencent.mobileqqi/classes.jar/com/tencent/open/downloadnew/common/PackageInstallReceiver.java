package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;

public class PackageInstallReceiver
  extends BroadcastReceiver
{
  protected final String a = PackageInstallReceiver.class.getName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtility.c(this.a, "onReceive >> " + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      LogUtility.e(this.a, "onReceive intentPkgNameString == null ");
    }
    Object localObject;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED"))
        {
          LogUtility.c(this.a, "ACTION_PACKAGE_REMOVED >> " + paramContext);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(DownloadConstants.p)))
          {
            DownloadManager.a().a(true);
            MyAppApi.a().f();
          }
          paramContext = new DownloadInfo("", (String)localObject);
          DownloadManager.a().a(9, paramContext);
        }
      }
      else
      {
        LogUtility.e(this.a, "onReceive packageName == null " + paramIntent.getDataString());
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        LogUtility.c(this.a, "ACTION_PACKAGE_REPLACED >> " + paramContext);
        paramContext = new DownloadInfo("", (String)localObject);
        DownloadManager.a().a(13, paramContext);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"));
    LogUtility.c(this.a, "ACTION_PACKAGE_ADDED >> " + paramContext);
    paramContext = DownloadDBHelper.a().a((String)localObject);
    if (paramContext != null)
    {
      LogUtility.c(this.a, "ACTION_PACKAGE_ADDED info != null>> " + paramContext.toString() + " " + paramContext.b + " " + paramContext.d);
      DownloadManager.a().d(paramContext);
    }
    for (;;)
    {
      DownloadManager.a().a(6, paramContext);
      return;
      paramContext = new DownloadInfo("", (String)localObject);
      LogUtility.c(this.a, "ACTION_PACKAGE_ADDED info == null>> " + paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */