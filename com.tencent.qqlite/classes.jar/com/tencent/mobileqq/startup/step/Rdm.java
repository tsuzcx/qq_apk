package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import eem;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class Rdm
  extends Step
{
  private static final ScheduledThreadPoolExecutor a = new ScheduledThreadPoolExecutor(3, new eem());
  
  protected boolean a()
  {
    String str2 = BaseApplicationImpl.processName;
    if (!str2.endsWith(":MSF")) {}
    for (;;)
    {
      try
      {
        Object localObject = BaseApplicationImpl.a.getAllAccounts();
        if (localObject == null) {
          break label126;
        }
        localObject = (SimpleAccount)((List)localObject).get(0);
        if (localObject != null)
        {
          localObject = ((SimpleAccount)localObject).getUin();
          if ((str2.equals("com.tencent.qqlite")) || (str2.endsWith(":web"))) {
            Thread.setDefaultUncaughtExceptionHandler(new ReportLog());
          }
          CrashReport.setThreadPoolService(a);
          StatisticCollector.a(BaseApplicationImpl.a).b((String)localObject);
          if (str2.endsWith(":openSdk")) {
            return true;
          }
          StatisticCollector.a(BaseApplicationImpl.a).a((String)localObject);
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return true;
      }
      String str1 = "10000";
      continue;
      return true;
      label126:
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm
 * JD-Core Version:    0.7.0.1
 */