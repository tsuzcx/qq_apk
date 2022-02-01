package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MiniAppReportManager2$1
  implements Runnable
{
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        MiniAppReportManager2.access$002(false);
        long l = System.currentTimeMillis();
        Iterator localIterator = MiniAppReportManager2.launchStateMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (MiniAppReportManager2.AppLaunchState)((Map.Entry)localObject).getValue();
          if ((((MiniAppReportManager2.AppLaunchState)localObject).launchResult == 0) && (l - ((MiniAppReportManager2.AppLaunchState)localObject).activeTime > MiniAppReportManager2.LAUNCH_TIME_OUT)) {
            MiniAppReportManager2.access$100((MiniAppReportManager2.AppLaunchState)localObject);
          }
          if (((MiniAppReportManager2.AppLaunchState)localObject).launchResult == 0) {
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            MiniAppReportManager2.access$200();
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("MiniAppReportManager2", "", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.report.MiniAppReportManager2.1
 * JD-Core Version:    0.7.0.1
 */