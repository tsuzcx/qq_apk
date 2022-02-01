package com.tencent.mobileqq.msf.sdk.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.LinkedBlockingDeque;

public class MonitorSocketStat
  extends Thread
{
  private static Handler mMonitorSocketHandler;
  private static HandlerThread mMonitorSocketThread;
  static final String tag = "MonitorSocketStat";
  private byte STATUS = 0;
  private final LinkedBlockingDeque dataFlow = new LinkedBlockingDeque();
  private boolean isScreenOff = false;
  private long lastgotStatusTime;
  private BroadcastReceiver mReceiver;
  private String processName;
  private boolean running = true;
  
  public MonitorSocketStat()
  {
    setName("MonitorSocketStat");
    this.mReceiver = new a(null);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.SCREEN_ON");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    BaseApplication.getContext().registerReceiver(this.mReceiver, localIntentFilter);
    mMonitorSocketThread = new HandlerThread("CheckNetFlowStatus");
    mMonitorSocketThread.start();
    mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
  }
  
  private void getnetFlowStatus()
  {
    runOnMonitorSocketThread(new f(this), 0);
  }
  
  public static boolean runOnMonitorSocketThread(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable == null) {
      return false;
    }
    if (mMonitorSocketHandler == null)
    {
      QLog.d("MSF.D.MonitorSocket", 2, "MonitorSocketHandler is null");
      mMonitorSocketThread = new HandlerThread("CheckNetFlowStatus1");
      mMonitorSocketThread.start();
      mMonitorSocketHandler = new Handler(mMonitorSocketThread.getLooper());
    }
    if (paramInt > 0) {
      return mMonitorSocketHandler.postDelayed(paramRunnable, paramInt);
    }
    return mMonitorSocketHandler.post(paramRunnable);
  }
  
  public byte getSTATUS()
  {
    return this.STATUS;
  }
  
  public void insertData(b paramb)
  {
    if (this.running) {}
    try
    {
      this.dataFlow.add(paramb);
      return;
    }
    catch (Throwable paramb)
    {
      do
      {
        this.running = false;
      } while (this.dataFlow == null);
      this.dataFlow.clear();
    }
  }
  
  public void run()
  {
    if (this.processName == null) {
      this.processName = MsfSdkUtils.getProcessName(BaseApplication.getContext());
    }
    for (;;)
    {
      boolean bool;
      try
      {
        if ((BaseApplication.getContext().getPackageName() + ":MSF").equals(this.processName))
        {
          bool = this.running;
          if (bool) {
            try
            {
              b localb1 = (b)this.dataFlow.take();
              localb1.a = this.processName;
              if (localb1 != null) {
                MsfService.getCore().getNetFlowStore().a(localb1);
              }
              if ((this.dataFlow.size() > 1) || (System.currentTimeMillis() - this.lastgotStatusTime < 60000L)) {
                continue;
              }
              getnetFlowStatus();
              this.lastgotStatusTime = System.currentTimeMillis();
            }
            catch (Throwable localThrowable1)
            {
              QLog.d("MSF.D.MonitorSocket", 1, "" + localThrowable1, localThrowable1);
              com.tencent.mobileqq.msf.sdk.report.e.a(localThrowable1);
              this.running = false;
            }
          }
          try
          {
            if (this.dataFlow != null) {
              this.dataFlow.clear();
            }
            return;
          }
          catch (Throwable localThrowable2)
          {
            QLog.d("MSF.D.MonitorSocket", 1, "clear", localThrowable2);
            return;
          }
        }
        bool = this.running;
      }
      catch (Exception localException1)
      {
        if (this.dataFlow != null) {
          this.dataFlow.clear();
        }
        QLog.d("MSF.D.MonitorSocket", 1, "" + localException1, localException1);
        return;
      }
      while (bool) {
        try
        {
          b localb2 = (b)this.dataFlow.take();
          if (localb2 != null)
          {
            ToServiceMsg localToServiceMsg = MsfServiceSdk.get().getDataFlowMsg(this.processName, localb2);
            int i = MsfServiceSdk.get().sendMsg(localToServiceMsg);
            if (i < 0)
            {
              int j = (int)(Math.random() * 5.0D + 3.0D);
              runOnMonitorSocketThread(new e(this, localb2, i), j * 1000);
            }
          }
          if ((this.dataFlow.size() <= 1) && (System.currentTimeMillis() - this.lastgotStatusTime >= 60000L))
          {
            getnetFlowStatus();
            this.lastgotStatusTime = System.currentTimeMillis();
          }
        }
        catch (Exception localException2)
        {
          QLog.d("MSF.D.MonitorSocket", 1, "" + localException2, localException2);
          this.running = false;
        }
      }
    }
  }
  
  public void setProcessName(String paramString)
  {
    this.processName = paramString;
  }
  
  class a
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
        MonitorSocketStat.access$202(MonitorSocketStat.this, false);
        MonitorSocketStat.this.getnetFlowStatus();
      }
      while (!"android.intent.action.SCREEN_OFF".equals(this.b)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("MSF.D.MonitorSocket", 2, "screenOff");
      }
      MonitorSocketStat.access$202(MonitorSocketStat.this, true);
      MonitorSocketStat.this.getnetFlowStatus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat
 * JD-Core Version:    0.7.0.1
 */