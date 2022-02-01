package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedPreferencesProxyManager
{
  private static final int LOCK_BUCKET_SIZE = 8;
  private static final String LOG_TAG = "SharedPreferencesProxyManager";
  private static volatile SharedPreferencesProxyManager sInstance = null;
  static boolean sIsCrashing = false;
  static boolean sIsDebugVersion = false;
  static ISpLogCallback sLogCallback;
  public static String sSystemSpExceptionMsg = null;
  IAdapter adapter;
  private WeakReference<Context> mBoundContext = null;
  private Map<String, SharedPreferences> mLocalSPs = new ConcurrentHashMap(5);
  private final Object[] mLocksBucket = new Object[8];
  private Map<String, SharedPreferences> mRemoteSPs = new ConcurrentHashMap(5);
  
  public static SharedPreferencesProxyManager getInstance()
  {
    if (sInstance != null) {
      return sInstance;
    }
    try
    {
      if (sInstance == null) {
        sInstance = new SharedPreferencesProxyManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void printLog(boolean paramBoolean, String paramString1, String paramString2, Exception paramException)
  {
    if (sLogCallback != null) {
      sLogCallback.printLog(paramBoolean, paramString1, paramString2, paramException);
    }
  }
  
  private SharedPreferencesProxyManager realInit(Context paramContext, IAdapter paramIAdapter)
  {
    printLog(true, "SpManager", "init " + paramContext, null);
    this.adapter = paramIAdapter;
    if (paramContext == null)
    {
      printLog(true, "SpManager", "init context is null", new RuntimeException());
      if (sIsDebugVersion) {
        throw new RuntimeException("init context is null");
      }
    }
    if ((this.mBoundContext == null) && (paramContext != null))
    {
      Utils.initCurrentProcessName(paramContext);
      this.mBoundContext = new WeakReference(paramContext);
    }
    int i = 0;
    while (i < 8)
    {
      this.mLocksBucket[i] = new Object();
      i += 1;
    }
    return this;
  }
  
  public static void setLogCallback(ISpLogCallback paramISpLogCallback)
  {
    sLogCallback = paramISpLogCallback;
  }
  
  public SharedPreferences getProxy(String paramString, int paramInt)
  {
    return getProxyInner(paramString, paramInt, true);
  }
  
  SharedPreferences getProxyInner(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    Map localMap;
    if (((paramInt & 0x4) == 4) && (!Utils.sIsSameProcessAsCP)) {
      localMap = this.mRemoteSPs;
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)localMap.get(str);
      paramString = localSharedPreferences;
      int i;
      if (localSharedPreferences == null) {
        i = Math.abs(str.hashCode() % 8);
      }
      synchronized (this.mLocksBucket[i])
      {
        localSharedPreferences = (SharedPreferences)localMap.get(str);
        paramString = localSharedPreferences;
        if (localSharedPreferences == null)
        {
          paramString = new SharedPreferencesProxy(this.mBoundContext, str, paramInt, paramBoolean);
          localMap.put(str, paramString);
        }
        return paramString;
        localMap = this.mLocalSPs;
      }
    }
  }
  
  public SharedPreferencesProxyManager init(Context paramContext, IAdapter paramIAdapter)
  {
    try
    {
      paramContext = realInit(paramContext, paramIAdapter);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public SharedPreferencesProxyManager init(Context paramContext, boolean paramBoolean, IAdapter paramIAdapter)
  {
    try
    {
      sIsDebugVersion = paramBoolean;
      paramContext = realInit(paramContext, paramIAdapter);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  boolean isMonitored()
  {
    return sLogCallback != null;
  }
  
  public void onCrashStart()
  {
    sIsCrashing = true;
  }
  
  void onModifySp(String paramString1, String paramString2, Object paramObject)
  {
    if (sLogCallback != null) {
      sLogCallback.onIllegalModify(paramString1, paramString2, paramObject);
    }
  }
  
  public void setCatLogEnabled(boolean paramBoolean) {}
  
  public void setTimeLogEnabled(boolean paramBoolean) {}
  
  public static abstract interface IAdapter
  {
    public abstract SharedPreferences getSystemSharedPreferences(String paramString, int paramInt);
  }
  
  public static abstract interface ISpLogCallback
  {
    public abstract void onIllegalModify(String paramString1, String paramString2, Object paramObject);
    
    public abstract void printLog(boolean paramBoolean, String paramString1, String paramString2, Exception paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager
 * JD-Core Version:    0.7.0.1
 */