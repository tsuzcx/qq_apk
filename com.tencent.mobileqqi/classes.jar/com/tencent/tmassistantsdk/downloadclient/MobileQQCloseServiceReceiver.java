package com.tencent.tmassistantsdk.downloadclient;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.text.format.Time;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.j;
import java.util.ArrayList;
import java.util.List;

public class MobileQQCloseServiceReceiver
  extends BroadcastReceiver
{
  private static MobileQQCloseServiceReceiver b = null;
  private boolean a = false;
  private HandlerThread c = new HandlerThread("checkIsAllFinishThread");
  private Handler d = null;
  
  public static MobileQQCloseServiceReceiver a()
  {
    try
    {
      if (b == null) {
        b = new MobileQQCloseServiceReceiver();
      }
      MobileQQCloseServiceReceiver localMobileQQCloseServiceReceiver = b;
      return localMobileQQCloseServiceReceiver;
    }
    finally {}
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
      paramArrayList = f.a(localStringBuilder.toString());
      return f.a(paramArrayList + localStringBuilder.toString());
      localStringBuilder.append(localTime.minute);
      break;
    }
  }
  
  private static String d(Context paramContext)
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
  
  public final void a(Context paramContext)
  {
    if (paramContext != null)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.process.exit");
      paramContext.registerReceiver(this, localIntentFilter);
      this.a = true;
    }
  }
  
  public final void b(Context paramContext)
  {
    if ((paramContext == null) || (b == null)) {}
    while (!this.a) {
      return;
    }
    paramContext.unregisterReceiver(this);
    this.a = false;
  }
  
  public final int c(Context paramContext)
  {
    int i = 0;
    String str = d(paramContext);
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
    int k;
    for (int j = 0; i < paramContext.size(); j = k)
    {
      Object localObject = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
      int m = ((ActivityManager.RunningAppProcessInfo)localObject).pid;
      localObject = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
      k = j;
      if (str.equals(localObject))
      {
        j.b("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;process name: " + (String)localObject + " pid: " + m);
        j.b("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;killProcess pid-->" + m);
        Process.killProcess(m);
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int k = 0;
    j.b("MobileQQCloseServiceReceiver", "onReceive broadcase close all service");
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
        if (!this.c.isAlive())
        {
          this.c.start();
          this.d = new Handler(this.c.getLooper());
        }
        if (this.d == null) {
          break label46;
        }
        this.d.post(new b(this, paramContext));
        return;
        if ((!paramIntent.equals(a((ArrayList)localObject, false))) && (!paramIntent.equals(a((ArrayList)localObject, true)))) {
          break label245;
        }
        i = 1;
        continue;
      }
      paramIntent = d(paramContext);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadclient.MobileQQCloseServiceReceiver
 * JD-Core Version:    0.7.0.1
 */