package com.google.common.graph;

import java.util.Map;
import javax.annotation.Nullable;

class MapRetrievalCache<K, V>
  extends MapIteratorCache<K, V>
{
  @Nullable
  private transient CacheEntry<K, V> cacheEntry1;
  @Nullable
  private transient CacheEntry<K, V> cacheEntry2;
  
  MapRetrievalCache(Map<K, V> paramMap)
  {
    super(paramMap);
  }
  
  private void addToCache(CacheEntry<K, V> paramCacheEntry)
  {
    this.cacheEntry2 = this.cacheEntry1;
    this.cacheEntry1 = paramCacheEntry;
  }
  
  private void addToCache(K paramK, V paramV)
  {
    addToCache(new CacheEntry(paramK, paramV));
  }
  
  protected void clearCache()
  {
    super.clearCache();
    this.cacheEntry1 = null;
    this.cacheEntry2 = null;
  }
  
  public V get(@Nullable Object paramObject)
  {
    Object localObject1 = getIfCached(paramObject);
    if (localObject1 != null) {}
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = getWithoutCaching(paramObject);
      localObject1 = localObject2;
    } while (localObject2 == null);
    addToCache(paramObject, localObject2);
    return localObject2;
  }
  
  protected V getIfCached(@Nullable Object paramObject)
  {
    Object localObject = super.getIfCached(paramObject);
    if (localObject != null) {
      return localObject;
    }
    localObject = this.cacheEntry1;
    if ((localObject != null) && (((CacheEntry)localObject).key == paramObject)) {
      return ((CacheEntry)localObject).value;
    }
    localObject = this.cacheEntry2;
    if ((localObject != null) && (((CacheEntry)localObject).key == paramObject))
    {
      addToCache((CacheEntry)localObject);
      return ((CacheEntry)localObject).value;
    }
    return null;
  }
  
  static final class CacheEntry<K, V>
  {
    final K key;
    final V value;
    
    CacheEntry(K paramK, V paramV)
    {
      this.key = paramK;
      this.value = paramV;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MapRetrievalCache
 * JD-Core Version:    0.7.0.1
 */