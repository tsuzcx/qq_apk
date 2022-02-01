package com.tencent.mobileqq.utils;

import acix;
import acmq;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import anmo;
import anpc;
import aqgz;
import aqjc;
import aqlr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.AutomatorFinish;
import com.tencent.mobileqq.statistics.thread.SuspendThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.ServerConfigManager.ConfigType;
import wit;

public final class PerformanceReportUtils$1
  implements Runnable
{
  public PerformanceReportUtils$1(int paramInt, long paramLong, String paramString) {}
  
  public void run()
  {
    Object localObject1 = aqlr.a(ServerConfigManager.ConfigType.common, aqjc.access$000());
    if (QLog.isDevelopLevel()) {
      QLog.d("PerformanceReportUtils", 4, "reportUISwitch openStr ：" + (String)localObject1);
    }
    if ((localObject1 == null) || (!"1".equals(localObject1))) {
      return;
    }
    for (;;)
    {
      try
      {
        HashMap localHashMap = new HashMap();
        Object localObject2;
        String str1;
        long l1;
        if ((this.val$type == 0) || (this.val$type == 1) || (this.val$type == 3000) || (this.val$type == 10))
        {
          if (!QQAppInterface.bIQ) {
            break label997;
          }
          i = 0;
          localHashMap.put("actloginTypt", String.valueOf(i));
          localHashMap.put("param_threadOpId", String.valueOf(acmq.a().AZ()));
          if ((!QQAppInterface.bIQ) && (this.val$type != 10))
          {
            QQAppInterface.bIQ = true;
            localHashMap.put("aio_preloaded", String.valueOf(wit.bND));
          }
          localObject1 = BaseApplicationImpl.getApplication().getRuntime();
          if ((localObject1 != null) && ((localObject1 instanceof QQAppInterface)))
          {
            if (((QQAppInterface)localObject1).a.Ra == 0L) {
              break label1002;
            }
            bool = true;
            localHashMap.put("param_is_logining", String.valueOf(bool));
            if (((QQAppInterface)localObject1).a.abT()) {
              break label1007;
            }
            bool = true;
            localHashMap.put("param_syncing_msg", String.valueOf(bool));
            localHashMap.put("inActionLoginB", String.valueOf(((QQAppInterface)localObject1).a.Bd()));
          }
          localHashMap.put("param_cpu_core_num", String.valueOf(acix.getNumberOfCores()));
          localHashMap.put("param_ram", String.valueOf(aqgz.getSystemTotalMemory()));
          localHashMap.put("suspend_thread_switch", String.valueOf(SuspendThreadManager.dLP));
          if (anmo.cIF)
          {
            localObject2 = "-1";
            str1 = "-1";
            String str2 = "-1";
            String str3 = "-1";
            l1 = System.currentTimeMillis();
            if (AutomatorFinish.Rb != -1L) {
              continue;
            }
            localObject1 = "-1";
            if (anmo.amm != 0L) {
              localObject2 = String.valueOf(l1 - anmo.amm);
            }
            if (anmo.aml != 0L) {
              str1 = String.valueOf(l1 - anmo.aml);
            }
            if (anmo.amo != 0L) {
              str2 = String.valueOf(l1 - anmo.amo);
            }
            if (anmo.amn != 0L) {
              str3 = String.valueOf(l1 - anmo.amn);
            }
            localHashMap.put("perfConfigReportValue", String.valueOf(anmo.dKf));
            localHashMap.put("automatorFinishtime", localObject1);
            localHashMap.put("qZoneInterval", localObject2);
            localHashMap.put("miniInterval", str1);
            localHashMap.put("troopListInterval", str2);
            localHashMap.put("preDownloadInterval", str3);
          }
        }
        localObject1 = null;
        long l2;
        switch (this.val$type)
        {
        case 0: 
          localObject2 = aqjc.A();
          if ((localObject1 == null) || (this.asV <= 0L)) {
            break;
          }
          l2 = ((SharedPreferences)localObject2).getLong((String)localObject1, 0L);
          l1 = aqjc.hN();
          str1 = aqlr.a(ServerConfigManager.ConfigType.common, aqjc.ei());
          if (str1 != null) {
            if (QLog.isDevelopLevel()) {
              QLog.d("PerformanceReportUtils", 4, "reportUISwitch  server time：" + str1);
            }
          }
        case 1: 
        case 3000: 
        case 3: 
        case 4: 
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        case 9: 
        case 10: 
          try
          {
            l1 = Long.valueOf(str1).longValue();
            l1 *= 1000L;
          }
          catch (Exception localException2)
          {
            l1 = aqjc.hN();
            continue;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportUISwitch report_time ：" + l1 + ",lastRp" + l2 + ",aioBusiness=" + aqjc.Cc());
          }
          if ((l2 != 0L) && (SystemClock.uptimeMillis() >= l2) && (SystemClock.uptimeMillis() - l2 < l1)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("PerformanceReportUtils", 4, "reportUISwitch timeConsumed ：" + this.asV + ",aioBusiness=" + aqjc.Cc());
          }
          localHashMap.put("aioBusiness", aqjc.Cc());
          anpc.a(BaseApplication.getContext()).collectPerformance(this.ctT, (String)localObject1, true, this.asV, 0L, localHashMap, aqjc.ej());
          ((SharedPreferences)localObject2).edit().putLong((String)localObject1, SystemClock.uptimeMillis()).commit();
          return;
          localObject1 = String.valueOf(l1 - AutomatorFinish.Rb);
          continue;
          localObject1 = aqjc.access$100();
          continue;
          localObject1 = aqjc.access$200();
          continue;
          localObject1 = aqjc.access$300();
          continue;
          localObject1 = aqjc.access$400();
          continue;
          localObject1 = aqjc.access$500();
          continue;
          localObject1 = aqjc.access$600();
          continue;
          localObject1 = aqjc.access$700();
          continue;
          localObject1 = aqjc.access$800();
          continue;
          localObject1 = aqjc.access$900();
          continue;
          localObject1 = aqjc.access$1000();
          continue;
          localObject1 = aqjc.pe();
          break;
        }
        int i = 1;
      }
      catch (Exception localException1)
      {
        return;
      }
      label997:
      continue;
      label1002:
      boolean bool = false;
      continue;
      label1007:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.PerformanceReportUtils.1
 * JD-Core Version:    0.7.0.1
 */