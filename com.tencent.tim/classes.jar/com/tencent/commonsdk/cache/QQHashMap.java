package com.tencent.commonsdk.cache;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class QQHashMap<K, V>
  extends HashMap<K, V>
{
  private static IMemoryManager sManager;
  private long creatTime;
  private long firstUseTime;
  private Set<K> getInfos;
  private HashMapInfo mHashMapInfo;
  
  @Deprecated
  public QQHashMap(int paramInt1, int paramInt2)
  {
    super(paramInt2);
    init(paramInt1, paramInt2, 1);
  }
  
  public QQHashMap(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt2);
    init(paramInt1, paramInt2, paramInt3);
  }
  
  private void init(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mHashMapInfo = new HashMapInfo(paramInt1, paramInt2, paramInt3);
    this.getInfos = new HashSet();
    this.creatTime = System.currentTimeMillis();
    if (sManager != null) {
      sManager.addHashMap(this);
    }
  }
  
  public static final void setManager(IMemoryManager paramIMemoryManager)
  {
    if (paramIMemoryManager != null) {
      sManager = paramIMemoryManager;
    }
  }
  
  public void clear()
  {
    super.clear();
    this.mHashMapInfo.mMemorySize = 0;
  }
  
  protected void clearMemory() {}
  
  public boolean containsKey(Object paramObject)
  {
    boolean bool = super.containsKey(paramObject);
    if (!bool)
    {
      paramObject = this.mHashMapInfo;
      paramObject.missCount += 1;
    }
    for (;;)
    {
      if (this.firstUseTime == 0L) {
        this.firstUseTime = System.currentTimeMillis();
      }
      return bool;
      paramObject = this.mHashMapInfo;
      paramObject.hitCount += 1;
    }
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    HashMapInfo localHashMapInfo = this.mHashMapInfo;
    localHashMapInfo.traversalCount += 1;
    return super.entrySet();
  }
  
  public V get(Object paramObject)
  {
    Object localObject = super.get(paramObject);
    if (localObject != null)
    {
      if (paramObject != null) {
        this.getInfos.add(paramObject);
      }
      paramObject = this.mHashMapInfo;
      paramObject.hitCount += 1;
    }
    for (;;)
    {
      if (this.firstUseTime == 0L) {
        this.firstUseTime = System.currentTimeMillis();
      }
      return localObject;
      paramObject = this.mHashMapInfo;
      paramObject.missCount += 1;
    }
  }
  
  public CacheInfo getReportCacheInfo()
  {
    this.mHashMapInfo.size = super.size();
    this.mHashMapInfo.getCount = this.getInfos.size();
    this.mHashMapInfo.lifeTime = (System.currentTimeMillis() - this.creatTime);
    if (this.firstUseTime != 0L) {
      this.mHashMapInfo.gapTime = (this.firstUseTime - this.creatTime);
    }
    return this.mHashMapInfo;
  }
  
  public Set<K> keySet()
  {
    HashMapInfo localHashMapInfo = this.mHashMapInfo;
    localHashMapInfo.traversalCount += 1;
    return super.keySet();
  }
  
  public final void onClearOnLowMemory()
  {
    int i = this.mHashMapInfo.mMemorySize;
    clearMemory();
    int j = this.mHashMapInfo.mMemorySize;
    if (i > j)
    {
      this.mHashMapInfo.mClearSize = (i - j);
      return;
    }
    this.mHashMapInfo.mClearSize = 0;
  }
  
  public V put(K paramK, V paramV)
  {
    Object localObject = super.put(paramK, paramV);
    HashMapInfo localHashMapInfo = this.mHashMapInfo;
    localHashMapInfo.mMemorySize += sizeOf(paramK, paramV);
    if (localObject != null)
    {
      paramV = this.mHashMapInfo;
      paramV.mMemorySize -= sizeOf(paramK, localObject);
    }
    for (;;)
    {
      if (this.firstUseTime == 0L) {
        this.firstUseTime = System.currentTimeMillis();
      }
      return localObject;
      paramK = this.mHashMapInfo;
      paramK.putCount += 1;
    }
  }
  
  public V remove(Object paramObject)
  {
    Object localObject = super.remove(paramObject);
    if (localObject != null)
    {
      HashMapInfo localHashMapInfo = this.mHashMapInfo;
      localHashMapInfo.mMemorySize -= sizeOf(paramObject, localObject);
      paramObject = this.mHashMapInfo;
      paramObject.removeCount += 1;
    }
    return localObject;
  }
  
  protected int sizeOf(K paramK, V paramV)
  {
    return this.mHashMapInfo.mItemSize;
  }
  
  public Collection<V> values()
  {
    HashMapInfo localHashMapInfo = this.mHashMapInfo;
    localHashMapInfo.traversalCount += 1;
    return super.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.commonsdk.cache.QQHashMap
 * JD-Core Version:    0.7.0.1
 */