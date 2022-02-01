package com.tencent.qqmail.utilities;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashSet<E>
  implements Set<E>
{
  private static Object holder = new Object();
  ConcurrentHashMap<E, Object> innerMap = new ConcurrentHashMap(16, 0.9F, 1);
  
  public ConcurrentHashSet() {}
  
  public ConcurrentHashSet(ConcurrentHashSet<E> paramConcurrentHashSet)
  {
    this();
    this.innerMap.putAll(paramConcurrentHashSet.innerMap);
  }
  
  public boolean add(E paramE)
  {
    this.innerMap.put(paramE, holder);
    return true;
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    return this.innerMap.keySet().addAll(paramCollection);
  }
  
  public void clear()
  {
    this.innerMap.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.innerMap.keySet().contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.innerMap.keySet().containsAll(paramCollection);
  }
  
  public boolean isEmpty()
  {
    return this.innerMap.isEmpty();
  }
  
  public Iterator<E> iterator()
  {
    return this.innerMap.keySet().iterator();
  }
  
  public boolean remove(Object paramObject)
  {
    return this.innerMap.keySet().remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.innerMap.keySet().removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.innerMap.keySet().retainAll(paramCollection);
  }
  
  public int size()
  {
    return this.innerMap.keySet().size();
  }
  
  public Object[] toArray()
  {
    return this.innerMap.keySet().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return this.innerMap.keySet().toArray(paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ConcurrentHashSet
 * JD-Core Version:    0.7.0.1
 */