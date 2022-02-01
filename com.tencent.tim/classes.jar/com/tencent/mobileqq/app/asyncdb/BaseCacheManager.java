package com.tencent.mobileqq.app.asyncdb;

import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class BaseCacheManager
  implements Manager
{
  private static final int COUNT_MANAGER = 4;
  public static final int RECENT_USER_CACHE = 1;
  public static final int ROAM_DATA_CACHE = 2;
  private static final String TAG = "Q.db.Cache";
  public static final int TROOP_STATISTICS_CACHE = 3;
  private IMCoreAppRuntime app;
  private int[] baseCache = new int[0];
  private BaseCache[] cacheArray = new BaseCache[4];
  protected DBDelayManager dbDelayManager;
  private boolean isInit;
  private boolean isLazyInit;
  private int[] lazyBaseCache = new int[0];
  
  public BaseCacheManager(IMCoreAppRuntime paramIMCoreAppRuntime)
  {
    this.app = paramIMCoreAppRuntime;
    this.dbDelayManager = new DBDelayManager(this.app);
  }
  
  private void initCaches(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      long l = System.currentTimeMillis();
      BaseCache localBaseCache = getCache(k);
      if (localBaseCache != null)
      {
        localBaseCache.init();
        if (QLog.isColorLevel()) {
          QLog.d("Q.db.Cache", 2, "cacheManager init cache:" + localBaseCache.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        localBaseCache.notifyObserver(0);
      }
      i += 1;
    }
  }
  
  protected BaseCache createCacheByName(int paramInt)
  {
    return null;
  }
  
  public BaseCache getCache(int paramInt)
  {
    ??? = this.cacheArray[paramInt];
    if (??? == null) {
      synchronized (this.cacheArray)
      {
        BaseCache localBaseCache = this.cacheArray[paramInt];
        if (localBaseCache != null) {
          return localBaseCache;
        }
        long l = System.currentTimeMillis();
        localBaseCache = createCacheByName(paramInt);
        if ((localBaseCache != null) && (this.cacheArray[paramInt] == null)) {
          this.cacheArray[paramInt] = localBaseCache;
        }
        if ((QLog.isColorLevel()) && (localBaseCache != null)) {
          QLog.d("Q.db.Cache", 2, "get cache instance:" + localBaseCache.getClass().getName() + " cost=" + (System.currentTimeMillis() - l));
        }
        return localBaseCache;
      }
    }
    return ???;
  }
  
  public DBDelayManager getDBDelayManager()
  {
    return this.dbDelayManager;
  }
  
  public void init()
  {
    if (this.isInit) {
      return;
    }
    initCaches(this.baseCache);
    this.dbDelayManager.start();
    this.isInit = true;
  }
  
  public void initLazy()
  {
    if (this.isLazyInit) {
      return;
    }
    initCaches(this.lazyBaseCache);
    this.isLazyInit = true;
  }
  
  public void onDestroy()
  {
    for (;;)
    {
      int i;
      synchronized (this.cacheArray)
      {
        BaseCache[] arrayOfBaseCache2 = this.cacheArray;
        int j = arrayOfBaseCache2.length;
        i = 0;
        if (i < j)
        {
          BaseCache localBaseCache = arrayOfBaseCache2[i];
          if (localBaseCache != null) {
            localBaseCache.destroy();
          }
        }
        else
        {
          this.dbDelayManager.onDestroy();
          return;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.BaseCacheManager
 * JD-Core Version:    0.7.0.1
 */