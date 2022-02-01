package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class JobReporter
{
  private static final int LEVEL_COUNT = 3;
  private static final int MSG_PUT_INTO_THRED_LIST = 1;
  private static final int MSG_REPORT_THRED_PEAK = 2;
  private static final int MSG_THRED_CREATE_CHECK = 3;
  private static final int REPORT_LEVEL_SEPARATOR = 500;
  private static final int REPORT_THRESHOLD = 200;
  private static final String TAG = "JobReporter";
  private static final long THREAD_COUNT_REPORT_INTERVAL_Debug = 20000L;
  private static final long THREAD_COUNT_REPORT_INTERVAL_Release = 86400000L;
  private static final String ThreadMonitorPeakCount = "thread_monitor_peak_count";
  public static final String ThreadOnCreatedCallBack = "com/tencent/mobileqq/app/JobReporter";
  private static Handler mFileHandler;
  public static ThreadCheck mThreadCheck;
  private static Field nativePeerF = null;
  private static boolean nativePeerGetFailed;
  private static boolean nativePeerReflectFailed = false;
  private static boolean sInited;
  private static long sMonitorStartTime;
  private static Random sRandom = new Random();
  public static AtomicLong sThreadJobReportCountLevelOne;
  public static AtomicLong sThreadJobReportCountLevelThree;
  public static AtomicLong sThreadJobReportCountLevelTwo;
  public static AtomicLong sThreadJobReportLastReportTs;
  public static AtomicLong sThreadJobReportTotalCount;
  private static long sThreadPeakCount = 0L;
  private static List<WeakReference<Thread>> weakThreadList;
  
  static
  {
    sMonitorStartTime = 0L;
    sInited = false;
    weakThreadList = new LinkedList();
    sThreadJobReportLastReportTs = new AtomicLong(0L);
    sThreadJobReportTotalCount = new AtomicLong(0L);
    sThreadJobReportCountLevelOne = new AtomicLong(0L);
    sThreadJobReportCountLevelTwo = new AtomicLong(0L);
    sThreadJobReportCountLevelThree = new AtomicLong(0L);
    mFileHandler = new JobReporter.1(ThreadManagerV2.getFileThreadLooper());
    nativePeerGetFailed = false;
  }
  
  private static int getCurrentThreadCount()
  {
    int k = 0;
    Field localField = getNativePeerField();
    if ((localField == null) || (nativePeerGetFailed))
    {
      weakThreadList.clear();
      return 0;
    }
    int m = weakThreadList.size();
    if (m > 1024)
    {
      ThreadLog.printQLog("JobReporter", "getCurrentThreadCount beyond 1024:" + m);
      if (ThreadManagerV2.sThreadWrapContext != null) {
        ThreadManagerV2.sThreadWrapContext.reportDengTaException("", "ThreadPeakCountOverLimit", true, m, 0L, null, "", false);
      }
      weakThreadList.clear();
      return 0;
    }
    ArrayList localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      if (nativePeerGetFailed)
      {
        weakThreadList.clear();
        return 0;
      }
      WeakReference localWeakReference = (WeakReference)weakThreadList.get(j);
      Thread localThread = (Thread)localWeakReference.get();
      if (localThread != null) {}
      for (;;)
      {
        try
        {
          if (((Long)localField.get(localThread)).longValue() <= 0L)
          {
            localArrayList.add(localWeakReference);
            j += 1;
            break;
          }
          i += 1;
          continue;
          localArrayList.add(localWeakReference);
        }
        catch (Exception localException)
        {
          ThreadLog.printQLog("JobReporter", "getCurrentThreadCoun nativePeer err ", localException);
          nativePeerGetFailed = true;
          weakThreadList.clear();
          return 0;
        }
      }
    }
    m = localArrayList.size();
    j = k;
    while (j < m)
    {
      weakThreadList.remove(localArrayList.get(j));
      j += 1;
    }
    return i;
  }
  
  private static Field getNativePeerField()
  {
    if ((nativePeerF != null) || (nativePeerReflectFailed)) {
      return nativePeerF;
    }
    try
    {
      nativePeerF = Thread.class.getDeclaredField("nativePeer");
      nativePeerF.setAccessible(true);
      return nativePeerF;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      nativePeerF = null;
      nativePeerReflectFailed = true;
    }
    return null;
  }
  
  private static void initThreadPeakCount()
  {
    if ((sInited) || (ThreadManagerV2.sThreadWrapContext == null)) {
      return;
    }
    sThreadPeakCount = ThreadManagerV2.sThreadWrapContext.getMainProccessThreadPeakCounts();
    sMonitorStartTime = ThreadManagerV2.sThreadWrapContext.getMainProccessThreadMonitorTime();
    ThreadLog.printQLog("JobReporter", "initThreadPeakCount sThreadPeakCount " + sThreadPeakCount + " sMonitorStartTime " + sMonitorStartTime);
    sInited = true;
  }
  
  public static void onThreadCreatedCallback(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Thread)))
    {
      Object localObject = mFileHandler.obtainMessage(1);
      ((Message)localObject).obj = paramObject;
      mFileHandler.sendMessage((Message)localObject);
      if (!ThreadSetting.isPublicVersion)
      {
        localObject = (Thread)paramObject;
        paramObject = new CheckParams();
        paramObject.newThreadName = ((Thread)localObject).getName();
        paramObject.ste = Thread.currentThread().getStackTrace();
        localObject = mFileHandler.obtainMessage(3);
        ((Message)localObject).obj = paramObject;
        mFileHandler.sendMessage((Message)localObject);
      }
    }
  }
  
  private static boolean peakCountRamdomReport()
  {
    if (!ThreadSetting.isPublicVersion) {
      return true;
    }
    if (ThreadSetting.isGrayVersion) {
      return ramdomReport(10);
    }
    return ramdomReport(10000);
  }
  
  public static boolean ramdomReport(int paramInt)
  {
    if (!ThreadSetting.isPublicVersion) {}
    do
    {
      return true;
      if (paramInt <= 0) {
        break;
      }
    } while (sRandom.nextInt(paramInt) == 0);
    return false;
    return false;
  }
  
  static void reportJobTime(long paramLong)
  {
    try
    {
      if (ThreadSetting.sProcessId != ThreadSetting.PROCESS_QQ) {
        return;
      }
      sThreadJobReportTotalCount.incrementAndGet();
      if (paramLong <= 200L) {
        break label94;
      }
      switch (Math.min((int)(paramLong / 500L), 2))
      {
      case 0: 
        sThreadJobReportCountLevelOne.incrementAndGet();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      ThreadLog.printQLog("JobReporter", "reportJobTime error!!!  : ", localThrowable);
      return;
    }
    sThreadJobReportCountLevelTwo.incrementAndGet();
    return;
    sThreadJobReportCountLevelThree.incrementAndGet();
    label94:
    return;
  }
  
  public static void reportThreadPeakCount(String paramString)
  {
    Message localMessage = mFileHandler.obtainMessage(2);
    localMessage.obj = paramString;
    mFileHandler.sendMessage(localMessage);
  }
  
  public static class CheckParams
  {
    public String newThreadName = "";
    public StackTraceElement[] ste;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.JobReporter
 * JD-Core Version:    0.7.0.1
 */