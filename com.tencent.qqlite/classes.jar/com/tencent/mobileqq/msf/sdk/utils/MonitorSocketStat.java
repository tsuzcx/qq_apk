package com.tencent.mobileqq.msf.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.b.c;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.k;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class MonitorSocketStat
  extends Thread
{
  public static byte STATUS = 0;
  public static k dataFlow = new k();
  public static boolean isScreenOff = false;
  private long lastgotStatusTime;
  private BroadcastReceiver mReceiver = new a(null);
  private MsfServiceSdk msfSdk;
  private String processName;
  private boolean running = true;
  
  public MonitorSocketStat()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.mReceiver, localIntentFilter);
  }
  
  private void getnetFlowStatus()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MSF.D.MonitorSocket", 2, "start to get status of Process");
    }
    if (MsfSdkUtils.isTopActivity(BaseApplication.getContext()))
    {
      if (isScreenOff)
      {
        STATUS = 4;
        return;
      }
      STATUS = 1;
      return;
    }
    if (isScreenOff)
    {
      STATUS = 2;
      return;
    }
    if ((!MsfSdkUtils.isTopActivity(BaseApplication.getContext())) && (!isScreenOff))
    {
      STATUS = 3;
      return;
    }
    STATUS = 0;
  }
  
  public void run()
  {
    if (this.processName == null) {
      this.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    }
    boolean bool;
    try
    {
      if ((BaseApplication.getContext().getPackageName() + ":MSF").equals(this.processName))
      {
        for (;;)
        {
          bool = this.running;
          if (!bool) {
            break;
          }
          try
          {
            if (dataFlow == null) {
              dataFlow = new k();
            }
            a locala = (a)dataFlow.k();
            locala.a = this.processName;
            if (locala != null) {
              MsfService.getCore().getNetFlowStore().a(locala);
            }
            if ((dataFlow.size() <= 1) && (System.currentTimeMillis() - this.lastgotStatusTime >= 60000L))
            {
              getnetFlowStatus();
              this.lastgotStatusTime = System.currentTimeMillis();
            }
          }
          catch (Exception localException1)
          {
            QLog.d("MSF.D.MonitorSocket", 1, "" + localException1, localException1);
          }
        }
        return;
      }
    }
    catch (Exception localException2)
    {
      if (dataFlow != null) {
        dataFlow.clear();
      }
      QLog.d("MSF.D.MonitorSocket", 1, "" + localException2, localException2);
    }
    do
    {
      bool = this.running;
    } while (!bool);
    for (;;)
    {
      try
      {
        if (dataFlow == null) {
          dataFlow = new k();
        }
        Object localObject = (a)dataFlow.k();
        if (localObject != null)
        {
          if (this.msfSdk == null) {
            this.msfSdk = MsfServiceSdk.get();
          }
          if (this.msfSdk == null) {
            break label368;
          }
          localObject = this.msfSdk.getDataFlowMsg(this.processName, (a)localObject);
          this.msfSdk.sendMsg((ToServiceMsg)localObject);
        }
        if ((dataFlow.size() > 1) || (System.currentTimeMillis() - this.lastgotStatusTime < 60000L)) {
          break;
        }
        getnetFlowStatus();
        this.lastgotStatusTime = System.currentTimeMillis();
      }
      catch (Exception localException3)
      {
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException3, localException3);
      }
      break;
      label368:
      dataFlow.i(localException3);
    }
  }
  
  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }
  
  private class a
    extends BroadcastReceiver
  {
    private String b = null;
    
    private a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      this.b = paramIntent.getAction();
      if ("android.intent.action.SCREEN_ON".equals(this.b))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MSF.D.MonitorSocket", 2, "screenOn");
        }
        MonitorSocketStat.isScreenOff = false;
        MonitorSocketStat.this.getnetFlowStatus();
      }
      while (!"android.intent.action.SCREEN_OFF".equals(this.b)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "screenOff");
      }
      MonitorSocketStat.isScreenOff = true;
      MonitorSocketStat.this.getnetFlowStatus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat
 * JD-Core Version:    0.7.0.1
 */