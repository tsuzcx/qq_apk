package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class MapIteratorCache<K, V>
{
  private final Map<K, V> backingMap;
  @Nullable
  private transient Map.Entry<K, V> entrySetCache;
  
  MapIteratorCache(Map<K, V> paramMap)
  {
    this.backingMap = ((Map)Preconditions.checkNotNull(paramMap));
  }
  
  public void clear()
  {
    clearCache();
    this.backingMap.clear();
  }
  
  protected void clearCache()
  {
    this.entrySetCache = null;
  }
  
  public final boolean containsKey(@Nullable Object paramObject)
  {
    return (getIfCached(paramObject) != null) || (this.backingMap.containsKey(paramObject));
  }
  
  public V get(@Nullable Object paramObject)
  {
    Object localObject = getIfCached(paramObject);
    if (localObject != null) {
      return localObject;
    }
    return getWithoutCaching(paramObject);
  }
  
  protected V getIfCached(@Nullable Object paramObject)
  {
    Map.Entry localEntry = this.entrySetCache;
    if ((localEntry != null) && (localEntry.getKey() == paramObject)) {
      return localEntry.getValue();
    }
    return null;
  }
  
  public final V getWithoutCaching(@Nullable Object paramObject)
  {
    return this.backingMap.get(paramObject);
  }
  
  @CanIgnoreReturnValue
  public V put(@Nullable K paramK, @Nullable V paramV)
  {
    clearCache();
    return this.backingMap.put(paramK, paramV);
  }
  
  @CanIgnoreReturnValue
  public V remove(@Nullable Object paramObject)
  {
    clearCache();
    return this.backingMap.remove(paramObject);
  }
  
  public final Set<K> unmodifiableKeySet()
  {
    return new MapIteratorCache.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.graph.MapIteratorCache
 * JD-Core Version:    0.7.0.1
 */