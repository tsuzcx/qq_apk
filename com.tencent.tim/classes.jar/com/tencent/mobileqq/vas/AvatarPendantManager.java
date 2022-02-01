package com.tencent.mobileqq.vas;

import acbn;
import android.content.Context;
import aqpf;
import aqph;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;

public class AvatarPendantManager
  implements Manager
{
  public static volatile boolean cVw;
  public static volatile boolean cVx;
  public static int ebf;
  List<aqph> IV = new ArrayList();
  List<aqpf> IW;
  protected PendantInfoLruCache a;
  public long atx = -1L;
  public boolean cVv;
  protected AppInterface mApp;
  
  public AvatarPendantManager(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
    this.a = new PendantInfoLruCache(10);
    this.cVv = false;
  }
  
  public File K()
  {
    File localFile = new File(this.mApp.getApp().getApplicationContext().getFilesDir(), "pendant_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File L()
  {
    File localFile = new File(acbn.bmK);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public PendantInfo a(long paramLong)
  {
    synchronized (this.a)
    {
      PendantInfo localPendantInfo2 = (PendantInfo)this.a.get(Long.valueOf(paramLong));
      if (localPendantInfo2 != null)
      {
        localPendantInfo1 = localPendantInfo2;
        if (QLog.isColorLevel())
        {
          QLog.d("AvatarPendantManager", 2, "getPendantInfo pendantId=" + paramLong + " from cache");
          localPendantInfo1 = localPendantInfo2;
        }
        localPendantInfo1.setPause(this.cVv);
        return localPendantInfo1;
      }
      PendantInfo localPendantInfo1 = new PendantInfo(paramLong);
      this.a.put(Long.valueOf(paramLong), localPendantInfo1);
    }
  }
  
  public void clear()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.values().iterator();
      if (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).clearCache();
      }
    }
    this.a.clear();
  }
  
  public void eeN()
  {
    this.cVv = true;
    synchronized (this.a)
    {
      Iterator localIterator = this.a.values().iterator();
      if (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).setPause(true);
      }
    }
  }
  
  public void eeO()
  {
    this.cVv = false;
    synchronized (this.a)
    {
      Iterator localIterator = this.a.values().iterator();
      if (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).setPause(false);
      }
    }
  }
  
  public List<aqph> gI()
  {
    return this.IV;
  }
  
  public List<aqpf> gJ()
  {
    return this.IW;
  }
  
  public void na(List<aqpf> paramList)
  {
    this.IW = paramList;
  }
  
  public void onDestroy()
  {
    synchronized (this.a)
    {
      this.a.clear();
      return;
    }
  }
  
  public static class LruLinkedHashMap<K, V>
    extends LinkedHashMap<K, V>
  {
    private static final long serialVersionUID = 1L;
    private final Lock lock = new ReentrantLock();
    protected final int maxCapacity;
    
    public LruLinkedHashMap(int paramInt)
    {
      super(0.75F, true);
      this.maxCapacity = paramInt;
    }
    
    public V get(Object paramObject)
    {
      try
      {
        this.lock.lock();
        paramObject = super.get(paramObject);
        return paramObject;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    public V put(K paramK, V paramV)
    {
      try
      {
        this.lock.lock();
        paramK = super.put(paramK, paramV);
        return paramK;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > this.maxCapacity;
    }
  }
  
  class PendantInfoLruCache
    extends AvatarPendantManager.LruLinkedHashMap<Long, PendantInfo>
  {
    private static final long serialVersionUID = 1L;
    
    public PendantInfoLruCache(int paramInt)
    {
      super();
    }
    
    public void clear()
    {
      Iterator localIterator = values().iterator();
      while (localIterator.hasNext()) {
        ((PendantInfo)localIterator.next()).setPause(true);
      }
      super.clear();
    }
    
    protected boolean removeEldestEntry(Map.Entry<Long, PendantInfo> paramEntry)
    {
      if (size() > this.maxCapacity)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AvatarPendantManager", 2, "entryRemoved key=" + paramEntry.getKey());
        }
        ((PendantInfo)paramEntry.getValue()).setPause(true);
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.AvatarPendantManager
 * JD-Core Version:    0.7.0.1
 */