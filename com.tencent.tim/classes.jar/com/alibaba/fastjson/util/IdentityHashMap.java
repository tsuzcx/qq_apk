package com.alibaba.fastjson.util;

import java.lang.reflect.Type;

public class IdentityHashMap<V>
{
  private final Entry<V>[] buckets;
  private final int indexMask;
  
  public IdentityHashMap(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.buckets = new Entry[paramInt];
  }
  
  public final V get(Type paramType)
  {
    int i = System.identityHashCode(paramType);
    int j = this.indexMask;
    for (Entry localEntry = this.buckets[(i & j)]; localEntry != null; localEntry = localEntry.next) {
      if (paramType == localEntry.key) {
        return localEntry.value;
      }
    }
    return null;
  }
  
  public boolean put(Type paramType, V paramV)
  {
    int i = System.identityHashCode(paramType);
    int j = i & this.indexMask;
    for (Entry localEntry = this.buckets[j]; localEntry != null; localEntry = localEntry.next) {
      if (paramType == localEntry.key)
      {
        localEntry.value = paramV;
        return true;
      }
    }
    paramType = new Entry(paramType, paramV, i, this.buckets[j]);
    this.buckets[j] = paramType;
    return false;
  }
  
  public static final class Entry<V>
  {
    public final int hashCode;
    public final Type key;
    public final Entry<V> next;
    public V value;
    
    public Entry(Type paramType, V paramV, int paramInt, Entry<V> paramEntry)
    {
      this.key = paramType;
      this.value = paramV;
      this.next = paramEntry;
      this.hashCode = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.util.IdentityHashMap
 * JD-Core Version:    0.7.0.1
 */