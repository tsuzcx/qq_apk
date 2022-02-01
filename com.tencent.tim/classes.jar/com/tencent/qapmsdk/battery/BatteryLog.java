package com.tencent.qapmsdk.battery;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.common.thread.ThreadTool;
import com.tencent.qapmsdk.common.util.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BatteryLog
{
  private static final String FORMAT_VERSION = "1.3";
  private static final int MSG_CLEAN_LOG = 1;
  private static final int MSG_INIT_LOG = 0;
  private static final int MSG_WRITE_LOG = 2;
  private static final String TAG = "QAPM_battery_BatteryLog";
  private static String commonFileName;
  private static long logInitTimestamp;
  private static String logPath = FileUtil.getRootPath() + "/battery/";
  private static String processName;
  private static String reportFileName;
  static ThreadLocal<StringBuilder> sSbLocal = new ThreadLocal();
  @Nullable
  private static Handler writeHandler;
  
  static void cleanStorage(long paramLong)
  {
    if (writeHandler != null) {
      writeHandler.obtainMessage(1, Long.valueOf(paramLong)).sendToTarget();
    }
  }
  
  static File getCommonLogFileForReport(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    Object localObject2 = FileUtil.getFiles(logPath, ".*(.log)$");
    if (localObject2 == null) {
      return null;
    }
    Object localObject1 = new ArrayList();
    long l1 = 0L;
    for (;;)
    {
      long l2;
      int i;
      try
      {
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          File localFile = (File)((Iterator)localObject2).next();
          l2 = FileUtil.getLastModifiedTime(localFile);
          if ((l2 == -1L) || (l2 >= paramLong2) || (l2 <= paramLong1) || (localFile.length() <= paramLong3)) {
            break label233;
          }
          i = paramInt - 1;
          if (paramInt <= 0) {
            break label236;
          }
          ((List)localObject1).add(localFile.getAbsolutePath());
          break label236;
        }
        if (((List)localObject1).size() > 0)
        {
          localObject2 = logPath + paramLong2 + ".zip";
          if (!FileUtil.zipFiles((List)localObject1, (String)localObject2)) {
            break label203;
          }
          localObject1 = new File((String)localObject2);
          return localObject1;
        }
      }
      catch (Throwable localThrowable)
      {
        Logger.INSTANCE.exception("QAPM_battery_BatteryLog", localThrowable);
      }
      for (;;)
      {
        return null;
        label203:
        Logger.INSTANCE.e(new String[] { "QAPM_battery_BatteryLog", "zip fail" });
      }
      label233:
      label236:
      do
      {
        paramInt = i;
        break;
        break;
      } while (l2 <= l1);
      paramInt = i;
      l1 = l2;
    }
  }
  
  static List<File> getReportLogFile(long paramLong1, long paramLong2, long paramLong3)
  {
    Object localObject = FileUtil.getFiles(logPath, ".*(.rpt)$");
    if (localObject == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      File localFile = (File)((Iterator)localObject).next();
      long l = FileUtil.getLastModifiedTime(localFile);
      if ((l != -1L) && (l < paramLong2) && (l > paramLong1) && (localFile.length() > paramLong3)) {
        localArrayList.add(localFile);
      }
    }
    return localArrayList;
  }
  
  public static StringBuilder getReuseStringBuilder()
  {
    StringBuilder localStringBuilder = (StringBuilder)sSbLocal.get();
    if (localStringBuilder == null)
    {
      localStringBuilder = new StringBuilder(1024);
      sSbLocal.set(localStringBuilder);
      return localStringBuilder;
    }
    localStringBuilder.delete(0, localStringBuilder.length());
    return localStringBuilder;
  }
  
  private static String getRevision()
  {
    if (("0".equals(BatteryConstants.REVERSION)) || (TextUtils.isEmpty(BaseInfo.userMeta.version))) {
      return BatteryConstants.REVERSION;
    }
    Matcher localMatcher = Pattern.compile("(\\d+\\.\\d+\\.\\d+)[\\.\\d-]*\\.r?(\\d+)").matcher(BaseInfo.userMeta.version);
    int i = 0;
    while (localMatcher.find(i))
    {
      if (i == 2)
      {
        BatteryConstants.REVERSION = localMatcher.group(i);
        return BatteryConstants.REVERSION;
      }
      i += 1;
    }
    return BatteryConstants.REVERSION;
  }
  
  static void init(String paramString, long paramLong)
  {
    processName = paramString;
    logInitTimestamp = paramLong;
    writeHandler = new LogHandler(ThreadManager.getBatteryThreadLooper(), null);
    writeHandler.sendEmptyMessage(0);
  }
  
  static void writeCommonLog(Object... paramVarArgs)
  {
    if (writeHandler != null) {
      writeHandler.obtainMessage(2, 0, 0, paramVarArgs).sendToTarget();
    }
  }
  
  public static void writeCommonLogByMonitor(String... paramVarArgs)
  {
    long l = (System.currentTimeMillis() - BatteryConstants.BATTERY_START_TIME) / 1000L;
    writeCommonLog(new Object[] { BaseInfo.userMeta.uin, Integer.valueOf(BatteryConstants.PROCESS_ID), Long.valueOf(l), paramVarArgs });
  }
  
  static void writeReportLog(Object... paramVarArgs)
  {
    if (writeHandler != null) {
      writeHandler.obtainMessage(2, 1, 0, paramVarArgs).sendToTarget();
    }
  }
  
  public static void writeReportLogByMonitor(String... paramVarArgs)
  {
    writeReportLog(new Object[] { Long.valueOf(System.currentTimeMillis()), paramVarArgs });
  }
  
  static class LogHandler
    extends Handler
  {
    private LogHandler(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(@NonNull Message paramMessage)
    {
      Object localObject1;
      Object localObject2;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        BatteryLog.access$102(BatteryLog.logPath + BatteryLog.processName + "_" + BatteryLog.logInitTimestamp + ".log");
        BatteryLog.access$502(BatteryLog.logPath + BatteryLog.processName + "_" + BatteryLog.logInitTimestamp + ".rpt");
        paramMessage = new File(BatteryLog.logPath);
        localObject1 = new File(BatteryLog.commonFileName);
        localObject2 = new File(BatteryLog.reportFileName);
        try
        {
          paramMessage.mkdirs();
          ((File)localObject1).delete();
          ((File)localObject2).delete();
          BatteryLog.writeCommonLog(new Object[] { "header", BaseInfo.userMeta.version, BatteryLog.access$600(), "pub", BaseInfo.userMeta.uuid, Build.MANUFACTURER, Build.MODEL, Integer.valueOf(Build.VERSION.SDK_INT), Long.valueOf(BatteryLog.logInitTimestamp), "1.3" });
          Logger.INSTANCE.d(new String[] { "QAPM_battery_BatteryLog", "start LogHandler init" });
          return;
        }
        catch (Throwable paramMessage)
        {
          for (;;)
          {
            Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "init LogHandler may be error, ", paramMessage.getMessage() });
          }
        }
      }
      for (;;)
      {
        int j;
        try
        {
          localObject1 = new File(BatteryLog.logPath).listFiles();
          j = localObject1.length;
          i = 0;
          if (i < j)
          {
            localObject2 = localObject1[i];
            try
            {
              long l = FileUtil.getLastModifiedTime((File)localObject2);
              if ((l != -1L) && (l > ((Long)paramMessage.obj).longValue())) {
                break label623;
              }
              ((File)localObject2).delete();
            }
            catch (Throwable localThrowable)
            {
              Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "delete file may be error, file name = ", ((File)localObject2).getName() });
            }
          }
          if (paramMessage.arg1 != 0) {
            break label546;
          }
        }
        catch (Throwable paramMessage)
        {
          Logger.INSTANCE.w(new String[] { "QAPM_battery_BatteryLog", "clean log file may be error" });
          Logger.INSTANCE.d(new String[] { "QAPM_battery_BatteryLog", "start MSG_CLEAN" });
          return;
        }
        localObject1 = BatteryLog.commonFileName;
        localObject2 = ThreadTool.getReuseStringBuilder();
        paramMessage = (Object[])paramMessage.obj;
        int k = paramMessage.length;
        int i = 0;
        for (;;)
        {
          if (i >= k) {
            break label574;
          }
          Object[] arrayOfObject = paramMessage[i];
          if ((arrayOfObject instanceof Object[]))
          {
            arrayOfObject = (Object[])arrayOfObject;
            int m = arrayOfObject.length;
            j = 0;
            while (j < m)
            {
              ((StringBuilder)localObject2).append(arrayOfObject[j]);
              j += 1;
            }
            label546:
            localObject1 = BatteryLog.reportFileName;
            break;
          }
          ((StringBuilder)localObject2).append(arrayOfObject).append("|");
          i += 1;
        }
        label574:
        ((StringBuilder)localObject2).append("\r\n");
        FileUtil.writeFile((String)localObject1, ((StringBuilder)localObject2).toString(), true);
        Logger.INSTANCE.i(new String[] { "QAPM_battery_BatteryLog", " start MSG_WRITE ", ((StringBuilder)localObject2).toString() });
        return;
        label623:
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.battery.BatteryLog
 * JD-Core Version:    0.7.0.1
 */