package com.tencent.qqmail.monitor;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Debug.MemoryInfo;
import androidx.core.app.NotificationCompat.Builder;
import com.google.common.collect.EvictingQueue;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class QMMemoryMonitor
{
  private static String TAG = "MemoryMonitor";
  private static QMMemoryMonitor instance = null;
  private volatile boolean bIsStart = false;
  private final EvictingQueue<MemInfo> infoQueue = EvictingQueue.create(64);
  private NotificationCompat.Builder mBuilder = null;
  private int mGCTime = 0;
  private WeakReference<GcWatcher> mGcWatcher = new WeakReference(new GcWatcher());
  private final Runnable notifyRunnable = new QMMemoryMonitor.3(this);
  
  private long getmemSelf()
  {
    Object localObject1 = (ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity");
    Object localObject2 = ((ActivityManager)localObject1).getRunningAppProcesses();
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject2).next();
        if (localRunningAppProcessInfo.processName.equals("com.tencent.androidqqmail"))
        {
          localObject1 = ((ActivityManager)localObject1).getProcessMemoryInfo(new int[] { localRunningAppProcessInfo.pid });
          QMApplicationContext.sharedInstance();
          ((ActivityManager)QMApplicationContext.sharedInstance().getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
          Threads.runOnMainThread(new QMMemoryMonitor.2(this, (Debug.MemoryInfo[])localObject1));
        }
      }
    }
    return 0L;
  }
  
  public static QMMemoryMonitor sharedInstance()
  {
    try
    {
      if (instance == null) {
        instance = new QMMemoryMonitor();
      }
      QMMemoryMonitor localQMMemoryMonitor = instance;
      return localQMMemoryMonitor;
    }
    finally {}
  }
  
  private void showTips(String paramString)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    if (this.mBuilder == null) {
      this.mBuilder = new NotificationCompat.Builder(localQMApplicationContext);
    }
    paramString = this.mBuilder.setContentTitle("QQ邮箱内存使用").setContentText(paramString);
    int i;
    if (BrandUtil.isColorfulNotificationIcon()) {
      i = 2130840992;
    }
    for (;;)
    {
      paramString.setSmallIcon(i);
      try
      {
        this.mBuilder.setProgress(0, 0, false);
        label63:
        paramString = new Intent(localQMApplicationContext, localQMApplicationContext.getClass());
        paramString.setFlags(268435456);
        paramString = PendingIntent.getActivity(localQMApplicationContext, 0, paramString, 0);
        paramString = this.mBuilder.setContentIntent(paramString).build();
        paramString.icon = 2130841014;
        QMUIHelper.notifyNotification(29054321, paramString);
        return;
        i = 2130841012;
      }
      catch (NoSuchMethodError paramString)
      {
        break label63;
      }
    }
  }
  
  public EvictingQueue<MemInfo> getInfoQueue()
  {
    return this.infoQueue;
  }
  
  public boolean isStart()
  {
    return this.bIsStart;
  }
  
  public void mark(String paramString)
  {
    Threads.runInBackground(new QMMemoryMonitor.1(this, paramString));
  }
  
  public boolean start()
  {
    if (!this.bIsStart)
    {
      this.bIsStart = true;
      Threads.runInBackground(this.notifyRunnable);
      return true;
    }
    return false;
  }
  
  public void stop()
  {
    this.bIsStart = false;
  }
  
  class GcWatcher
  {
    GcWatcher() {}
    
    protected void finalize()
      throws Throwable
    {
      QMMemoryMonitor.access$008(QMMemoryMonitor.this);
      QMMemoryMonitor.access$102(QMMemoryMonitor.this, new WeakReference(new GcWatcher(QMMemoryMonitor.this)));
      QMLog.log(3, QMMemoryMonitor.TAG, "system gc times : " + QMMemoryMonitor.this.mGCTime);
    }
  }
  
  public static class MemInfo
  {
    public final int dalvikPss;
    public final long freeMemory;
    public final long maxMemory;
    public final String msg;
    public final int nativePss;
    public final long totalMemory;
    public final int totalPss;
    
    public MemInfo(Context paramContext, String paramString)
    {
      Runtime localRuntime = Runtime.getRuntime();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0];
      this.dalvikPss = paramContext.dalvikPss;
      this.nativePss = paramContext.nativePss;
      this.totalPss = paramContext.getTotalPss();
      this.maxMemory = localRuntime.maxMemory();
      this.totalMemory = localRuntime.totalMemory();
      this.freeMemory = localRuntime.freeMemory();
      this.msg = paramString;
    }
    
    public String toString()
    {
      return String.format("%s;dalvikPss[%d];nativePss[%d];totalPss[%d], maxMemory[%d], totalMemory[%d], freeMemory[%d]", new Object[] { this.msg, Integer.valueOf(this.dalvikPss), Integer.valueOf(this.nativePss), Integer.valueOf(this.totalPss), Long.valueOf(this.maxMemory), Long.valueOf(this.totalMemory), Long.valueOf(this.freeMemory) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.monitor.QMMemoryMonitor
 * JD-Core Version:    0.7.0.1
 */