package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Lists
{
  static <E> boolean addAllImpl(List<E> paramList, int paramInt, Iterable<? extends E> paramIterable)
  {
    boolean bool = false;
    paramList = paramList.listIterator(paramInt);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramList.add(paramIterable.next());
      bool = true;
    }
    return bool;
  }
  
  public static <E> List<E> asList(@Nullable E paramE1, @Nullable E paramE2, E[] paramArrayOfE)
  {
    return new TwoPlusArrayList(paramE1, paramE2, paramArrayOfE);
  }
  
  public static <E> List<E> asList(@Nullable E paramE, E[] paramArrayOfE)
  {
    return new OnePlusArrayList(paramE, paramArrayOfE);
  }
  
  public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> paramList)
  {
    return CartesianList.create(paramList);
  }
  
  public static <B> List<List<B>> cartesianProduct(List<? extends B>... paramVarArgs)
  {
    return cartesianProduct(Arrays.asList(paramVarArgs));
  }
  
  static <T> List<T> cast(Iterable<T> paramIterable)
  {
    return (List)paramIterable;
  }
  
  public static ImmutableList<Character> charactersOf(String paramString)
  {
    return new StringAsImmutableList((String)Preconditions.checkNotNull(paramString));
  }
  
  @Beta
  public static List<Character> charactersOf(CharSequence paramCharSequence)
  {
    return new CharSequenceAsList((CharSequence)Preconditions.checkNotNull(paramCharSequence));
  }
  
  @VisibleForTesting
  static int computeArrayListCapacity(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "arraySize");
    return Ints.saturatedCast(5L + paramInt + paramInt / 10);
  }
  
  static boolean equalsImpl(List<?> paramList, @Nullable Object paramObject)
  {
    if (paramObject == Preconditions.checkNotNull(paramList)) {}
    for (;;)
    {
      return true;
      if (!(paramObject instanceof List)) {
        return false;
      }
      paramObject = (List)paramObject;
      int j = paramList.size();
      if (j != paramObject.size()) {
        return false;
      }
      if ((!(paramList instanceof RandomAccess)) || (!(paramObject instanceof RandomAccess))) {
        break;
      }
      int i = 0;
      while (i < j)
      {
        if (!Objects.equal(paramList.get(i), paramObject.get(i))) {
          return false;
        }
        i += 1;
      }
    }
    return Iterators.elementsEqual(paramList.iterator(), paramObject.iterator());
  }
  
  static int hashCodeImpl(List<?> paramList)
  {
    int i = 1;
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (localObject == null) {}
      for (int j = 0;; j = localObject.hashCode())
      {
        i = j + i * 31 ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
        break;
      }
    }
    return i;
  }
  
  static int indexOfImpl(List<?> paramList, @Nullable Object paramObject)
  {
    if ((paramList instanceof RandomAccess)) {
      return indexOfRandomAccess(paramList, paramObject);
    }
    paramList = paramList.listIterator();
    while (paramList.hasNext()) {
      if (Objects.equal(paramObject, paramList.next())) {
        return paramList.previousIndex();
      }
    }
    return -1;
  }
  
  private static int indexOfRandomAccess(List<?> paramList, @Nullable Object paramObject)
  {
    int i = 0;
    int j = 0;
    int k = paramList.size();
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (paramList.get(i) == null) {
          return i;
        }
        i += 1;
      }
    }
    do
    {
      i += 1;
      if (i >= k) {
        break;
      }
    } while (!paramObject.equals(paramList.get(i)));
    return i;
    return -1;
  }
  
  static int lastIndexOfImpl(List<?> paramList, @Nullable Object paramObject)
  {
    if ((paramList instanceof RandomAccess)) {
      return lastIndexOfRandomAccess(paramList, paramObject);
    }
    paramList = paramList.listIterator(paramList.size());
    while (paramList.hasPrevious()) {
      if (Objects.equal(paramObject, paramList.previous())) {
        return paramList.nextIndex();
      }
    }
    return -1;
  }
  
  private static int lastIndexOfRandomAccess(List<?> paramList, @Nullable Object paramObject)
  {
    int j;
    if (paramObject == null)
    {
      i = paramList.size() - 1;
      while (i >= 0)
      {
        if (paramList.get(i) == null)
        {
          j = i;
          return j;
        }
        i -= 1;
      }
    }
    int i = paramList.size() - 1;
    for (;;)
    {
      if (i < 0) {
        break label74;
      }
      j = i;
      if (paramObject.equals(paramList.get(i))) {
        break;
      }
      i -= 1;
    }
    label74:
    return -1;
  }
  
  static <E> ListIterator<E> listIteratorImpl(List<E> paramList, int paramInt)
  {
    return new AbstractListWrapper(paramList).listIterator(paramInt);
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayList()
  {
    return new ArrayList();
  }
  
  @GwtCompatible(serializable=true)
  @CanIgnoreReturnValue
  public static <E> ArrayList<E> newArrayList(Iterable<? extends E> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof Collection)) {
      return new ArrayList(Collections2.cast(paramIterable));
    }
    return newArrayList(paramIterable.iterator());
  }
  
  @GwtCompatible(serializable=true)
  @CanIgnoreReturnValue
  public static <E> ArrayList<E> newArrayList(Iterator<? extends E> paramIterator)
  {
    ArrayList localArrayList = newArrayList();
    Iterators.addAll(localArrayList, paramIterator);
    return localArrayList;
  }
  
  @GwtCompatible(serializable=true)
  @CanIgnoreReturnValue
  public static <E> ArrayList<E> newArrayList(E... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs);
    ArrayList localArrayList = new ArrayList(computeArrayListCapacity(paramVarArgs.length));
    Collections.addAll(localArrayList, paramVarArgs);
    return localArrayList;
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayListWithCapacity(int paramInt)
  {
    CollectPreconditions.checkNonnegative(paramInt, "initialArraySize");
    return new ArrayList(paramInt);
  }
  
  @GwtCompatible(serializable=true)
  public static <E> ArrayList<E> newArrayListWithExpectedSize(int paramInt)
  {
    return new ArrayList(computeArrayListCapacity(paramInt));
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList()
  {
    return new CopyOnWriteArrayList();
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {}
    for (paramIterable = Collections2.cast(paramIterable);; paramIterable = newArrayList(paramIterable)) {
      return new CopyOnWriteArrayList(paramIterable);
    }
  }
  
  @GwtCompatible(serializable=true)
  public static <E> LinkedList<E> newLinkedList()
  {
    return new LinkedList();
  }
  
  @GwtCompatible(serializable=true)
  public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> paramIterable)
  {
    LinkedList localLinkedList = newLinkedList();
    Iterables.addAll(localLinkedList, paramIterable);
    return localLinkedList;
  }
  
  public static <T> List<List<T>> partition(List<T> paramList, int paramInt)
  {
    Preconditions.checkNotNull(paramList);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      if (!(paramList instanceof RandomAccess)) {
        break;
      }
      return new RandomAccessPartition(paramList, paramInt);
    }
    return new Partition(paramList, paramInt);
  }
  
  public static <T> List<T> reverse(List<T> paramList)
  {
    if ((paramList instanceof ImmutableList)) {
      return ((ImmutableList)paramList).reverse();
    }
    if ((paramList instanceof ReverseList)) {
      return ((ReverseList)paramList).getForwardList();
    }
    if ((paramList instanceof RandomAccess)) {
      return new RandomAccessReverseList(paramList);
    }
    return new ReverseList(paramList);
  }
  
  static <E> List<E> subListImpl(List<E> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList instanceof RandomAccess)) {}
    for (paramList = new Lists.1(paramList);; paramList = new Lists.2(paramList)) {
      return paramList.subList(paramInt1, paramInt2);
    }
  }
  
  public static <F, T> List<T> transform(List<F> paramList, Function<? super F, ? extends T> paramFunction)
  {
    if ((paramList instanceof RandomAccess)) {
      return new TransformingRandomAccessList(paramList, paramFunction);
    }
    return new TransformingSequentialList(paramList, paramFunction);
  }
  
  static class AbstractListWrapper<E>
    extends AbstractList<E>
  {
    final List<E> backingList;
    
    AbstractListWrapper(List<E> paramList)
    {
      this.backingList = ((List)Preconditions.checkNotNull(paramList));
    }
    
    public void add(int paramInt, E paramE)
    {
      this.backingList.add(paramInt, paramE);
    }
    
    public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
    {
      return this.backingList.addAll(paramInt, paramCollection);
    }
    
    public boolean contains(Object paramObject)
    {
      return this.backingList.contains(paramObject);
    }
    
    public E get(int paramInt)
    {
      return this.backingList.get(paramInt);
    }
    
    public E remove(int paramInt)
    {
      return this.backingList.remove(paramInt);
    }
    
    public E set(int paramInt, E paramE)
    {
      return this.backingList.set(paramInt, paramE);
    }
    
    public int size()
    {
      return this.backingList.size();
    }
  }
  
  static final class CharSequenceAsList
    extends AbstractList<Character>
  {
    private final CharSequence sequence;
    
    CharSequenceAsList(CharSequence paramCharSequence)
    {
      this.sequence = paramCharSequence;
    }
    
    public Character get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Character.valueOf(this.sequence.charAt(paramInt));
    }
    
    public int size()
    {
      return this.sequence.length();
    }
  }
  
  static class OnePlusArrayList<E>
    extends AbstractList<E>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final E first;
    final E[] rest;
    
    OnePlusArrayList(@Nullable E paramE, E[] paramArrayOfE)
    {
      this.first = paramE;
      this.rest = ((Object[])Preconditions.checkNotNull(paramArrayOfE));
    }
    
    public E get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      if (paramInt == 0) {
        return this.first;
      }
      return this.rest[(paramInt - 1)];
    }
    
    public int size()
    {
      return IntMath.saturatedAdd(this.rest.length, 1);
    }
  }
  
  static class Partition<T>
    extends AbstractList<List<T>>
  {
    final List<T> list;
    final int size;
    
    Partition(List<T> paramList, int paramInt)
    {
      this.list = paramList;
      this.size = paramInt;
    }
    
    public List<T> get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      paramInt = this.size * paramInt;
      int i = Math.min(this.size + paramInt, this.list.size());
      return this.list.subList(paramInt, i);
    }
    
    public boolean isEmpty()
    {
      return this.list.isEmpty();
    }
    
    public int size()
    {
      return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
    }
  }
  
  static class RandomAccessListWrapper<E>
    extends Lists.AbstractListWrapper<E>
    implements RandomAccess
  {
    RandomAccessListWrapper(List<E> paramList)
    {
      super();
    }
  }
  
  static class RandomAccessPartition<T>
    extends Lists.Partition<T>
    implements RandomAccess
  {
    RandomAccessPartition(List<T> paramList, int paramInt)
    {
      super(paramInt);
    }
  }
  
  static class RandomAccessReverseList<T>
    extends Lists.ReverseList<T>
    implements RandomAccess
  {
    RandomAccessReverseList(List<T> paramList)
    {
      super();
    }
  }
  
  static class ReverseList<T>
    extends AbstractList<T>
  {
    private final List<T> forwardList;
    
    ReverseList(List<T> paramList)
    {
      this.forwardList = ((List)Preconditions.checkNotNull(paramList));
    }
    
    private int reverseIndex(int paramInt)
    {
      int i = size();
      Preconditions.checkElementIndex(paramInt, i);
      return i - 1 - paramInt;
    }
    
    private int reversePosition(int paramInt)
    {
      int i = size();
      Preconditions.checkPositionIndex(paramInt, i);
      return i - paramInt;
    }
    
    public void add(int paramInt, @Nullable T paramT)
    {
      this.forwardList.add(reversePosition(paramInt), paramT);
    }
    
    public void clear()
    {
      this.forwardList.clear();
    }
    
    public T get(int paramInt)
    {
      return this.forwardList.get(reverseIndex(paramInt));
    }
    
    List<T> getForwardList()
    {
      return this.forwardList;
    }
    
    public Iterator<T> iterator()
    {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int paramInt)
    {
      paramInt = reversePosition(paramInt);
      return new Lists.ReverseList.1(this, this.forwardList.listIterator(paramInt));
    }
    
    public T remove(int paramInt)
    {
      return this.forwardList.remove(reverseIndex(paramInt));
    }
    
    protected void removeRange(int paramInt1, int paramInt2)
    {
      subList(paramInt1, paramInt2).clear();
    }
    
    public T set(int paramInt, @Nullable T paramT)
    {
      return this.forwardList.set(reverseIndex(paramInt), paramT);
    }
    
    public int size()
    {
      return this.forwardList.size();
    }
    
    public List<T> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      return Lists.reverse(this.forwardList.subList(reversePosition(paramInt2), reversePosition(paramInt1)));
    }
  }
  
  static final class StringAsImmutableList
    extends ImmutableList<Character>
  {
    private final String string;
    
    StringAsImmutableList(String paramString)
    {
      this.string = paramString;
    }
    
    public Character get(int paramInt)
    {
      Preconditions.checkElementIndex(paramInt, size());
      return Character.valueOf(this.string.charAt(paramInt));
    }
    
    public int indexOf(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Character)) {
        return this.string.indexOf(((Character)paramObject).charValue());
      }
      return -1;
    }
    
    boolean isPartialView()
    {
      return false;
    }
    
    public int lastIndexOf(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Character)) {
        return this.string.lastIndexOf(((Character)paramObject).charValue());
      }
      return -1;
    }
    
    public int size()
    {
      return this.string.length();
    }
    
    public ImmutableList<Character> subList(int paramInt1, int paramInt2)
    {
      Preconditions.checkPositionIndexes(paramInt1, paramInt2, size());
      return Lists.charactersOf(this.string.substring(paramInt1, paramInt2));
    }
  }
  
  static class TransformingRandomAccessList<F, T>
    extends AbstractList<T>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final List<F> fromList;
    final Function<? super F, ? extends T> function;
    
    TransformingRandomAccessList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
    {
      this.fromList = ((List)Preconditions.checkNotNull(paramList));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public void clear()
    {
      this.fromList.clear();
    }
    
    public T get(int paramInt)
    {
      return this.function.apply(this.fromList.get(paramInt));
    }
    
    public boolean isEmpty()
    {
      return this.fromList.isEmpty();
    }
    
    public Iterator<T> iterator()
    {
      return listIterator();
    }
    
    public ListIterator<T> listIterator(int paramInt)
    {
      return new Lists.TransformingRandomAccessList.1(this, this.fromList.listIterator(paramInt));
    }
    
    public T remove(int paramInt)
    {
      return this.function.apply(this.fromList.remove(paramInt));
    }
    
    public int size()
    {
      return this.fromList.size();
    }
  }
  
  static class TransformingSequentialList<F, T>
    extends AbstractSequentialList<T>
    implements Serializable
  {
    private static final long serialVersionUID = 0L;
    final List<F> fromList;
    final Function<? super F, ? extends T> function;
    
    TransformingSequentialList(List<F> paramList, Function<? super F, ? extends T> paramFunction)
    {
      this.fromList = ((List)Preconditions.checkNotNull(paramList));
      this.function = ((Function)Preconditions.checkNotNull(paramFunction));
    }
    
    public void clear()
    {
      this.fromList.clear();
    }
    
    public ListIterator<T> listIterator(int paramInt)
    {
      return new Lists.TransformingSequentialList.1(this, this.fromList.listIterator(paramInt));
    }
    
    public int size()
    {
      return this.fromList.size();
    }
  }
  
  static class TwoPlusArrayList<E>
    extends AbstractList<E>
    implements Serializable, RandomAccess
  {
    private static final long serialVersionUID = 0L;
    final E first;
    final E[] rest;
    final E second;
    
    TwoPlusArrayList(@Nullable E paramE1, @Nullable E paramE2, E[] paramArrayOfE)
    {
      this.first = paramE1;
      this.second = paramE2;
      this.rest = ((Object[])Preconditions.checkNotNull(paramArrayOfE));
    }
    
    public E get(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        Preconditions.checkElementIndex(paramInt, size());
        return this.rest[(paramInt - 2)];
      case 0: 
        return this.first;
      }
      return this.second;
    }
    
    public int size()
    {
      return IntMath.saturatedAdd(this.rest.length, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Lists
 * JD-Core Version:    0.7.0.1
 */