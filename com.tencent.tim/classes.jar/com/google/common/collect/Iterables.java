package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Iterables
{
  @CanIgnoreReturnValue
  public static <T> boolean addAll(Collection<T> paramCollection, Iterable<? extends T> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return paramCollection.addAll(Collections2.cast(paramIterable));
    }
    return Iterators.addAll(paramCollection, ((Iterable)Preconditions.checkNotNull(paramIterable)).iterator());
  }
  
  public static <T> boolean all(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.all(paramIterable.iterator(), paramPredicate);
  }
  
  public static <T> boolean any(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.any(paramIterable.iterator(), paramPredicate);
  }
  
  private static <E> Collection<E> castOrCopyToCollection(Iterable<E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return (Collection)paramIterable;
    }
    return Lists.newArrayList(paramIterable.iterator());
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends Iterable<? extends T>> paramIterable)
  {
    return FluentIterable.concat(paramIterable);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    return FluentIterable.concat(paramIterable1, paramIterable2);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3)
  {
    return FluentIterable.concat(paramIterable1, paramIterable2, paramIterable3);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2, Iterable<? extends T> paramIterable3, Iterable<? extends T> paramIterable4)
  {
    return FluentIterable.concat(paramIterable1, paramIterable2, paramIterable3, paramIterable4);
  }
  
  public static <T> Iterable<T> concat(Iterable<? extends T>... paramVarArgs)
  {
    return concat(ImmutableList.copyOf(paramVarArgs));
  }
  
  public static <T> Iterable<T> consumingIterable(Iterable<T> paramIterable)
  {
    if ((paramIterable instanceof Queue)) {
      return new Iterables.10(paramIterable);
    }
    Preconditions.checkNotNull(paramIterable);
    return new Iterables.11(paramIterable);
  }
  
  public static boolean contains(Iterable<?> paramIterable, @Nullable Object paramObject)
  {
    if ((paramIterable instanceof Collection)) {
      return Collections2.safeContains((Collection)paramIterable, paramObject);
    }
    return Iterators.contains(paramIterable.iterator(), paramObject);
  }
  
  public static <T> Iterable<T> cycle(Iterable<T> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    return new Iterables.1(paramIterable);
  }
  
  public static <T> Iterable<T> cycle(T... paramVarArgs)
  {
    return cycle(Lists.newArrayList(paramVarArgs));
  }
  
  public static boolean elementsEqual(Iterable<?> paramIterable1, Iterable<?> paramIterable2)
  {
    if (((paramIterable1 instanceof Collection)) && ((paramIterable2 instanceof Collection)))
    {
      Collection localCollection1 = (Collection)paramIterable1;
      Collection localCollection2 = (Collection)paramIterable2;
      if (localCollection1.size() != localCollection2.size()) {
        return false;
      }
    }
    return Iterators.elementsEqual(paramIterable1.iterator(), paramIterable2.iterator());
  }
  
  public static <T> Iterable<T> filter(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramPredicate);
    return new Iterables.4(paramIterable, paramPredicate);
  }
  
  @GwtIncompatible
  public static <T> Iterable<T> filter(Iterable<?> paramIterable, Class<T> paramClass)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramClass);
    return new Iterables.5(paramIterable, paramClass);
  }
  
  public static <T> T find(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.find(paramIterable.iterator(), paramPredicate);
  }
  
  @Nullable
  public static <T> T find(Iterable<? extends T> paramIterable, Predicate<? super T> paramPredicate, @Nullable T paramT)
  {
    return Iterators.find(paramIterable.iterator(), paramPredicate, paramT);
  }
  
  public static int frequency(Iterable<?> paramIterable, @Nullable Object paramObject)
  {
    if ((paramIterable instanceof Multiset)) {
      return ((Multiset)paramIterable).count(paramObject);
    }
    if ((paramIterable instanceof Set))
    {
      if (((Set)paramIterable).contains(paramObject)) {
        return 1;
      }
      return 0;
    }
    return Iterators.frequency(paramIterable.iterator(), paramObject);
  }
  
  public static <T> T get(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if ((paramIterable instanceof List)) {
      return ((List)paramIterable).get(paramInt);
    }
    return Iterators.get(paramIterable.iterator(), paramInt);
  }
  
  @Nullable
  public static <T> T get(Iterable<? extends T> paramIterable, int paramInt, @Nullable T paramT)
  {
    Preconditions.checkNotNull(paramIterable);
    Iterators.checkNonnegative(paramInt);
    if ((paramIterable instanceof List))
    {
      paramIterable = Lists.cast(paramIterable);
      if (paramInt < paramIterable.size()) {
        paramT = paramIterable.get(paramInt);
      }
      return paramT;
    }
    paramIterable = paramIterable.iterator();
    Iterators.advance(paramIterable, paramInt);
    return Iterators.getNext(paramIterable, paramT);
  }
  
  @Nullable
  public static <T> T getFirst(Iterable<? extends T> paramIterable, @Nullable T paramT)
  {
    return Iterators.getNext(paramIterable.iterator(), paramT);
  }
  
  public static <T> T getLast(Iterable<T> paramIterable)
  {
    if ((paramIterable instanceof List))
    {
      paramIterable = (List)paramIterable;
      if (paramIterable.isEmpty()) {
        throw new NoSuchElementException();
      }
      return getLastInNonemptyList(paramIterable);
    }
    return Iterators.getLast(paramIterable.iterator());
  }
  
  @Nullable
  public static <T> T getLast(Iterable<? extends T> paramIterable, @Nullable T paramT)
  {
    if ((paramIterable instanceof Collection))
    {
      if (Collections2.cast(paramIterable).isEmpty()) {
        return paramT;
      }
      if ((paramIterable instanceof List)) {
        return getLastInNonemptyList(Lists.cast(paramIterable));
      }
    }
    return Iterators.getLast(paramIterable.iterator(), paramT);
  }
  
  private static <T> T getLastInNonemptyList(List<T> paramList)
  {
    return paramList.get(paramList.size() - 1);
  }
  
  public static <T> T getOnlyElement(Iterable<T> paramIterable)
  {
    return Iterators.getOnlyElement(paramIterable.iterator());
  }
  
  @Nullable
  public static <T> T getOnlyElement(Iterable<? extends T> paramIterable, @Nullable T paramT)
  {
    return Iterators.getOnlyElement(paramIterable.iterator(), paramT);
  }
  
  public static <T> int indexOf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.indexOf(paramIterable.iterator(), paramPredicate);
  }
  
  public static boolean isEmpty(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).isEmpty();
    }
    return !paramIterable.iterator().hasNext();
  }
  
  public static <T> Iterable<T> limit(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "limit is negative");
      return new Iterables.9(paramIterable, paramInt);
    }
  }
  
  @Beta
  public static <T> Iterable<T> mergeSorted(Iterable<? extends Iterable<? extends T>> paramIterable, Comparator<? super T> paramComparator)
  {
    Preconditions.checkNotNull(paramIterable, "iterables");
    Preconditions.checkNotNull(paramComparator, "comparator");
    return new UnmodifiableIterable(new Iterables.12(paramIterable, paramComparator), null);
  }
  
  public static <T> Iterable<List<T>> paddedPartition(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new Iterables.3(paramIterable, paramInt);
    }
  }
  
  public static <T> Iterable<List<T>> partition(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool);
      return new Iterables.2(paramIterable, paramInt);
    }
  }
  
  @CanIgnoreReturnValue
  public static boolean removeAll(Iterable<?> paramIterable, Collection<?> paramCollection)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).removeAll((Collection)Preconditions.checkNotNull(paramCollection));
    }
    return Iterators.removeAll(paramIterable.iterator(), paramCollection);
  }
  
  @Nullable
  static <T> T removeFirstMatching(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    Preconditions.checkNotNull(paramPredicate);
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramPredicate.apply(localObject))
      {
        paramIterable.remove();
        return localObject;
      }
    }
    return null;
  }
  
  @CanIgnoreReturnValue
  public static <T> boolean removeIf(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    if (((paramIterable instanceof RandomAccess)) && ((paramIterable instanceof List))) {
      return removeIfFromRandomAccessList((List)paramIterable, (Predicate)Preconditions.checkNotNull(paramPredicate));
    }
    return Iterators.removeIf(paramIterable.iterator(), paramPredicate);
  }
  
  private static <T> boolean removeIfFromRandomAccessList(List<T> paramList, Predicate<? super T> paramPredicate)
  {
    boolean bool = false;
    int j = 0;
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = paramList.get(i);
      int k = j;
      if ((paramPredicate.apply(localObject)) || (i > j)) {}
      try
      {
        paramList.set(j, localObject);
        k = j + 1;
        i += 1;
        j = k;
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        slowRemoveIfForRemainingElements(paramList, paramPredicate, j, i);
        return true;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        slowRemoveIfForRemainingElements(paramList, paramPredicate, j, i);
        return true;
      }
    }
    paramList.subList(j, paramList.size()).clear();
    if (i != j) {
      bool = true;
    }
    return bool;
  }
  
  @CanIgnoreReturnValue
  public static boolean retainAll(Iterable<?> paramIterable, Collection<?> paramCollection)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).retainAll((Collection)Preconditions.checkNotNull(paramCollection));
    }
    return Iterators.retainAll(paramIterable.iterator(), paramCollection);
  }
  
  public static int size(Iterable<?> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return ((Collection)paramIterable).size();
    }
    return Iterators.size(paramIterable.iterator());
  }
  
  public static <T> Iterable<T> skip(Iterable<T> paramIterable, int paramInt)
  {
    Preconditions.checkNotNull(paramIterable);
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "number to skip cannot be negative");
      if (!(paramIterable instanceof List)) {
        break;
      }
      return new Iterables.7((List)paramIterable, paramInt);
    }
    return new Iterables.8(paramIterable, paramInt);
  }
  
  private static <T> void slowRemoveIfForRemainingElements(List<T> paramList, Predicate<? super T> paramPredicate, int paramInt1, int paramInt2)
  {
    int i = paramList.size() - 1;
    while (i > paramInt2)
    {
      if (paramPredicate.apply(paramList.get(i))) {
        paramList.remove(i);
      }
      i -= 1;
    }
    paramInt2 -= 1;
    while (paramInt2 >= paramInt1)
    {
      paramList.remove(paramInt2);
      paramInt2 -= 1;
    }
  }
  
  static Object[] toArray(Iterable<?> paramIterable)
  {
    return castOrCopyToCollection(paramIterable).toArray();
  }
  
  @GwtIncompatible
  public static <T> T[] toArray(Iterable<? extends T> paramIterable, Class<T> paramClass)
  {
    return toArray(paramIterable, ObjectArrays.newArray(paramClass, 0));
  }
  
  static <T> T[] toArray(Iterable<? extends T> paramIterable, T[] paramArrayOfT)
  {
    return castOrCopyToCollection(paramIterable).toArray(paramArrayOfT);
  }
  
  static <T> Function<Iterable<? extends T>, Iterator<? extends T>> toIterator()
  {
    return new Iterables.13();
  }
  
  public static String toString(Iterable<?> paramIterable)
  {
    return Iterators.toString(paramIterable.iterator());
  }
  
  public static <F, T> Iterable<T> transform(Iterable<F> paramIterable, Function<? super F, ? extends T> paramFunction)
  {
    Preconditions.checkNotNull(paramIterable);
    Preconditions.checkNotNull(paramFunction);
    return new Iterables.6(paramIterable, paramFunction);
  }
  
  public static <T> Optional<T> tryFind(Iterable<T> paramIterable, Predicate<? super T> paramPredicate)
  {
    return Iterators.tryFind(paramIterable.iterator(), paramPredicate);
  }
  
  @Deprecated
  public static <E> Iterable<E> unmodifiableIterable(ImmutableCollection<E> paramImmutableCollection)
  {
    return (Iterable)Preconditions.checkNotNull(paramImmutableCollection);
  }
  
  public static <T> Iterable<T> unmodifiableIterable(Iterable<? extends T> paramIterable)
  {
    Preconditions.checkNotNull(paramIterable);
    if (((paramIterable instanceof UnmodifiableIterable)) || ((paramIterable instanceof ImmutableCollection))) {
      return paramIterable;
    }
    return new UnmodifiableIterable(paramIterable, null);
  }
  
  static final class UnmodifiableIterable<T>
    extends FluentIterable<T>
  {
    private final Iterable<? extends T> iterable;
    
    private UnmodifiableIterable(Iterable<? extends T> paramIterable)
    {
      this.iterable = paramIterable;
    }
    
    public Iterator<T> iterator()
    {
      return Iterators.unmodifiableIterator(this.iterable.iterator());
    }
    
    public String toString()
    {
      return this.iterable.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables
 * JD-Core Version:    0.7.0.1
 */