package com.tencent.qqmail.utilities.patch;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import moai.patch.log.Log;

final class QMPatchManager$1
  implements Log
{
  public void log(int paramInt1, int paramInt2, String paramString1, long paramLong, String paramString2, int paramInt3)
  {
    QMLog.log(paramInt1, "QMPatchManager", "logId: " + paramInt2 + ", log: " + paramString1 + ", cost: " + paramLong);
    if ((paramInt1 >= 4) && (!QMPatchManager.access$000(paramInt2))) {
      OssHelper.hotfixDetailLog(new Object[] { Integer.valueOf(paramInt2) });
    }
    if ((paramInt2 == 1010) || (paramInt2 == 1011))
    {
      QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createRemoveIntent());
      QMApplicationContext.sharedInstance().startService(QMPatchManagerService.createStopIntent());
    }
    do
    {
      return;
      if (paramInt2 == 2022)
      {
        OssHelper.startupPatchAttachBaseContext(new Object[] { Boolean.valueOf(true), Long.valueOf(paramLong) });
        return;
      }
      if (paramInt2 == 2023)
      {
        OssHelper.startupPatchAttachRealContext(new Object[] { Boolean.valueOf(true), Long.valueOf(paramLong) });
        return;
      }
      if (paramInt2 == 2026)
      {
        OssHelper.startupPatchAttachBaseContext(new Object[] { Boolean.valueOf(false), Long.valueOf(paramLong) });
        return;
      }
      if (paramInt2 == 2027)
      {
        OssHelper.startupPatchAttachRealContext(new Object[] { Boolean.valueOf(false), Long.valueOf(paramLong) });
        return;
      }
    } while (paramInt2 != 1022);
    KvHelper.hotfixResCheckFailed(new double[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.patch.QMPatchManager.1
 * JD-Core Version:    0.7.0.1
 */