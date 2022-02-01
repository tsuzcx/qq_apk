package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.util.Timer;
import java.util.TimerTask;

public class c
{
  private static volatile c b = null;
  private Timer a = null;
  private Context c = null;
  
  private c(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
    this.a = new Timer(false);
  }
  
  public static c a(Context paramContext)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c(paramContext);
      }
      return b;
    }
    finally {}
  }
  
  public void a()
  {
    if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD)
    {
      long l = StatConfig.getSendPeriodMinutes() * 60 * 1000;
      if (StatConfig.isDebugEnable()) {
        StatCommonHelper.getLogger().i("setupPeriodTimer delay:" + l);
      }
      a(new d(this), l);
    }
  }
  
  public void a(TimerTask paramTimerTask, long paramLong)
  {
    if (this.a != null)
    {
      if (StatConfig.isDebugEnable()) {
        StatCommonHelper.getLogger().i("setupPeriodTimer schedule delay:" + paramLong);
      }
      this.a.schedule(paramTimerTask, paramLong);
    }
    while (!StatConfig.isDebugEnable()) {
      return;
    }
    StatCommonHelper.getLogger().w("setupPeriodTimer schedule timer == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.stat.c
 * JD-Core Version:    0.7.0.1
 */