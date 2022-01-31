package com.qzone.download.strategy;

import android.text.TextUtils;
import com.qzone.common.logging.QDLog;
import com.qzone.download.DownloaderFactory;
import com.qzone.download.uinterface.IDownloadConfig;
import com.qzone.utils.Utils;
import com.qzone.utils.http.HttpUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.apache.http.HttpRequest;

public class ConfigKeepAliveStrategy
  implements KeepAliveStrategy
{
  private static final String CONFIG_SPLIT = ",";
  public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE = KeepAliveStrategy.KeepAlive.DISABLE;
  public static final KeepAliveStrategy.KeepAlive DEFAULT_KEEP_ALIVE_PROXY = KeepAliveStrategy.KeepAlive.DISABLE;
  public static final int DEFAULT_KP_CONFIG = -1;
  private static final String DEFAULT_KP_DOMAIN_CONFIG = "m.qpic.cn,a[0-9].qpic.cn";
  public static final int DEFAULT_KP_PROXY_CONFIG = -1;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_DISABLE = 1;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_ENABLE = 0;
  public static final int PHOTO_DOWNLOAD_KEEP_ALIVE_IGNORE = 2;
  private static final String TAG = "ConfigKeepAliveStrategy";
  private ReadWriteLock RW_LOCK = new ReentrantReadWriteLock();
  private Map<String, Pattern> mDominPatterns = new HashMap();
  private List<String> mKpDomainCacheList = new ArrayList();
  private List<String> mKpDomainRegularList = new ArrayList();
  private String mStrCurrConfig;
  
  public final KeepAliveStrategy.KeepAlive keepAlive(String paramString, HttpRequest paramHttpRequest)
  {
    if (TextUtils.isEmpty(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    if (!supportKeepAlive(paramString)) {
      return KeepAliveStrategy.KeepAlive.DISABLE;
    }
    paramString = DownloaderFactory.getDownloadConfig();
    boolean bool = HttpUtil.containsProxy(paramHttpRequest);
    int i;
    label44:
    int k;
    if (paramString != null)
    {
      i = paramString.photoDownloadKeepAliveConfig();
      k = i;
      if (bool) {
        if (paramString == null) {
          break label115;
        }
      }
    }
    label115:
    for (int j = paramString.photoDownloadKeepAliveProxyConfig();; j = -1)
    {
      k = i;
      if (j != -1) {
        k = j;
      }
      switch (k)
      {
      default: 
        return null;
      case 0: 
        return KeepAliveStrategy.KeepAlive.ENABLE;
        i = -1;
        break label44;
      }
    }
    return KeepAliveStrategy.KeepAlive.DISABLE;
    return KeepAliveStrategy.KeepAlive.IGNORE;
  }
  
  public void setConfig(String paramString)
  {
    if ((paramString == null) || (paramString.equals(this.mStrCurrConfig))) {
      return;
    }
    QDLog.i("ConfigKeepAliveStrategy", "keep alive domain:" + paramString);
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        arrayOfString = paramString.split(",");
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          i = 0;
          if (i < j) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        String[] arrayOfString;
        int i;
        String str;
        localThrowable.printStackTrace();
        continue;
      }
      try
      {
        this.RW_LOCK.writeLock().lock();
        this.mStrCurrConfig = paramString;
        this.mKpDomainRegularList.clear();
        this.mKpDomainRegularList.addAll(localArrayList);
        this.mKpDomainCacheList.clear();
        this.mDominPatterns.clear();
        this.mDominPatterns.putAll(localHashMap);
        return;
      }
      finally
      {
        this.RW_LOCK.writeLock().unlock();
      }
      str = arrayOfString[i];
      if (!TextUtils.isEmpty(str))
      {
        localArrayList.add(str);
        localHashMap.put(str, Pattern.compile(str, 2));
      }
      i += 1;
    }
  }
  
  public final boolean supportKeepAlive(String paramString)
  {
    boolean bool2;
    if (TextUtils.isEmpty(paramString))
    {
      bool2 = false;
      return bool2;
    }
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        this.RW_LOCK.readLock().lock();
        bool2 = this.mKpDomainCacheList.contains(paramString);
        if (bool2) {
          return true;
        }
        localIterator = this.mDominPatterns.entrySet().iterator();
        bool2 = localIterator.hasNext();
        if (!bool2)
        {
          this.RW_LOCK.readLock().unlock();
          bool2 = bool1;
          if (!bool1) {
            break;
          }
        }
      }
      finally
      {
        Iterator localIterator;
        String str;
        this.RW_LOCK.readLock().unlock();
      }
      try
      {
        this.RW_LOCK.writeLock().lock();
        this.mKpDomainCacheList.add(paramString);
        this.RW_LOCK.writeLock().unlock();
        return bool1;
      }
      finally
      {
        this.RW_LOCK.writeLock().unlock();
      }
      str = (String)((Map.Entry)localIterator.next()).getKey();
      bool2 = Utils.match((Pattern)this.mDominPatterns.get(str), paramString);
      if (bool2) {
        bool1 = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.download.strategy.ConfigKeepAliveStrategy
 * JD-Core Version:    0.7.0.1
 */