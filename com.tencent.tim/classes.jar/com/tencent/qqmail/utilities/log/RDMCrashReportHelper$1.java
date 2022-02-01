package com.tencent.qqmail.utilities.log;

import android.util.Log;
import com.google.common.collect.EvictingQueue;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.monitor.QMMemoryMonitor;
import com.tencent.qqmail.monitor.QMMemoryMonitor.MemInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.smtt.sdk.QbSdk;
import java.util.List;
import moai.oss.KvHelper;

final class RDMCrashReportHelper$1
  implements CrashHandleListener
{
  public byte[] getCrashExtraData(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    return null;
  }
  
  public String getCrashExtraMessage(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong)
  {
    int i = 0;
    QMLog.flush();
    paramString1 = new StringBuilder();
    Log.v("mason", "getCrashExtraMessage");
    paramString2 = (QMMemoryMonitor.MemInfo[])QMMemoryMonitor.sharedInstance().getInfoQueue().toArray(new QMMemoryMonitor.MemInfo[0]);
    paramInt = Math.min(4, paramString2.length - 1);
    while (paramInt >= 0)
    {
      paramString1.append(paramString2[paramInt]);
      paramInt -= 1;
    }
    paramString2 = FeedbackManager.getQmLog(true, 20);
    if (paramString2 != null)
    {
      paramInt = 0;
      while (paramInt < paramString2.size())
      {
        paramString1.append((String)paramString2.get(paramInt)).append("\r\n");
        paramInt += 1;
      }
    }
    paramString1.append("---jni begin---\r\n");
    paramString2 = FeedbackManager.getQmLog(false, 20);
    if (paramString2 != null)
    {
      paramInt = 0;
      while (paramInt < paramString2.size())
      {
        paramString1.append((String)paramString2.get(paramInt)).append("\r\n");
        paramInt += 1;
      }
    }
    paramString2 = FileUtil.readFileLastLines(LogPathManager.getInstance().getQMLogTimelineFilePath(), 5, null, false);
    if (paramString2 != null)
    {
      paramString1.append("---timeline begin---\r\n");
      paramInt = i;
      while (paramInt < paramString2.size())
      {
        paramString1.append((String)paramString2.get(paramInt)).append("\r\n");
        paramInt += 1;
      }
    }
    try
    {
      paramString1.append("---tbs version---\r\n");
      paramInt = QbSdk.getTbsVersion(QMApplicationContext.sharedInstance());
      paramString2 = QbSdk.getMiniQBVersion(QMApplicationContext.sharedInstance());
      paramString1.append("tbsVersion:").append(paramInt).append(",miniQBVersion:").append(paramString2).append("\r\n");
      label306:
      return paramString1.toString();
    }
    catch (Throwable paramString2)
    {
      break label306;
    }
  }
  
  public boolean onCrashHandleEnd(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {}
    for (String str = "Native";; str = "Java")
    {
      Log.i("myLog", str + " handle end");
      return true;
    }
  }
  
  public void onCrashHandleStart(boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      KvHelper.nativeCrashByRdm(new double[0]);
      localStringBuilder = new StringBuilder();
      if (!paramBoolean) {
        break label54;
      }
    }
    label54:
    for (String str = "Native";; str = "Java")
    {
      Log.i("myLog", str + " handle start");
      return;
      KvHelper.javaCrashByRdm(new double[0]);
      break;
    }
  }
  
  public boolean onCrashSaving(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt, long paramLong, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.RDMCrashReportHelper.1
 * JD-Core Version:    0.7.0.1
 */