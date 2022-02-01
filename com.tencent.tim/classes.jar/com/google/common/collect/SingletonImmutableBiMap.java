package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class SingletonImmutableBiMap<K, V>
  extends ImmutableBiMap<K, V>
{
  @LazyInit
  @RetainedWith
  transient ImmutableBiMap<V, K> inverse;
  final transient K singleKey;
  final transient V singleValue;
  
  SingletonImmutableBiMap(K paramK, V paramV)
  {
    CollectPreconditions.checkEntryNotNull(paramK, paramV);
    this.singleKey = paramK;
    this.singleValue = paramV;
  }
  
  private SingletonImmutableBiMap(K paramK, V paramV, ImmutableBiMap<V, K> paramImmutableBiMap)
  {
    this.singleKey = paramK;
    this.singleValue = paramV;
    this.inverse = paramImmutableBiMap;
  }
  
  public boolean containsKey(@Nullable Object paramObject)
  {
    return this.singleKey.equals(paramObject);
  }
  
  public boolean containsValue(@Nullable Object paramObject)
  {
    return this.singleValue.equals(paramObject);
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    return ImmutableSet.of(Maps.immutableEntry(this.singleKey, this.singleValue));
  }
  
  ImmutableSet<K> createKeySet()
  {
    return ImmutableSet.of(this.singleKey);
  }
  
  public V get(@Nullable Object paramObject)
  {
    if (this.singleKey.equals(paramObject)) {
      return this.singleValue;
    }
    return null;
  }
  
  public ImmutableBiMap<V, K> inverse()
  {
    ImmutableBiMap localImmutableBiMap = this.inverse;
    Object localObject = localImmutableBiMap;
    if (localImmutableBiMap == null)
    {
      localObject = new SingletonImmutableBiMap(this.singleValue, this.singleKey, this);
      this.inverse = ((ImmutableBiMap)localObject);
    }
    return localObject;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SingletonImmutableBiMap
 * JD-Core Version:    0.7.0.1
 */