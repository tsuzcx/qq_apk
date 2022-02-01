package com.google.common.reflect;

import com.google.common.collect.ForwardingSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MutableTypeToInstanceMap$UnmodifiableEntry$1
  extends ForwardingSet<Map.Entry<K, V>>
{
  MutableTypeToInstanceMap$UnmodifiableEntry$1(Set paramSet) {}
  
  public Set<Map.Entry<K, V>> delegate()
  {
    return this.val$entries;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return MutableTypeToInstanceMap.UnmodifiableEntry.access$000(super.iterator());
  }
  
  public Object[] toArray()
  {
    return standardToArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return standardToArray(paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.reflect.MutableTypeToInstanceMap.UnmodifiableEntry.1
 * JD-Core Version:    0.7.0.1
 */