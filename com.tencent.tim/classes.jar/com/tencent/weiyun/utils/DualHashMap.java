package com.tencent.weiyun.utils;

import java.util.Collection;
import java.util.HashMap;

public class DualHashMap<K, V>
{
  private final HashMap<K, V> key2Value = new HashMap();
  private final HashMap<V, K> value2Key = new HashMap();
  
  public void clear()
  {
    this.key2Value.clear();
    this.value2Key.clear();
  }
  
  public boolean containsKey(K paramK)
  {
    return this.key2Value.containsKey(paramK);
  }
  
  public boolean containsValue(V paramV)
  {
    return this.value2Key.containsKey(paramV);
  }
  
  public V getByKey(K paramK)
  {
    return this.key2Value.get(paramK);
  }
  
  public K getByValue(V paramV)
  {
    return this.value2Key.get(paramV);
  }
  
  public boolean isEmpty()
  {
    return this.key2Value.isEmpty();
  }
  
  public Collection<K> keys()
  {
    return this.value2Key.values();
  }
  
  public void put(K paramK, V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new IllegalArgumentException("The param key and value should be no-null.");
    }
    this.key2Value.put(paramK, paramV);
    this.value2Key.put(paramV, paramK);
  }
  
  public V removeByKey(K paramK)
  {
    paramK = this.key2Value.remove(paramK);
    if (paramK != null) {
      this.value2Key.remove(paramK);
    }
    return paramK;
  }
  
  public K removeByValue(V paramV)
  {
    paramV = this.value2Key.remove(paramV);
    if (paramV != null) {
      this.key2Value.remove(paramV);
    }
    return paramV;
  }
  
  public int size()
  {
    return this.key2Value.size();
  }
  
  public Collection<V> values()
  {
    return this.key2Value.values();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.utils.DualHashMap
 * JD-Core Version:    0.7.0.1
 */