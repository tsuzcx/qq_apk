package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class AbstractMapBasedMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  @GwtIncompatible
  private static final long serialVersionUID = -2250766705698539974L;
  private transient Map<E, Count> backingMap;
  private transient long size;
  
  protected AbstractMapBasedMultiset(Map<E, Count> paramMap)
  {
    this.backingMap = ((Map)Preconditions.checkNotNull(paramMap));
    this.size = super.size();
  }
  
  private static int getAndSet(@Nullable Count paramCount, int paramInt)
  {
    if (paramCount == null) {
      return 0;
    }
    return paramCount.getAndSet(paramInt);
  }
  
  @GwtIncompatible
  private void readObjectNoData()
    throws ObjectStreamException
  {
    throw new InvalidObjectException("Stream data required");
  }
  
  @CanIgnoreReturnValue
  public int add(@Nullable E paramE, int paramInt)
  {
    boolean bool2 = true;
    int i = 0;
    if (paramInt == 0) {
      return count(paramE);
    }
    if (paramInt > 0) {}
    Count localCount;
    for (boolean bool1 = true;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "occurrences cannot be negative: %s", paramInt);
      localCount = (Count)this.backingMap.get(paramE);
      if (localCount != null) {
        break;
      }
      this.backingMap.put(paramE, new Count(paramInt));
      this.size += paramInt;
      return i;
    }
    i = localCount.get();
    long l = i + paramInt;
    if (l <= 2147483647L) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "too many occurrences: %s", l);
      localCount.add(paramInt);
      break;
    }
  }
  
  public void clear()
  {
    Iterator localIterator = this.backingMap.values().iterator();
    while (localIterator.hasNext()) {
      ((Count)localIterator.next()).set(0);
    }
    this.backingMap.clear();
    this.size = 0L;
  }
  
  public int count(@Nullable Object paramObject)
  {
    paramObject = (Count)Maps.safeGet(this.backingMap, paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.get();
  }
  
  int distinctElements()
  {
    return this.backingMap.size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return new AbstractMapBasedMultiset.1(this, this.backingMap.entrySet().iterator());
  }
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    return super.entrySet();
  }
  
  public Iterator<E> iterator()
  {
    return new MapBasedMultisetIterator();
  }
  
  @CanIgnoreReturnValue
  public int remove(@Nullable Object paramObject, int paramInt)
  {
    int i = 0;
    if (paramInt == 0) {
      i = count(paramObject);
    }
    boolean bool;
    Count localCount;
    do
    {
      return i;
      if (paramInt <= 0) {
        break;
      }
      bool = true;
      Preconditions.checkArgument(bool, "occurrences cannot be negative: %s", paramInt);
      localCount = (Count)this.backingMap.get(paramObject);
    } while (localCount == null);
    i = localCount.get();
    if (i > paramInt) {}
    for (;;)
    {
      localCount.add(-paramInt);
      this.size -= paramInt;
      return i;
      bool = false;
      break;
      this.backingMap.remove(paramObject);
      paramInt = i;
    }
  }
  
  void setBackingMap(Map<E, Count> paramMap)
  {
    this.backingMap = paramMap;
  }
  
  @CanIgnoreReturnValue
  public int setCount(@Nullable E paramE, int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "count");
    int i;
    if (paramInt == 0) {
      i = getAndSet((Count)this.backingMap.remove(paramE), paramInt);
    }
    for (;;)
    {
      this.size += paramInt - i;
      return i;
      Count localCount = (Count)this.backingMap.get(paramE);
      i = getAndSet(localCount, paramInt);
      if (localCount == null) {
        this.backingMap.put(paramE, new Count(paramInt));
      }
    }
  }
  
  public int size()
  {
    return Ints.saturatedCast(this.size);
  }
  
  class MapBasedMultisetIterator
    implements Iterator<E>
  {
    boolean canRemove;
    Map.Entry<E, Count> currentEntry;
    final Iterator<Map.Entry<E, Count>> entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
    int occurrencesLeft;
    
    MapBasedMultisetIterator() {}
    
    public boolean hasNext()
    {
      return (this.occurrencesLeft > 0) || (this.entryIterator.hasNext());
    }
    
    public E next()
    {
      if (this.occurrencesLeft == 0)
      {
        this.currentEntry = ((Map.Entry)this.entryIterator.next());
        this.occurrencesLeft = ((Count)this.currentEntry.getValue()).get();
      }
      this.occurrencesLeft -= 1;
      this.canRemove = true;
      return this.currentEntry.getKey();
    }
    
    public void remove()
    {
      CollectPreconditions.checkRemove(this.canRemove);
      if (((Count)this.currentEntry.getValue()).get() <= 0) {
        throw new ConcurrentModificationException();
      }
      if (((Count)this.currentEntry.getValue()).addAndGet(-1) == 0) {
        this.entryIterator.remove();
      }
      AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
      this.canRemove = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractMapBasedMultiset
 * JD-Core Version:    0.7.0.1
 */