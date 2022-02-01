package com.tencent.mobileqq.statistics;

import android.text.TextUtils;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import oicq.wlogin_sdk.tools.util;

public final class WtloginReporter$1
  implements Runnable
{
  public WtloginReporter$1(String paramString) {}
  
  public void run()
  {
    Object localObject1 = util.get_cost_time(BaseApplicationImpl.getContext());
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      if (QLog.isColorLevel()) {
        QLog.d("WtloginReporter", 2, "costValue is null");
      }
    }
    int i;
    int j;
    label59:
    long l1;
    label391:
    label416:
    do
    {
      return;
      Object localObject2;
      if (Math.random() <= 0.001D)
      {
        i = 1;
        localObject1 = ((String)localObject1).split(";");
        if (localObject1 == null) {
          break label416;
        }
        j = 0;
        if (j >= localObject1.length) {
          break label416;
        }
        localObject2 = localObject1[j].split("\\|");
        if ((localObject2 == null) || (localObject2.length != 5)) {
          break label391;
        }
      }
      for (;;)
      {
        try
        {
          l1 = Long.parseLong(localObject2[0]);
          int k = Integer.parseInt(localObject2[1]);
          long l2 = Long.parseLong(localObject2[2]);
          long l3 = Long.parseLong(localObject2[3]);
          long l4 = Long.parseLong(localObject2[4]);
          if (QLog.isColorLevel()) {
            QLog.d("WtloginReporter", 2, new Object[] { "recordTime:", Long.valueOf(l1), " fromType:", Integer.valueOf(k), " costTime1:", Long.valueOf(l2), " costTime2:", Long.valueOf(l3), " costTime3:", Long.valueOf(l4) });
          }
          if (i != 0)
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("uin", this.val$uin);
            ((HashMap)localObject2).put("recordTime", String.valueOf(l1));
            ((HashMap)localObject2).put("fromType", String.valueOf(k));
            ((HashMap)localObject2).put("costTime1", String.valueOf(l2));
            ((HashMap)localObject2).put("costTime2", String.valueOf(l3));
            ((HashMap)localObject2).put("costTime3", String.valueOf(l4));
            if (l2 > 1000L) {
              ((HashMap)localObject2).put("warnCost", "1");
            }
            anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.val$uin, "wtloginCost", true, 0L, 0L, (HashMap)localObject2, "");
            if (QLog.isColorLevel()) {
              QLog.d("WtloginReporter", 2, "wtlogin report cost");
            }
          }
        }
        catch (Throwable localThrowable1)
        {
          QLog.e("WtloginReporter", 1, localThrowable1, new Object[0]);
          continue;
        }
        j += 1;
        break label59;
        i = 0;
        break;
        QLog.e("WtloginReporter", 1, new Object[] { "error costTimes:", localObject1[j] });
      }
      util.save_cost_time(BaseApplicationImpl.getContext(), "");
      localObject1 = util.get_cost_trace(BaseApplicationImpl.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WtloginReporter", 2, "backTraceValue is null");
    return;
    localObject1 = ((String)localObject1).split("\\|");
    if (localObject1 != null)
    {
      j = 0;
      if (j < localObject1.length)
      {
        Object localObject3 = localObject1[j].split(",");
        if ((localObject3 != null) && (localObject3.length == 2)) {}
        for (;;)
        {
          try
          {
            l1 = Long.parseLong(localObject3[0]);
            localObject3 = localObject3[1];
            if (QLog.isColorLevel()) {
              QLog.d("WtloginReporter", 2, new Object[] { "recordTime:", Long.valueOf(l1), " backTrace:", localObject3 });
            }
            if (i != 0)
            {
              HashMap localHashMap = new HashMap();
              localHashMap.put("uin", this.val$uin);
              localHashMap.put("recordTime", String.valueOf(l1));
              localHashMap.put("backTrace", localObject3);
              anpc.a(BaseApplicationImpl.getContext()).collectPerformance(this.val$uin, "wtloginCostTrace", true, 0L, 0L, localHashMap, "");
              if (QLog.isColorLevel()) {
                QLog.d("WtloginReporter", 2, "wtlogin report cost back trace");
              }
            }
          }
          catch (Throwable localThrowable2)
          {
            QLog.e("WtloginReporter", 1, localThrowable2, new Object[0]);
            continue;
          }
          j += 1;
          break;
          QLog.e("WtloginReporter", 1, new Object[] { "error traceItems:", localObject1[j] });
        }
      }
    }
    util.save_cost_trace(BaseApplicationImpl.getContext(), "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.WtloginReporter.1
 * JD-Core Version:    0.7.0.1
 */