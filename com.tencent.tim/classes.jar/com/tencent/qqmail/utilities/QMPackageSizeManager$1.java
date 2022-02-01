package com.tencent.qqmail.utilities;

import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.SystemClock;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import moai.oss.OssHelper;

final class QMPackageSizeManager$1
  implements QMPackageSizeManager.Callback
{
  QMPackageSizeManager$1(Map paramMap, int paramInt, long paramLong) {}
  
  public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      synchronized (this.val$map)
      {
        this.val$map.put(paramPackageStats, Long.valueOf(QMPackageSizeManager.getTotalSize(paramPackageStats)));
        if (this.val$totalAppCount == this.val$map.size())
        {
          paramPackageStats = new ArrayList(this.val$map.entrySet());
          Collections.sort(paramPackageStats, new QMPackageSizeManager.1.1(this));
          i = 0;
          if (i < this.val$totalAppCount)
          {
            Object localObject = (Map.Entry)paramPackageStats.get(i);
            PackageStats localPackageStats = (PackageStats)((Map.Entry)localObject).getKey();
            if (!QMApplicationContext.sharedInstance().getPackageName().equals(localPackageStats.packageName)) {
              break label451;
            }
            int j = Build.VERSION.SDK_INT;
            long l = ((Long)((Map.Entry)localObject).getValue()).longValue();
            localObject = QMPackageSizeManager.getAvailableAndTotalSize(Environment.getExternalStorageDirectory().getPath());
            long[] arrayOfLong = QMPackageSizeManager.getAvailableAndTotalSize(Environment.getDataDirectory().getPath());
            if (j < 14) {
              break label445;
            }
            paramPackageStats = QMPackageSizeManager.access$000(localPackageStats.externalCodeSize);
            OssHelper.packageSize(new Object[] { String.valueOf(i + 1) + "/" + this.val$totalAppCount, QMPackageSizeManager.access$000(l), QMPackageSizeManager.access$000(localPackageStats.codeSize), paramPackageStats, QMPackageSizeManager.access$000(localPackageStats.dataSize), QMPackageSizeManager.access$100(localPackageStats.externalDataSize), QMPackageSizeManager.access$100(localPackageStats.cacheSize), QMPackageSizeManager.access$100(localPackageStats.externalCacheSize), QMPackageSizeManager.access$100(localPackageStats.externalMediaSize), QMPackageSizeManager.access$100(localPackageStats.externalObbSize), QMPackageSizeManager.access$000(arrayOfLong[0]) + "/" + QMPackageSizeManager.access$000(arrayOfLong[1]), QMPackageSizeManager.access$000(localObject[0]) + "/" + QMPackageSizeManager.access$000(localObject[1]) });
            QMLog.log(4, "QMPackageSizeManager", "reportPackageSizeInfo done, elapse: " + (SystemClock.elapsedRealtime() - this.val$sTime) + "ms");
            return;
          }
        }
        return;
      }
      label445:
      paramPackageStats = "0";
      continue;
      label451:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMPackageSizeManager.1
 * JD-Core Version:    0.7.0.1
 */