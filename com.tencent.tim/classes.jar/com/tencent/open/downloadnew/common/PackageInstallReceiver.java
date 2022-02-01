package com.tencent.open.downloadnew.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import arwt;
import com.tencent.mobileqq.app.ThreadManager;

public class PackageInstallReceiver
  extends BroadcastReceiver
{
  protected final String TAG = PackageInstallReceiver.class.getName();
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    arwt.d(this.TAG, "onReceive >> " + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      arwt.e(this.TAG, "onReceive intentPkgNameString == null ");
    }
    Object localObject;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
          ThreadManager.post(new PackageInstallReceiver.1(this, paramContext, (String)localObject), 5, null, true);
        }
      }
      else
      {
        arwt.e(this.TAG, "onReceive packageName == null " + paramIntent.getDataString());
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.PACKAGE_REPLACED"))
      {
        ThreadManager.post(new PackageInstallReceiver.2(this, paramContext, (String)localObject), 5, null, true);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.PACKAGE_ADDED"));
    ThreadManager.post(new PackageInstallReceiver.3(this, paramContext, (String)localObject), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.PackageInstallReceiver
 * JD-Core Version:    0.7.0.1
 */