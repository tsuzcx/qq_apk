package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
public abstract class ImmutableSortedSet<E>
  extends ImmutableSortedSetFauxverideShim<E>
  implements SortedIterable<E>, NavigableSet<E>
{
  final transient Comparator<? super E> comparator;
  @LazyInit
  @GwtIncompatible
  transient ImmutableSortedSet<E> descendingSet;
  
  ImmutableSortedSet(Comparator<? super E> paramComparator)
  {
    this.comparator = paramComparator;
  }
  
  static <E> ImmutableSortedSet<E> construct(Comparator<? super E> paramComparator, int paramInt, E... paramVarArgs)
  {
    if (paramInt == 0) {
      return emptySet(paramComparator);
    }
    ObjectArrays.checkElementsNotNull(paramVarArgs, paramInt);
    Arrays.sort(paramVarArgs, 0, paramInt, paramComparator);
    int j = 1;
    int i = 1;
    if (j < paramInt)
    {
      E ? = paramVarArgs[j];
      if (paramComparator.compare(?, paramVarArgs[(i - 1)]) == 0) {
        break label98;
      }
      int k = i + 1;
      paramVarArgs[i] = ?;
      i = k;
    }
    label98:
    for (;;)
    {
      j += 1;
      break;
      Arrays.fill(paramVarArgs, i, paramInt, null);
      return new RegularImmutableSortedSet(ImmutableList.asImmutableList(paramVarArgs, i), paramComparator);
    }
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> paramIterable)
  {
    return copyOf(Ordering.natural(), paramIterable);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> paramCollection)
  {
    return copyOf(Ordering.natural(), paramCollection);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Iterable<? extends E> paramIterable)
  {
    Preconditions.checkNotNull(paramComparator);
    if ((SortedIterables.hasSameComparator(paramComparator, paramIterable)) && ((paramIterable instanceof ImmutableSortedSet)))
    {
      ImmutableSortedSet localImmutableSortedSet = (ImmutableSortedSet)paramIterable;
      if (!localImmutableSortedSet.isPartialView()) {
        return localImmutableSortedSet;
      }
    }
    paramIterable = (Object[])Iterables.toArray(paramIterable);
    return construct(paramComparator, paramIterable.length, paramIterable);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Collection<? extends E> paramCollection)
  {
    return copyOf(paramComparator, paramCollection);
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> paramComparator, Iterator<? extends E> paramIterator)
  {
    return new Builder(paramComparator).addAll(paramIterator).build();
  }
  
  public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> paramIterator)
  {
    return copyOf(Ordering.natural(), paramIterator);
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> copyOf(E[] paramArrayOfE)
  {
    return construct(Ordering.natural(), paramArrayOfE.length, (Object[])paramArrayOfE.clone());
  }
  
  public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> paramSortedSet)
  {
    Comparator localComparator = SortedIterables.comparator(paramSortedSet);
    paramSortedSet = ImmutableList.copyOf(paramSortedSet);
    if (paramSortedSet.isEmpty()) {
      return emptySet(localComparator);
    }
    return new RegularImmutableSortedSet(paramSortedSet, localComparator);
  }
  
  static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> paramComparator)
  {
    if (Ordering.natural().equals(paramComparator)) {
      return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }
    return new RegularImmutableSortedSet(ImmutableList.of(), paramComparator);
  }
  
  public static <E extends Comparable<?>> Builder<E> naturalOrder()
  {
    return new Builder(Ordering.natural());
  }
  
  public static <E> ImmutableSortedSet<E> of()
  {
    return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE)
  {
    return new RegularImmutableSortedSet(ImmutableList.of(paramE), Ordering.natural());
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2)
  {
    return construct(Ordering.natural(), 2, new Comparable[] { paramE1, paramE2 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3)
  {
    return construct(Ordering.natural(), 3, new Comparable[] { paramE1, paramE2, paramE3 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    return construct(Ordering.natural(), 4, new Comparable[] { paramE1, paramE2, paramE3, paramE4 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    return construct(Ordering.natural(), 5, new Comparable[] { paramE1, paramE2, paramE3, paramE4, paramE5 });
  }
  
  public static <E extends Comparable<? super E>> ImmutableSortedSet<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    Comparable[] arrayOfComparable = new Comparable[paramVarArgs.length + 6];
    arrayOfComparable[0] = paramE1;
    arrayOfComparable[1] = paramE2;
    arrayOfComparable[2] = paramE3;
    arrayOfComparable[3] = paramE4;
    arrayOfComparable[4] = paramE5;
    arrayOfComparable[5] = paramE6;
    System.arraycopy(paramVarArgs, 0, arrayOfComparable, 6, paramVarArgs.length);
    return construct(Ordering.natural(), arrayOfComparable.length, (Comparable[])arrayOfComparable);
  }
  
  public static <E> Builder<E> orderedBy(Comparator<E> paramComparator)
  {
    return new Builder(paramComparator);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws InvalidObjectException
  {
    throw new InvalidObjectException("Use SerializedForm");
  }
  
  public static <E extends Comparable<?>> Builder<E> reverseOrder()
  {
    return new Builder(Ordering.natural().reverse());
  }
  
  static int unsafeCompare(Comparator<?> paramComparator, Object paramObject1, Object paramObject2)
  {
    return paramComparator.compare(paramObject1, paramObject2);
  }
  
  @GwtIncompatible
  public E ceiling(E paramE)
  {
    return Iterables.getFirst(tailSet(paramE, true), null);
  }
  
  public Comparator<? super E> comparator()
  {
    return this.comparator;
  }
  
  @GwtIncompatible
  ImmutableSortedSet<E> createDescendingSet()
  {
    return new DescendingImmutableSortedSet(this);
  }
  
  @GwtIncompatible
  public abstract UnmodifiableIterator<E> descendingIterator();
  
  @GwtIncompatible
  public ImmutableSortedSet<E> descendingSet()
  {
    ImmutableSortedSet localImmutableSortedSet2 = this.descendingSet;
    ImmutableSortedSet localImmutableSortedSet1 = localImmutableSortedSet2;
    if (localImmutableSortedSet2 == null)
    {
      localImmutableSortedSet1 = createDescendingSet();
      this.descendingSet = localImmutableSortedSet1;
      localImmutableSortedSet1.descendingSet = this;
    }
    return localImmutableSortedSet1;
  }
  
  public E first()
  {
    return iterator().next();
  }
  
  @GwtIncompatible
  public E floor(E paramE)
  {
    return Iterators.getNext(headSet(paramE, true).descendingIterator(), null);
  }
  
  public ImmutableSortedSet<E> headSet(E paramE)
  {
    return headSet(paramE, false);
  }
  
  @GwtIncompatible
  public ImmutableSortedSet<E> headSet(E paramE, boolean paramBoolean)
  {
    return headSetImpl(Preconditions.checkNotNull(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> headSetImpl(E paramE, boolean paramBoolean);
  
  @GwtIncompatible
  public E higher(E paramE)
  {
    return Iterables.getFirst(tailSet(paramE, false), null);
  }
  
  abstract int indexOf(@Nullable Object paramObject);
  
  public abstract UnmodifiableIterator<E> iterator();
  
  public E last()
  {
    return descendingIterator().next();
  }
  
  @GwtIncompatible
  public E lower(E paramE)
  {
    return Iterators.getNext(headSet(paramE, false).descendingIterator(), null);
  }
  
  @Deprecated
  @GwtIncompatible
  @CanIgnoreReturnValue
  public final E pollFirst()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  @GwtIncompatible
  @CanIgnoreReturnValue
  public final E pollLast()
  {
    throw new UnsupportedOperationException();
  }
  
  public ImmutableSortedSet<E> subSet(E paramE1, E paramE2)
  {
    return subSet(paramE1, true, paramE2, false);
  }
  
  @GwtIncompatible
  public ImmutableSortedSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramE1);
    Preconditions.checkNotNull(paramE2);
    if (this.comparator.compare(paramE1, paramE2) <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return subSetImpl(paramE1, paramBoolean1, paramE2, paramBoolean2);
    }
  }
  
  abstract ImmutableSortedSet<E> subSetImpl(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2);
  
  public ImmutableSortedSet<E> tailSet(E paramE)
  {
    return tailSet(paramE, true);
  }
  
  @GwtIncompatible
  public ImmutableSortedSet<E> tailSet(E paramE, boolean paramBoolean)
  {
    return tailSetImpl(Preconditions.checkNotNull(paramE), paramBoolean);
  }
  
  abstract ImmutableSortedSet<E> tailSetImpl(E paramE, boolean paramBoolean);
  
  int unsafeCompare(Object paramObject1, Object paramObject2)
  {
    return unsafeCompare(this.comparator, paramObject1, paramObject2);
  }
  
  Object writeReplace()
  {
    return new SerializedForm(this.comparator, toArray());
  }
  
  public static final class Builder<E>
    extends ImmutableSet.Builder<E>
  {
    private final Comparator<? super E> comparator;
    
    public Builder(Comparator<? super E> paramComparator)
    {
      this.comparator = ((Comparator)Preconditions.checkNotNull(paramComparator));
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E paramE)
    {
      super.add(paramE);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> add(E... paramVarArgs)
    {
      super.add(paramVarArgs);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterable<? extends E> paramIterable)
    {
      super.addAll(paramIterable);
      return this;
    }
    
    @CanIgnoreReturnValue
    public Builder<E> addAll(Iterator<? extends E> paramIterator)
    {
      super.addAll(paramIterator);
      return this;
    }
    
    public ImmutableSortedSet<E> build()
    {
      Object localObject = (Object[])this.contents;
      localObject = ImmutableSortedSet.construct(this.comparator, this.size, (Object[])localObject);
      this.size = ((ImmutableSortedSet)localObject).size();
      return localObject;
    }
  }
  
  static class SerializedForm<E>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final Comparator<? super E> comparator;
    final Object[] elements;
    
    public SerializedForm(Comparator<? super E> paramComparator, Object[] paramArrayOfObject)
    {
      this.comparator = paramComparator;
      this.elements = paramArrayOfObject;
    }
    
    Object readResolve()
    {
      return new ImmutableSortedSet.Builder(this.comparator).add((Object[])this.elements).build();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedSet
 * JD-Core Version:    0.7.0.1
 */