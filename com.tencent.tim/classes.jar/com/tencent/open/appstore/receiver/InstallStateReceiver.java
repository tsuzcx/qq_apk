package com.tencent.open.appstore.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import arvv;
import arwk;
import arwt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;

public class InstallStateReceiver
  extends BroadcastReceiver
{
  protected final String TAG = "InstallStateReceiver";
  
  private void gA(String paramString, int paramInt)
  {
    List localList = arvv.a().z(paramString, 4);
    Object localObject = localList;
    if (localList.size() == 0) {
      localObject = arvv.a().y(paramString, 4);
    }
    arwt.d("InstallStateReceiver", ">notifyInstalled " + paramString + ", info:" + localObject);
    paramString = ((List)localObject).iterator();
    while (paramString.hasNext())
    {
      localObject = (DownloadInfo)paramString.next();
      if ((localObject != null) && (((DownloadInfo)localObject).getState() == 4))
      {
        arwt.d("InstallStateReceiver", ">notifyInstalled " + localObject);
        if (1 == paramInt) {
          arvv.a().n((DownloadInfo)localObject);
        } else if (2 == paramInt) {
          arvv.a().m((DownloadInfo)localObject);
        } else {
          arwt.e("InstallStateReceiver", ">notifyInstalled bad notifyType:" + paramInt);
        }
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    arwt.d("InstallStateReceiver", "[onReceive] action=" + paramIntent.getAction());
    paramContext = paramIntent.getDataString();
    if (TextUtils.isEmpty(paramContext)) {
      arwt.e("InstallStateReceiver", "[onReceive] intentPkgNameString == null ");
    }
    Object localObject;
    String str;
    do
    {
      return;
      localObject = paramContext.split(":");
      if (localObject.length == 2)
      {
        localObject = localObject[1];
        str = paramIntent.getAction();
        if (TextUtils.equals(str, "android.intent.action.PACKAGE_REMOVED")) {
          ThreadManager.excute(new InstallStateReceiver.1(this, paramContext, (String)localObject), 16, null, true);
        }
      }
      else
      {
        arwt.e("InstallStateReceiver", "[onReceive] packageName == null " + paramIntent.getDataString());
        return;
      }
      if (TextUtils.equals(str, "android.intent.action.PACKAGE_REPLACED"))
      {
        arwk.dA((String)localObject, true);
        ThreadManager.excute(new InstallStateReceiver.2(this, paramContext, (String)localObject), 16, null, true);
        return;
      }
    } while (!TextUtils.equals(str, "android.intent.action.PACKAGE_ADDED"));
    ThreadManager.excute(new InstallStateReceiver.3(this, paramIntent, paramContext, (String)localObject), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver
 * JD-Core Version:    0.7.0.1
 */