package com.tencent.kingkong.database;

import android.content.res.Resources;
import android.os.StatFs;
import java.lang.reflect.Method;

public final class SQLiteGlobal
{
  private static final String TAG = "SQLiteGlobal";
  private static boolean forceOptimization = false;
  private static boolean optimization = false;
  private static int sDefaultPageSize;
  private static final Object sLock = new Object();
  
  public static void disableForceOptimization()
  {
    forceOptimization = false;
  }
  
  public static void disableOptimization()
  {
    optimization = false;
  }
  
  public static void enableForceOptimization()
  {
    forceOptimization = true;
  }
  
  public static void enableOptimization()
  {
    optimization = true;
  }
  
  public static String getDefaultJournalMode()
  {
    return getStringAndroidSystemProperties("db_default_journal_mode", "debug.sqlite.journalmode", "MEMORY");
  }
  
  public static int getDefaultPageSize()
  {
    synchronized (sLock)
    {
      if (sDefaultPageSize == 0) {
        sDefaultPageSize = new StatFs("/data").getBlockSize();
      }
      int i = sDefaultPageSize;
      try
      {
        Class localClass = Class.forName("android.os.SystemProperties");
        int j = ((Integer)localClass.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(localClass, new Object[] { "debug.sqlite.pagesize", Integer.valueOf(i) })).intValue();
        i = j;
      }
      catch (Exception localException)
      {
        label87:
        break label87;
      }
      return i;
    }
  }
  
  public static String getDefaultSyncMode()
  {
    if (optimization) {
      return "OFF";
    }
    return getStringAndroidSystemProperties("db_default_sync_mode", "debug.sqlite.syncmode", "OFF");
  }
  
  private static int getIntAndroidSystemProperties(String paramString1, String paramString2, int paramInt)
  {
    int i = Resources.getSystem().getIdentifier(paramString1, "integer", "android");
    if (i != 0) {
      paramInt = Resources.getSystem().getInteger(i);
    }
    for (;;)
    {
      try
      {
        paramString1 = Class.forName("android.os.SystemProperties");
        i = ((Integer)paramString1.getMethod("getInt", new Class[] { String.class, Integer.TYPE }).invoke(paramString1, new Object[] { paramString2, Integer.valueOf(paramInt) })).intValue();
        return i;
      }
      catch (Exception paramString1) {}
    }
    return paramInt;
  }
  
  public static int getJournalSizeLimit()
  {
    return getIntAndroidSystemProperties("db_journal_size_limit", "debug.sqlite.journalsizelimit", 524288);
  }
  
  private static String getStringAndroidSystemProperties(String paramString1, String paramString2, String paramString3)
  {
    if (forceOptimization) {
      return paramString3;
    }
    int i = Resources.getSystem().getIdentifier(paramString1, "string", "android");
    if (i != 0) {}
    for (paramString1 = Resources.getSystem().getString(i);; paramString1 = paramString3)
    {
      try
      {
        paramString3 = Class.forName("android.os.SystemProperties");
        paramString2 = (String)paramString3.getMethod("get", new Class[] { String.class, String.class }).invoke(paramString3, new Object[] { paramString2, paramString1 });
        paramString1 = paramString2;
      }
      catch (Exception paramString2)
      {
        label80:
        break label80;
      }
      return paramString1;
    }
  }
  
  public static int getWALAutoCheckpoint()
  {
    return Math.max(1, getIntAndroidSystemProperties("db_wal_autocheckpoint", "debug.sqlite.wal.autocheckpoint", 100));
  }
  
  public static int getWALConnectionPoolSize()
  {
    return Math.max(2, getIntAndroidSystemProperties("db_connection_pool_size", "debug.sqlite.wal.poolsize", 1));
  }
  
  public static String getWALSyncMode()
  {
    if (optimization) {
      return "OFF";
    }
    return getStringAndroidSystemProperties("db_wal_sync_mode", "debug.sqlite.wal.syncmode", "OFF");
  }
  
  private static native int nativeReleaseMemory();
  
  public static int releaseMemory()
  {
    return nativeReleaseMemory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.kingkong.database.SQLiteGlobal
 * JD-Core Version:    0.7.0.1
 */