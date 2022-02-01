package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class RegularContiguousSet<C extends Comparable>
  extends ContiguousSet<C>
{
  private static final long serialVersionUID = 0L;
  private final Range<C> range;
  
  RegularContiguousSet(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain)
  {
    super(paramDiscreteDomain);
    this.range = paramRange;
  }
  
  private static boolean equalsOrThrow(Comparable<?> paramComparable1, @Nullable Comparable<?> paramComparable2)
  {
    return (paramComparable2 != null) && (Range.compareOrThrow(paramComparable1, paramComparable2) == 0);
  }
  
  private ContiguousSet<C> intersectionInCurrentDomain(Range<C> paramRange)
  {
    if (this.range.isConnected(paramRange)) {
      return ContiguousSet.create(this.range.intersection(paramRange), this.domain);
    }
    return new EmptyContiguousSet(this.domain);
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    try
    {
      boolean bool = this.range.contains((Comparable)paramObject);
      return bool;
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return Collections2.containsAllImpl(this, paramCollection);
  }
  
  @GwtIncompatible
  public UnmodifiableIterator<C> descendingIterator()
  {
    return new RegularContiguousSet.2(this, last());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof RegularContiguousSet))
    {
      RegularContiguousSet localRegularContiguousSet = (RegularContiguousSet)paramObject;
      if (this.domain.equals(localRegularContiguousSet.domain))
      {
        if ((first().equals(localRegularContiguousSet.first())) && (last().equals(localRegularContiguousSet.last()))) {}
        for (boolean bool = true;; bool = false) {
          return bool;
        }
      }
    }
    return super.equals(paramObject);
  }
  
  public C first()
  {
    return this.range.lowerBound.leastValueAbove(this.domain);
  }
  
  public int hashCode()
  {
    return Sets.hashCodeImpl(this);
  }
  
  ContiguousSet<C> headSetImpl(C paramC, boolean paramBoolean)
  {
    return intersectionInCurrentDomain(Range.upTo(paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  @GwtIncompatible
  int indexOf(Object paramObject)
  {
    if (contains(paramObject)) {
      return (int)this.domain.distance(first(), (Comparable)paramObject);
    }
    return -1;
  }
  
  public ContiguousSet<C> intersection(ContiguousSet<C> paramContiguousSet)
  {
    Preconditions.checkNotNull(paramContiguousSet);
    Preconditions.checkArgument(this.domain.equals(paramContiguousSet.domain));
    if (paramContiguousSet.isEmpty()) {
      return paramContiguousSet;
    }
    Comparable localComparable = (Comparable)Ordering.natural().max(first(), paramContiguousSet.first());
    paramContiguousSet = (Comparable)Ordering.natural().min(last(), paramContiguousSet.last());
    if (localComparable.compareTo(paramContiguousSet) <= 0) {}
    for (paramContiguousSet = ContiguousSet.create(Range.closed(localComparable, paramContiguousSet), this.domain);; paramContiguousSet = new EmptyContiguousSet(this.domain)) {
      return paramContiguousSet;
    }
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public UnmodifiableIterator<C> iterator()
  {
    return new RegularContiguousSet.1(this, first());
  }
  
  public C last()
  {
    return this.range.upperBound.greatestValueBelow(this.domain);
  }
  
  public Range<C> range()
  {
    return range(BoundType.CLOSED, BoundType.CLOSED);
  }
  
  public Range<C> range(BoundType paramBoundType1, BoundType paramBoundType2)
  {
    return Range.create(this.range.lowerBound.withLowerBoundType(paramBoundType1, this.domain), this.range.upperBound.withUpperBoundType(paramBoundType2, this.domain));
  }
  
  public int size()
  {
    long l = this.domain.distance(first(), last());
    if (l >= 2147483647L) {
      return 2147483647;
    }
    return (int)l + 1;
  }
  
  ContiguousSet<C> subSetImpl(C paramC1, boolean paramBoolean1, C paramC2, boolean paramBoolean2)
  {
    if ((paramC1.compareTo(paramC2) == 0) && (!paramBoolean1) && (!paramBoolean2)) {
      return new EmptyContiguousSet(this.domain);
    }
    return intersectionInCurrentDomain(Range.range(paramC1, BoundType.forBoolean(paramBoolean1), paramC2, BoundType.forBoolean(paramBoolean2)));
  }
  
  ContiguousSet<C> tailSetImpl(C paramC, boolean paramBoolean)
  {
    return intersectionInCurrentDomain(Range.downTo(paramC, BoundType.forBoolean(paramBoolean)));
  }
  
  @GwtIncompatible
  Object writeReplace()
  {
    return new SerializedForm(this.range, this.domain, null);
  }
  
  @GwtIncompatible
  static final class SerializedForm<C extends Comparable>
    implements Serializable
  {
    final DiscreteDomain<C> domain;
    final Range<C> range;
    
    private SerializedForm(Range<C> paramRange, DiscreteDomain<C> paramDiscreteDomain)
    {
      this.range = paramRange;
      this.domain = paramDiscreteDomain;
    }
    
    private Object readResolve()
    {
      return new RegularContiguousSet(this.range, this.domain);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularContiguousSet
 * JD-Core Version:    0.7.0.1
 */