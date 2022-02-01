package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtIncompatible
public final class ConcurrentHashMultiset<E>
  extends AbstractMultiset<E>
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private final transient ConcurrentMap<E, AtomicInteger> countMap;
  
  @VisibleForTesting
  ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> paramConcurrentMap)
  {
    Preconditions.checkArgument(paramConcurrentMap.isEmpty(), "the backing map (%s) must be empty", paramConcurrentMap);
    this.countMap = paramConcurrentMap;
  }
  
  public static <E> ConcurrentHashMultiset<E> create()
  {
    return new ConcurrentHashMultiset(new ConcurrentHashMap());
  }
  
  @Deprecated
  @Beta
  public static <E> ConcurrentHashMultiset<E> create(MapMaker paramMapMaker)
  {
    return create(paramMapMaker.makeMap());
  }
  
  public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    ConcurrentHashMultiset localConcurrentHashMultiset = create();
    Iterables.addAll(localConcurrentHashMultiset, paramIterable);
    return localConcurrentHashMultiset;
  }
  
  @Beta
  public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> paramConcurrentMap)
  {
    return new ConcurrentHashMultiset(paramConcurrentMap);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    paramObjectInputStream = (ConcurrentMap)paramObjectInputStream.readObject();
    FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set(this, paramObjectInputStream);
  }
  
  private List<E> snapshot()
  {
    ArrayList localArrayList = Lists.newArrayListWithExpectedSize(size());
    Iterator localIterator = entrySet().iterator();
    while (localIterator.hasNext())
    {
      Multiset.Entry localEntry = (Multiset.Entry)localIterator.next();
      Object localObject = localEntry.getElement();
      int i = localEntry.getCount();
      while (i > 0)
      {
        localArrayList.add(localObject);
        i -= 1;
      }
    }
    return localArrayList;
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeObject(this.countMap);
  }
  
  @CanIgnoreReturnValue
  public int add(E paramE, int paramInt)
  {
    Preconditions.checkNotNull(paramE);
    if (paramInt == 0) {
      return count(paramE);
    }
    CollectPreconditions.checkPositive(paramInt, "occurences");
    AtomicInteger localAtomicInteger2;
    AtomicInteger localAtomicInteger1;
    do
    {
      localAtomicInteger2 = (AtomicInteger)Maps.safeGet(this.countMap, paramE);
      localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null)
      {
        localAtomicInteger2 = (AtomicInteger)this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
        localAtomicInteger1 = localAtomicInteger2;
        if (localAtomicInteger2 == null) {
          return 0;
        }
      }
      for (;;)
      {
        int i = localAtomicInteger1.get();
        if (i != 0) {
          try
          {
            boolean bool = localAtomicInteger1.compareAndSet(i, IntMath.checkedAdd(i, paramInt));
            if (bool) {
              return i;
            }
          }
          catch (ArithmeticException paramE)
          {
            throw new IllegalArgumentException("Overflow adding " + paramInt + " occurrences to a count of " + i);
          }
        }
      }
      localAtomicInteger2 = new AtomicInteger(paramInt);
    } while ((this.countMap.putIfAbsent(paramE, localAtomicInteger2) != null) && (!this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2)));
    return 0;
  }
  
  public void clear()
  {
    this.countMap.clear();
  }
  
  public int count(@Nullable Object paramObject)
  {
    paramObject = (AtomicInteger)Maps.safeGet(this.countMap, paramObject);
    if (paramObject == null) {
      return 0;
    }
    return paramObject.get();
  }
  
  Set<E> createElementSet()
  {
    return new ConcurrentHashMultiset.1(this, this.countMap.keySet());
  }
  
  public Set<Multiset.Entry<E>> createEntrySet()
  {
    return new EntrySet(null);
  }
  
  int distinctElements()
  {
    return this.countMap.size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return new ConcurrentHashMultiset.3(this, new ConcurrentHashMultiset.2(this));
  }
  
  public boolean isEmpty()
  {
    return this.countMap.isEmpty();
  }
  
  @CanIgnoreReturnValue
  public int remove(@Nullable Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return count(paramObject);
    }
    CollectPreconditions.checkPositive(paramInt, "occurences");
    AtomicInteger localAtomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, paramObject);
    if (localAtomicInteger == null) {
      return 0;
    }
    int i;
    int j;
    do
    {
      i = localAtomicInteger.get();
      if (i == 0) {
        break;
      }
      j = Math.max(0, i - paramInt);
    } while (!localAtomicInteger.compareAndSet(i, j));
    if (j == 0) {
      this.countMap.remove(paramObject, localAtomicInteger);
    }
    return i;
    return 0;
  }
  
  @CanIgnoreReturnValue
  public boolean removeExactly(@Nullable Object paramObject, int paramInt)
  {
    if (paramInt == 0) {
      return true;
    }
    CollectPreconditions.checkPositive(paramInt, "occurences");
    AtomicInteger localAtomicInteger = (AtomicInteger)Maps.safeGet(this.countMap, paramObject);
    if (localAtomicInteger == null) {
      return false;
    }
    int i;
    int j;
    do
    {
      i = localAtomicInteger.get();
      if (i < paramInt) {
        return false;
      }
      j = i - paramInt;
    } while (!localAtomicInteger.compareAndSet(i, j));
    if (j == 0) {
      this.countMap.remove(paramObject, localAtomicInteger);
    }
    return true;
  }
  
  @CanIgnoreReturnValue
  public int setCount(E paramE, int paramInt)
  {
    Preconditions.checkNotNull(paramE);
    CollectPreconditions.checkNonnegative(paramInt, "count");
    AtomicInteger localAtomicInteger2 = (AtomicInteger)Maps.safeGet(this.countMap, paramE);
    AtomicInteger localAtomicInteger1 = localAtomicInteger2;
    if (localAtomicInteger2 == null)
    {
      if (paramInt == 0) {
        return 0;
      }
      localAtomicInteger2 = (AtomicInteger)this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt));
      localAtomicInteger1 = localAtomicInteger2;
      if (localAtomicInteger2 == null) {
        return 0;
      }
    }
    int i;
    do
    {
      i = localAtomicInteger1.get();
      if (i == 0)
      {
        if (paramInt == 0) {
          return 0;
        }
        localAtomicInteger2 = new AtomicInteger(paramInt);
        if ((this.countMap.putIfAbsent(paramE, localAtomicInteger2) != null) && (!this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2))) {
          break;
        }
        return 0;
      }
    } while (!localAtomicInteger1.compareAndSet(i, paramInt));
    if (paramInt == 0) {
      this.countMap.remove(paramE, localAtomicInteger1);
    }
    return i;
  }
  
  @CanIgnoreReturnValue
  public boolean setCount(E paramE, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramE);
    CollectPreconditions.checkNonnegative(paramInt1, "oldCount");
    CollectPreconditions.checkNonnegative(paramInt2, "newCount");
    AtomicInteger localAtomicInteger1 = (AtomicInteger)Maps.safeGet(this.countMap, paramE);
    if (localAtomicInteger1 == null) {
      if (paramInt1 == 0) {}
    }
    int i;
    do
    {
      AtomicInteger localAtomicInteger2;
      do
      {
        do
        {
          return false;
          if (paramInt2 == 0) {
            return true;
          }
          if (this.countMap.putIfAbsent(paramE, new AtomicInteger(paramInt2)) == null) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
          i = localAtomicInteger1.get();
        } while (i != paramInt1);
        if (i != 0) {
          break;
        }
        if (paramInt2 == 0)
        {
          this.countMap.remove(paramE, localAtomicInteger1);
          return true;
        }
        localAtomicInteger2 = new AtomicInteger(paramInt2);
      } while ((this.countMap.putIfAbsent(paramE, localAtomicInteger2) != null) && (!this.countMap.replace(paramE, localAtomicInteger1, localAtomicInteger2)));
      return true;
    } while (!localAtomicInteger1.compareAndSet(i, paramInt2));
    if (paramInt2 == 0) {
      this.countMap.remove(paramE, localAtomicInteger1);
    }
    return true;
  }
  
  public int size()
  {
    Iterator localIterator = this.countMap.values().iterator();
    for (long l = 0L; localIterator.hasNext(); l = ((AtomicInteger)localIterator.next()).get() + l) {}
    return Ints.saturatedCast(l);
  }
  
  public Object[] toArray()
  {
    return snapshot().toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    return snapshot().toArray(paramArrayOfT);
  }
  
  class EntrySet
    extends AbstractMultiset<E>.EntrySet
  {
    private EntrySet()
    {
      super();
    }
    
    private List<Multiset.Entry<E>> snapshot()
    {
      ArrayList localArrayList = Lists.newArrayListWithExpectedSize(size());
      Iterators.addAll(localArrayList, iterator());
      return localArrayList;
    }
    
    ConcurrentHashMultiset<E> multiset()
    {
      return ConcurrentHashMultiset.this;
    }
    
    public Object[] toArray()
    {
      return snapshot().toArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return snapshot().toArray(paramArrayOfT);
    }
  }
  
  static class FieldSettersHolder
  {
    static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ConcurrentHashMultiset
 * JD-Core Version:    0.7.0.1
 */