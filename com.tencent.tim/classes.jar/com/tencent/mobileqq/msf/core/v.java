package com.tencent.mobileqq.msf.core;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.msf.service.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

class v
  extends Thread
{
  v(MsfCore paramMsfCore, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    this.d.netFlowStore = new e(MsfCore.sCore, BaseApplication.getContext());
    try
    {
      BaseApplication.monitor.start();
      QLog.d("MSF.C.MsfCore", 1, "init netflow monitor cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      if (l.a)
      {
        QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_REPORT_Log do report MSF alive to bigT in msfcore init");
        l.a(null);
      }
      QLog.d("MSF.C.MsfCore", 1, "init BigT Cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      Object localObject;
      if (com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext(), false))
      {
        localObject = com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext());
        this.d.mtaReporter = ((com.tencent.mobileqq.msf.core.c.b)localObject);
      }
      QLog.d("MSF.C.MsfCore", 1, "init mtaSupport=" + com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).isMtaSupported() + " mtaCost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      Properties localProperties;
      if (MsfCore.access$000(this.d))
      {
        localProperties = new Properties();
        localProperties.setProperty("isNewVersion", String.valueOf(this.a));
        localProperties.setProperty("newVersion", String.valueOf(this.b));
        localProperties.setProperty("oldVersion", String.valueOf(this.c));
        if (w.d() == null)
        {
          localObject = "null";
          localProperties.setProperty("imei", (String)localObject);
          com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.EvtTxlibSoExist", localProperties);
        }
      }
      else if (this.d.bLoadUseTxlib)
      {
        localProperties = new Properties();
        localProperties.setProperty("bLoadUseTxlib", String.valueOf(this.d.bLoadUseTxlib));
        localProperties.setProperty("newVersion", String.valueOf(this.b));
        localProperties.setProperty("oldVersion", String.valueOf(this.c));
        if (w.d() != null) {
          break label609;
        }
        localObject = "null";
        localProperties.setProperty("imei", (String)localObject);
        localProperties.setProperty("product", Build.MANUFACTURER + "_" + Build.MODEL);
        localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        localProperties.setProperty("platform", c.c(BaseApplication.getContext()));
        com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.EvtLoadUseTxlib", localProperties);
      }
    }
    catch (Throwable localException1)
    {
      try
      {
        ac.a().a(MsfCore.sCore, true);
        QLog.d("MSF.C.MsfCore", 1, "init wifiScan cost=" + (SystemClock.elapsedRealtime() - l));
        l = SystemClock.elapsedRealtime();
      }
      catch (Exception localException1)
      {
        try
        {
          label609:
          do
          {
            for (;;)
            {
              ac.a(ac.O);
              QLog.d("MSF.C.MsfCore", 1, "MsfCore init health step cost=" + (SystemClock.elapsedRealtime() - l));
              QLog.i("MSF.C.MsfCore", 1, "init quic_enable=" + a.e("quic_enable") + " version=" + QuicWrapper.getQuicResVersion() + " libpath=" + QuicWrapper.getQuicResLoadPath());
              return;
              localThrowable = localThrowable;
              QLog.d("MSF.C.MsfCore", 1, "", localThrowable);
              continue;
              String str = w.d();
              continue;
              str = w.d();
            }
            localException1 = localException1;
          } while (!QLog.isColorLevel());
          QLog.d("MSF.C.MsfCore", 2, localException1.toString(), localException1);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.MsfCore", 2, localException2.toString(), localException2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.v
 * JD-Core Version:    0.7.0.1
 */