package com.tencent.mobileqq.location.util;

import aiur;
import android.os.Handler;
import aqmj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public final class LocationReportUtil$1
  implements Runnable
{
  public LocationReportUtil$1(boolean paramBoolean) {}
  
  public void run()
  {
    if (aiur.access$000())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationReportUtil", 2, new Object[] { "run: invoked. need stop report. ", " reporting: ", Boolean.valueOf(this.clR) });
      }
      return;
    }
    long l = System.currentTimeMillis() / 1000L - aiur.access$100();
    aqmj.a(BaseApplicationImpl.getApplication(), this.clR, (int)l);
    if (QLog.isColorLevel()) {
      QLog.d("LocationReportUtil", 2, new Object[] { "updateLocationBgReport.run: invoked. ", " sProcBgAliveTimeSecond: ", Long.valueOf(l), " reporting: ", Boolean.valueOf(this.clR) });
    }
    aiur.access$200().postDelayed(this, 30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.util.LocationReportUtil.1
 * JD-Core Version:    0.7.0.1
 */