package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.export.external.DexLoader;
import java.lang.reflect.Field;

public class CookieSyncManager
{
  private static CookieSyncManager sRef;
  private static android.webkit.CookieSyncManager sysCookieSyncManager;
  
  private CookieSyncManager(Context paramContext)
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core())) {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[] { Context.class }, new Object[] { paramContext });
    }
  }
  
  public static CookieSyncManager createInstance(Context paramContext)
  {
    try
    {
      sysCookieSyncManager = android.webkit.CookieSyncManager.createInstance(paramContext);
      if (sRef == null) {
        sRef = new CookieSyncManager(paramContext.getApplicationContext());
      }
      paramContext = sRef;
      return paramContext;
    }
    finally {}
  }
  
  public static CookieSyncManager getInstance()
  {
    try
    {
      if (sRef == null) {
        throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
      }
    }
    finally {}
    CookieSyncManager localCookieSyncManager = sRef;
    return localCookieSyncManager;
  }
  
  public void startSync()
  {
    Object localObject = SDKEngine.getInstance(false);
    if ((localObject != null) && (((SDKEngine)localObject).isX5Core()))
    {
      ((SDKEngine)localObject).wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_startSync", new Class[0], new Object[0]);
      return;
    }
    sysCookieSyncManager.startSync();
    try
    {
      localObject = Class.forName("android.webkit.WebSyncManager").getDeclaredField("mSyncThread");
      ((Field)localObject).setAccessible(true);
      ((Thread)((Field)localObject).get(sysCookieSyncManager)).setUncaughtExceptionHandler(new SQLiteUncaughtExceptionHandler());
      return;
    }
    catch (Exception localException) {}
  }
  
  public void stopSync()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
      return;
    }
    sysCookieSyncManager.stopSync();
  }
  
  public void sync()
  {
    SDKEngine localSDKEngine = SDKEngine.getInstance(false);
    if ((localSDKEngine != null) && (localSDKEngine.isX5Core()))
    {
      localSDKEngine.wizard().dexLoader().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
      return;
    }
    sysCookieSyncManager.sync();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.CookieSyncManager
 * JD-Core Version:    0.7.0.1
 */