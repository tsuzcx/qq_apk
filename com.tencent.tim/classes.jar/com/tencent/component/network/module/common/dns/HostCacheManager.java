package com.tencent.component.network.module.common.dns;

import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.base.QDLog;
import java.net.InetAddress;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HostCacheManager
{
  private static HostCacheManager manager = null;
  private final int MAX_CACHE_SIZE = 128;
  private Cache<String, HostEntity> data = new Cache(128);
  
  public static HostCacheManager getInstance()
  {
    try
    {
      if (manager == null) {
        manager = new HostCacheManager();
      }
      HostCacheManager localHostCacheManager = manager;
      return localHostCacheManager;
    }
    finally {}
  }
  
  public void addCache(String paramString, InetAddress[] paramArrayOfInetAddress, long paramLong)
  {
    if (QDLog.isDebugEnable()) {
      QDLog.d("dnstest", "$$$addCache[" + paramString + "]");
    }
    HostEntity localHostEntity = new HostEntity(null);
    localHostEntity.expireTime = paramLong;
    localHostEntity.address = paramArrayOfInetAddress;
    if (NetworkManager.isMobile()) {}
    for (paramArrayOfInetAddress = NetworkManager.getApnValue();; paramArrayOfInetAddress = NetworkManager.getBSSID())
    {
      localHostEntity.networkType = paramArrayOfInetAddress;
      if (this.data.containsKey(paramString)) {
        this.data.remove(paramString);
      }
      this.data.put(paramString, localHostEntity);
      return;
    }
  }
  
  public InetAddress[] getCacheItemByHost(String paramString)
  {
    HostEntity localHostEntity = (HostEntity)this.data.get(paramString);
    if (localHostEntity != null)
    {
      if (!localHostEntity.isValid()) {
        this.data.remove(paramString);
      }
    }
    else {
      return null;
    }
    return localHostEntity.address;
  }
  
  class Cache<K, V>
    extends LinkedHashMap<K, V>
  {
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private static final long serialVersionUID = -6940751117906094384L;
    private int capacity = 5;
    private Object lock = new Object();
    
    public Cache(int paramInt)
    {
      super(0.75F, true);
      if (paramInt > 0) {
        this.capacity = paramInt;
      }
    }
    
    public void clear()
    {
      synchronized (this.lock)
      {
        super.clear();
        return;
      }
    }
    
    public boolean containsKey(Object paramObject)
    {
      synchronized (this.lock)
      {
        boolean bool = super.containsKey(paramObject);
        return bool;
      }
    }
    
    public V get(Object paramObject)
    {
      synchronized (this.lock)
      {
        paramObject = super.get(paramObject);
        return paramObject;
      }
    }
    
    public V put(K paramK, V paramV)
    {
      synchronized (this.lock)
      {
        paramK = super.put(paramK, paramV);
        return paramK;
      }
    }
    
    public void putAll(Map<? extends K, ? extends V> paramMap)
    {
      synchronized (this.lock)
      {
        super.putAll(paramMap);
        return;
      }
    }
    
    public V remove(Object paramObject)
    {
      synchronized (this.lock)
      {
        paramObject = super.remove(paramObject);
        return paramObject;
      }
    }
    
    protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
    {
      return size() > this.capacity;
    }
    
    public int size()
    {
      synchronized (this.lock)
      {
        int i = super.size();
        return i;
      }
    }
  }
  
  class HostEntity
  {
    public InetAddress[] address = null;
    public long expireTime = 0L;
    public String networkType = null;
    
    private HostEntity() {}
    
    public boolean isValid()
    {
      boolean bool;
      if (System.currentTimeMillis() < this.expireTime)
      {
        bool = true;
        if (!bool) {
          return bool;
        }
        if (!NetworkManager.isMobile()) {
          break label38;
        }
      }
      label38:
      for (String str = NetworkManager.getApnValue();; str = NetworkManager.getBSSID())
      {
        if (str != null) {
          break label45;
        }
        return false;
        bool = false;
        break;
      }
      label45:
      return str.equalsIgnoreCase(this.networkType);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.dns.HostCacheManager
 * JD-Core Version:    0.7.0.1
 */