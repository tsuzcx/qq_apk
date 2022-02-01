package com.tencent.mobileqq.activity.leba;

import altq;
import com.tencent.qphone.base.util.QLog;
import zjq;

public class LebaShowListManager$1
  implements Runnable
{
  public LebaShowListManager$1(zjq paramzjq, altq paramaltq, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        altq localaltq = this.b;
        i = (int)this.Y;
        boolean bool = this.brt;
        if (this.Lh != -9223372036854775808L) {
          continue;
        }
        l = this.Li;
        i = localaltq.a(i, bool, l);
      }
      catch (Exception localException)
      {
        long l;
        int j = -2;
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.lebatab.mgr", 2, localException.toString());
        i = j;
        continue;
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.lebatab.mgr", 4, "updateAppSetting, result = " + i);
      }
      return;
      l = this.Lh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.leba.LebaShowListManager.1
 * JD-Core Version:    0.7.0.1
 */