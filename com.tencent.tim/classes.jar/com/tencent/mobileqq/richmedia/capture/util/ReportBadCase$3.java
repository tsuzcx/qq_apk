package com.tencent.mobileqq.richmedia.capture.util;

import alxf;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.shortvideo.dancemachine.BadcaseReportUtils.BadDataFrame;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.TicketManager;

public final class ReportBadCase$3
  implements Runnable
{
  public void run()
  {
    int k = 0;
    if (QLog.isColorLevel()) {
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData begin...");
    }
    BadcaseReportUtils.BadDataFrame[] arrayOfBadDataFrame;
    int i;
    int m;
    String str;
    for (;;)
    {
      synchronized (alxf.access$100())
      {
        j = alxf.access$200().size();
        arrayOfBadDataFrame = new BadcaseReportUtils.BadDataFrame[j];
        i = 0;
        if (i < j)
        {
          arrayOfBadDataFrame[i] = ((BadcaseReportUtils.BadDataFrame)alxf.access$200().get(i));
          i += 1;
          break;
        }
        alxf.access$200().clear();
        if ((arrayOfBadDataFrame == null) || (arrayOfBadDataFrame.length <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData have no data...");
          }
          return;
        }
      }
      ??? = "" + this.b.getCurrentAccountUin();
      m = AppSetting.getAppId();
      if (QLog.isColorLevel()) {
        QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData size=" + localObject1.length);
      }
      str = ((TicketManager)this.b.getManager(2)).getSkey((String)???);
      if (!TextUtils.isEmpty(str)) {
        break label261;
      }
      QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData skey error");
      i = k;
      while (i < localObject1.length)
      {
        ??? = localObject1[i];
        if ((((BadcaseReportUtils.BadDataFrame)???).zipPath != null) && (!"".equals(((BadcaseReportUtils.BadDataFrame)???).zipPath))) {
          aqhq.deleteFile(((BadcaseReportUtils.BadDataFrame)???).zipPath);
        }
        i += 1;
      }
    }
    label261:
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= localObject1.length) {
        break;
      }
      BadcaseReportUtils.BadDataFrame localBadDataFrame = localObject1[j];
      if ((localBadDataFrame.mZipSuccess) && (localBadDataFrame.zipPath != null) && (!"".equals(localBadDataFrame.zipPath))) {}
      try
      {
        alxf.b(localBadDataFrame, alxf.access$400(), m, (String)???, str);
        j += 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BadcaseReportUtils", 2, "BadcaseReportUtils uploadBadCaseData ", localException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.ReportBadCase.3
 * JD-Core Version:    0.7.0.1
 */