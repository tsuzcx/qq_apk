package com.tencent.tmassistantsdk.downloadclient;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.format.Time;
import com.tencent.tmassistantsdk.f.g;
import com.tencent.tmassistantsdk.f.k;
import java.util.ArrayList;

public class MobileQQCloseServiceReceiver
  extends BroadcastReceiver
{
  private HandlerThread a = new HandlerThread("checkIsAllFinishThread");
  private Handler b = null;
  
  private static String a(Context paramContext)
  {
    ComponentName localComponentName = new ComponentName(paramContext, "com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService");
    Object localObject = null;
    try
    {
      paramContext = paramContext.getPackageManager().getServiceInfo(localComponentName, 0);
      if (paramContext != null) {
        return paramContext.processName;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = localObject;
      }
    }
    return "com.tencent.tmassistantsdk.Service";
  }
  
  private static String a(ArrayList paramArrayList, boolean paramBoolean)
  {
    Time localTime = new Time();
    localTime.setToNow();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("com.tencent.process.exit");
    localStringBuilder.append(localTime.year).append(localTime.month + 1).append(localTime.monthDay);
    localStringBuilder.append(localTime.hour);
    if (paramBoolean)
    {
      localStringBuilder.append(localTime.minute - 1);
      if (paramArrayList != null) {
        break label134;
      }
    }
    label134:
    for (paramArrayList = "null";; paramArrayList = paramArrayList.toString())
    {
      localStringBuilder.append(paramArrayList);
      paramArrayList = g.a(localStringBuilder.toString());
      return g.a(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = 0;
    k.b("MobileQQCloseServiceReceiver", "onReceive broadcase close all service");
    if ((paramContext != null) && (paramIntent != null))
    {
      localObject = paramIntent.getAction();
      if ((localObject != null) && (((String)localObject).equals("com.tencent.process.exit")) && (paramIntent.getExtras() != null)) {}
    }
    else
    {
      return;
      break label97;
    }
    label46:
    Object localObject = paramIntent.getExtras().getStringArrayList("procNameList");
    paramIntent = paramIntent.getExtras().getString("verify");
    int i;
    if ((paramIntent == null) || (paramIntent.length() == 0)) {
      i = 0;
    }
    for (;;)
    {
      int m;
      if ((localObject == null) || (((ArrayList)localObject).size() == 0))
      {
        m = 1;
        label97:
        if ((i == 0) || (m == 0)) {
          break label46;
        }
        if (!this.a.isAlive())
        {
          this.a.start();
          this.b = new Handler(this.a.getLooper());
        }
        if (this.b == null) {
          break label46;
        }
        this.b.post(new b(this, paramContext));
        return;
        if ((!paramIntent.equals(a((ArrayList)localObject, false))) && (!paramIntent.equals(a((ArrayList)localObject, true)))) {
          break label245;
        }
        i = 1;
        continue;
      }
      paramIntent = a(paramContext);
      int j = 0;
      for (;;)
      {
        m = j;
        if (k >= ((ArrayList)localObject).size()) {
          break;
        }
        if (paramIntent.equals(((ArrayList)localObject).get(k))) {
          j = 1;
        }
        k += 1;
      }
      label245:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.MobileQQCloseServiceReceiver
 * JD-Core Version:    0.7.0.1
 */