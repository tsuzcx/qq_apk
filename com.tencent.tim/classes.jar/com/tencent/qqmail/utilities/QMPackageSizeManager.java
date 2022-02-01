package com.tencent.qqmail.utilities;

import alkx;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.IPackageStatsObserver;
import android.content.pm.IPackageStatsObserver.Stub;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageStats;
import android.os.Build.VERSION;
import android.os.RemoteException;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class QMPackageSizeManager
{
  private static final String KEY_LAST_TIME = "last_time";
  private static final long LIMIT = 432000000L;
  private static final String SP_NAME = "package_size_info";
  private static final String TAG = "QMPackageSizeManager";
  
  public static long[] getAvailableAndTotalSize(String paramString)
  {
    long l3 = 0L;
    int i = Build.VERSION.SDK_INT;
    for (;;)
    {
      try
      {
        paramString = new StatFs(paramString);
        if (i >= 18)
        {
          l2 = paramString.getAvailableBytes();
          l1 = l2;
        }
      }
      catch (Exception paramString)
      {
        long l4;
        l2 = 0L;
      }
      try
      {
        l4 = paramString.getTotalBytes();
        l1 = l4;
        return new long[] { l2, l1 };
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          l2 = l1;
        }
      }
      l1 = paramString.getAvailableBlocks();
      i = paramString.getBlockSize();
      l2 = l1 * i;
      l1 = l2;
      l4 = paramString.getBlockCount();
      l1 = l2;
      i = paramString.getBlockSize();
      l1 = i * l4;
      continue;
      QMLog.log(5, "QMPackageSizeManager", "getAvailableAndTotalSize failed", paramString);
      l1 = l3;
    }
  }
  
  public static void getPackageSize(String paramString, Callback paramCallback)
  {
    int i = Build.VERSION.SDK_INT;
    PackageManager localPackageManager = QMApplicationContext.sharedInstance().getPackageManager();
    if (i >= 17) {}
    try
    {
      PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, Integer.TYPE, IPackageStatsObserver.class }).invoke(localPackageManager, new Object[] { paramString, Integer.valueOf(0), new QMpackageStatsObserver(paramCallback) });
      return;
    }
    catch (Exception paramCallback)
    {
      QMLog.log(5, "QMPackageSizeManager", "getPackageSize, pkg: " + paramString, paramCallback);
    }
    PackageManager.class.getMethod("getPackageSizeInfo", new Class[] { String.class, IPackageStatsObserver.class }).invoke(localPackageManager, new Object[] { paramString, new QMpackageStatsObserver(paramCallback) });
    return;
  }
  
  @SuppressLint({"NewApi"})
  public static long getTotalSize(PackageStats paramPackageStats)
  {
    int i = Build.VERSION.SDK_INT;
    long l2 = paramPackageStats.codeSize;
    if (i >= 14) {}
    for (long l1 = paramPackageStats.externalCodeSize;; l1 = 0L) {
      return l1 + l2 + paramPackageStats.dataSize + paramPackageStats.externalDataSize + paramPackageStats.externalCacheSize + paramPackageStats.externalMediaSize + paramPackageStats.externalObbSize;
    }
  }
  
  private static String kb(long paramLong)
  {
    float f = (float)paramLong / 1024.0F;
    return String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(f) });
  }
  
  private static String mb(long paramLong)
  {
    float f = (float)paramLong / 1024.0F / 1024.0F;
    return String.format(Locale.getDefault(), "%.2f", new Object[] { Float.valueOf(f) });
  }
  
  public static void reportPackageSizeInfo()
  {
    long l = System.currentTimeMillis();
    if (l - SPManager.getSp("package_size_info").getLong("last_time", 0L) <= 432000000L) {
      return;
    }
    SPManager.getEditor("package_size_info").putLong("last_time", l).apply();
    Object localObject = alkx.a(QMApplicationContext.sharedInstance().getPackageManager(), 0);
    if (localObject == null) {}
    for (int i = -1;; i = ((List)localObject).size())
    {
      QMLog.log(4, "QMPackageSizeManager", "reportPackageSizeInfo, totalAppCount: " + i);
      if (i <= 0) {
        break;
      }
      l = SystemClock.elapsedRealtime();
      HashMap localHashMap = new HashMap();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        getPackageSize(((PackageInfo)((Iterator)localObject).next()).packageName, new QMPackageSizeManager.1(localHashMap, i, l));
      }
      break;
    }
  }
  
  public static abstract interface Callback
  {
    public abstract void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean);
  }
  
  static class QMpackageStatsObserver
    extends IPackageStatsObserver.Stub
  {
    private QMPackageSizeManager.Callback mCallback;
    
    public QMpackageStatsObserver(QMPackageSizeManager.Callback paramCallback)
    {
      this.mCallback = paramCallback;
    }
    
    public void onGetStatsCompleted(PackageStats paramPackageStats, boolean paramBoolean)
      throws RemoteException
    {
      Log.v("QMPackageSizeManager", "onGetStatsCompleted, succeeded: " + paramBoolean + ", pStats: " + paramPackageStats);
      if (this.mCallback != null) {
        this.mCallback.onGetStatsCompleted(paramPackageStats, paramBoolean);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMPackageSizeManager
 * JD-Core Version:    0.7.0.1
 */