package com.tencent.tbs.one.impl.common.statistic;

import android.content.Context;
import com.tencent.tbs.logger.TBSLogger;

final class StatisticReport$1
  implements Runnable
{
  StatisticReport$1(Context paramContext) {}
  
  public final void run()
  {
    TBSLogger.getLogPath();
    new a(TBSLogger.getLogPath()).a(new StatisticReport.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticReport.1
 * JD-Core Version:    0.7.0.1
 */