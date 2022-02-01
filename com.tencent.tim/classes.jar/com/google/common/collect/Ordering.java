package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class Ordering<T>
  implements Comparator<T>
{
  static final int LEFT_IS_GREATER = 1;
  static final int RIGHT_IS_GREATER = -1;
  
  @GwtCompatible(serializable=true)
  public static Ordering<Object> allEqual()
  {
    return AllEqualOrdering.INSTANCE;
  }
  
  public static Ordering<Object> arbitrary()
  {
    return ArbitraryOrderingHolder.ARBITRARY_ORDERING;
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> paramIterable)
  {
    return new CompoundOrdering(paramIterable);
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> explicit(T paramT, T... paramVarArgs)
  {
    return explicit(Lists.asList(paramT, paramVarArgs));
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> explicit(List<T> paramList)
  {
    return new ExplicitOrdering(paramList);
  }
  
  @Deprecated
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> from(Ordering<T> paramOrdering)
  {
    return (Ordering)Preconditions.checkNotNull(paramOrdering);
  }
  
  @GwtCompatible(serializable=true)
  public static <T> Ordering<T> from(Comparator<T> paramComparator)
  {
    if ((paramComparator instanceof Ordering)) {
      return (Ordering)paramComparator;
    }
    return new ComparatorOrdering(paramComparator);
  }
  
  @GwtCompatible(serializable=true)
  public static <C extends Comparable> Ordering<C> natural()
  {
    return NaturalOrdering.INSTANCE;
  }
  
  @GwtCompatible(serializable=true)
  public static Ordering<Object> usingToString()
  {
    return UsingToStringOrdering.INSTANCE;
  }
  
  @Deprecated
  public int binarySearch(List<? extends T> paramList, @Nullable T paramT)
  {
    return Collections.binarySearch(paramList, paramT, this);
  }
  
  @CanIgnoreReturnValue
  public abstract int compare(@Nullable T paramT1, @Nullable T paramT2);
  
  @GwtCompatible(serializable=true)
  public <U extends T> Ordering<U> compound(Comparator<? super U> paramComparator)
  {
    return new CompoundOrdering(this, (Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  public <E extends T> List<E> greatestOf(Iterable<E> paramIterable, int paramInt)
  {
    return reverse().leastOf(paramIterable, paramInt);
  }
  
  public <E extends T> List<E> greatestOf(Iterator<E> paramIterator, int paramInt)
  {
    return reverse().leastOf(paramIterator, paramInt);
  }
  
  @CanIgnoreReturnValue
  public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> paramIterable)
  {
    paramIterable = (Object[])Iterables.toArray(paramIterable);
    int j = paramIterable.length;
    int i = 0;
    while (i < j)
    {
      Preconditions.checkNotNull(paramIterable[i]);
      i += 1;
    }
    Arrays.sort(paramIterable, this);
    return ImmutableList.asImmutableList(paramIterable);
  }
  
  public boolean isOrdered(Iterable<? extends T> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject;
      for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localObject)
      {
        localObject = localIterator.next();
        if (compare(paramIterable, localObject) > 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean isStrictlyOrdered(Iterable<? extends T> paramIterable)
  {
    Iterator localIterator = paramIterable.iterator();
    if (localIterator.hasNext())
    {
      Object localObject;
      for (paramIterable = localIterator.next(); localIterator.hasNext(); paramIterable = localObject)
      {
        localObject = localIterator.next();
        if (compare(paramIterable, localObject) >= 0) {
          return false;
        }
      }
    }
    return true;
  }
  
  public <E extends T> List<E> leastOf(Iterable<E> paramIterable, int paramInt)
  {
    if ((paramIterable instanceof Collection))
    {
      Object localObject = (Collection)paramIterable;
      if (((Collection)localObject).size() <= 2L * paramInt)
      {
        localObject = (Object[])((Collection)localObject).toArray();
        Arrays.sort((Object[])localObject, this);
        paramIterable = (Iterable<E>)localObject;
        if (localObject.length > paramInt) {
          paramIterable = ObjectArrays.arraysCopyOf((Object[])localObject, paramInt);
        }
        return Collections.unmodifiableList(Arrays.asList(paramIterable));
      }
    }
    return leastOf(paramIterable.iterator(), paramInt);
  }
  
  public <E extends T> List<E> leastOf(Iterator<E> paramIterator, int paramInt)
  {
    Preconditions.checkNotNull(paramIterator);
    CollectPreconditions.checkNonnegative(paramInt, "k");
    if ((paramInt == 0) || (!paramIterator.hasNext())) {
      return ImmutableList.of();
    }
    if (paramInt >= 1073741823)
    {
      paramIterator = Lists.newArrayList(paramIterator);
      Collections.sort(paramIterator, this);
      if (paramIterator.size() > paramInt) {
        paramIterator.subList(paramInt, paramIterator.size()).clear();
      }
      paramIterator.trimToSize();
      return Collections.unmodifiableList(paramIterator);
    }
    TopKSelector localTopKSelector = TopKSelector.least(paramInt, this);
    localTopKSelector.offerAll(paramIterator);
    return localTopKSelector.topK();
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<Iterable<S>> lexicographical()
  {
    return new LexicographicalOrdering(this);
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(Iterable<E> paramIterable)
  {
    return max(paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(@Nullable E paramE1, @Nullable E paramE2)
  {
    if (compare(paramE1, paramE2) >= 0) {
      return paramE1;
    }
    return paramE2;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(@Nullable E paramE1, @Nullable E paramE2, @Nullable E paramE3, E... paramVarArgs)
  {
    paramE1 = max(max(paramE1, paramE2), paramE3);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramE1 = max(paramE1, paramVarArgs[i]);
      i += 1;
    }
    return paramE1;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E max(Iterator<E> paramIterator)
  {
    for (Object localObject = paramIterator.next(); paramIterator.hasNext(); localObject = max(localObject, paramIterator.next())) {}
    return localObject;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(Iterable<E> paramIterable)
  {
    return min(paramIterable.iterator());
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(@Nullable E paramE1, @Nullable E paramE2)
  {
    if (compare(paramE1, paramE2) <= 0) {
      return paramE1;
    }
    return paramE2;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(@Nullable E paramE1, @Nullable E paramE2, @Nullable E paramE3, E... paramVarArgs)
  {
    paramE1 = min(min(paramE1, paramE2), paramE3);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramE1 = min(paramE1, paramVarArgs[i]);
      i += 1;
    }
    return paramE1;
  }
  
  @CanIgnoreReturnValue
  public <E extends T> E min(Iterator<E> paramIterator)
  {
    for (Object localObject = paramIterator.next(); paramIterator.hasNext(); localObject = min(localObject, paramIterator.next())) {}
    return localObject;
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<S> nullsFirst()
  {
    return new NullsFirstOrdering(this);
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<S> nullsLast()
  {
    return new NullsLastOrdering(this);
  }
  
  <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys()
  {
    return onResultOf(Maps.keyFunction());
  }
  
  @GwtCompatible(serializable=true)
  public <F> Ordering<F> onResultOf(Function<F, ? extends T> paramFunction)
  {
    return new ByFunctionOrdering(paramFunction, this);
  }
  
  @GwtCompatible(serializable=true)
  public <S extends T> Ordering<S> reverse()
  {
    return new ReverseOrdering(this);
  }
  
  @CanIgnoreReturnValue
  public <E extends T> List<E> sortedCopy(Iterable<E> paramIterable)
  {
    paramIterable = (Object[])Iterables.toArray(paramIterable);
    Arrays.sort(paramIterable, this);
    return Lists.newArrayList(Arrays.asList(paramIterable));
  }
  
  @VisibleForTesting
  static class ArbitraryOrdering
    extends Ordering<Object>
  {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final ConcurrentMap<Object, Integer> uids = Platform.tryWeakKeys(new MapMaker()).makeMap();
    
    private Integer getUid(Object paramObject)
    {
      Integer localInteger2 = (Integer)this.uids.get(paramObject);
      Integer localInteger1 = localInteger2;
      if (localInteger2 == null)
      {
        localInteger2 = Integer.valueOf(this.counter.getAndIncrement());
        localInteger1 = (Integer)this.uids.putIfAbsent(paramObject, localInteger2);
        if (localInteger1 == null) {}
      }
      else
      {
        return localInteger1;
      }
      return localInteger2;
    }
    
    public int compare(Object paramObject1, Object paramObject2)
    {
      int j = -1;
      int i;
      if (paramObject1 == paramObject2) {
        i = 0;
      }
      do
      {
        int k;
        int m;
        do
        {
          do
          {
            return i;
            i = j;
          } while (paramObject1 == null);
          if (paramObject2 == null) {
            return 1;
          }
          k = identityHashCode(paramObject1);
          m = identityHashCode(paramObject2);
          if (k == m) {
            break;
          }
          i = j;
        } while (k < m);
        return 1;
        j = getUid(paramObject1).compareTo(getUid(paramObject2));
        i = j;
      } while (j != 0);
      throw new AssertionError();
    }
    
    int identityHashCode(Object paramObject)
    {
      return System.identityHashCode(paramObject);
    }
    
    public String toString()
    {
      return "Ordering.arbitrary()";
    }
  }
  
  static class ArbitraryOrderingHolder
  {
    static final Ordering<Object> ARBITRARY_ORDERING = new Ordering.ArbitraryOrdering();
  }
  
  @VisibleForTesting
  static class IncomparableValueException
    extends ClassCastException
  {
    private static final long serialVersionUID = 0L;
    final Object value;
    
    IncomparableValueException(Object paramObject)
    {
      super();
      this.value = paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Ordering
 * JD-Core Version:    0.7.0.1
 */