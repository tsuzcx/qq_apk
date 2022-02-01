package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class Sets
{
  public static <B> Set<List<B>> cartesianProduct(List<? extends Set<? extends B>> paramList)
  {
    return CartesianSet.create(paramList);
  }
  
  public static <B> Set<List<B>> cartesianProduct(Set<? extends B>... paramVarArgs)
  {
    return cartesianProduct(Arrays.asList(paramVarArgs));
  }
  
  public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> paramCollection)
  {
    if ((paramCollection instanceof EnumSet)) {
      return EnumSet.complementOf((EnumSet)paramCollection);
    }
    if (!paramCollection.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "collection is empty; use the other version of this method");
      return makeComplementByHand(paramCollection, ((Enum)paramCollection.iterator().next()).getDeclaringClass());
    }
  }
  
  public static <E extends Enum<E>> EnumSet<E> complementOf(Collection<E> paramCollection, Class<E> paramClass)
  {
    Preconditions.checkNotNull(paramCollection);
    if ((paramCollection instanceof EnumSet)) {
      return EnumSet.complementOf((EnumSet)paramCollection);
    }
    return makeComplementByHand(paramCollection, paramClass);
  }
  
  public static <E> SetView<E> difference(Set<E> paramSet, Set<?> paramSet1)
  {
    Preconditions.checkNotNull(paramSet, "set1");
    Preconditions.checkNotNull(paramSet1, "set2");
    return new Sets.3(paramSet, Predicates.not(Predicates.in(paramSet1)), paramSet1);
  }
  
  static boolean equalsImpl(Set<?> paramSet, @Nullable Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (paramSet == paramObject) {
      bool1 = true;
    }
    while (!(paramObject instanceof Set)) {
      return bool1;
    }
    paramObject = (Set)paramObject;
    try
    {
      if (paramSet.size() == paramObject.size())
      {
        bool1 = paramSet.containsAll(paramObject);
        if (!bool1) {}
      }
      for (bool1 = bool2;; bool1 = false) {
        return bool1;
      }
      return false;
    }
    catch (ClassCastException paramSet)
    {
      return false;
    }
    catch (NullPointerException paramSet) {}
  }
  
  @GwtIncompatible
  public static <E> NavigableSet<E> filter(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate)
  {
    if ((paramNavigableSet instanceof FilteredSet))
    {
      paramNavigableSet = (FilteredSet)paramNavigableSet;
      paramPredicate = Predicates.and(paramNavigableSet.predicate, paramPredicate);
      return new FilteredNavigableSet((NavigableSet)paramNavigableSet.unfiltered, paramPredicate);
    }
    return new FilteredNavigableSet((NavigableSet)Preconditions.checkNotNull(paramNavigableSet), (Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  public static <E> Set<E> filter(Set<E> paramSet, Predicate<? super E> paramPredicate)
  {
    if ((paramSet instanceof SortedSet)) {
      return filter((SortedSet)paramSet, paramPredicate);
    }
    if ((paramSet instanceof FilteredSet))
    {
      paramSet = (FilteredSet)paramSet;
      paramPredicate = Predicates.and(paramSet.predicate, paramPredicate);
      return new FilteredSet((Set)paramSet.unfiltered, paramPredicate);
    }
    return new FilteredSet((Set)Preconditions.checkNotNull(paramSet), (Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  public static <E> SortedSet<E> filter(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate)
  {
    if ((paramSortedSet instanceof FilteredSet))
    {
      paramSortedSet = (FilteredSet)paramSortedSet;
      paramPredicate = Predicates.and(paramSortedSet.predicate, paramPredicate);
      return new FilteredSortedSet((SortedSet)paramSortedSet.unfiltered, paramPredicate);
    }
    return new FilteredSortedSet((SortedSet)Preconditions.checkNotNull(paramSortedSet), (Predicate)Preconditions.checkNotNull(paramPredicate));
  }
  
  static int hashCodeImpl(Set<?> paramSet)
  {
    paramSet = paramSet.iterator();
    int i = 0;
    if (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if (localObject != null) {}
      for (int j = localObject.hashCode();; j = 0)
      {
        i = i + j ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
        break;
      }
    }
    return i;
  }
  
  @GwtCompatible(serializable=true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(E paramE, E... paramVarArgs)
  {
    return ImmutableEnumSet.asImmutable(EnumSet.of(paramE, paramVarArgs));
  }
  
  @GwtCompatible(serializable=true)
  public static <E extends Enum<E>> ImmutableSet<E> immutableEnumSet(Iterable<E> paramIterable)
  {
    if ((paramIterable instanceof ImmutableEnumSet)) {
      return (ImmutableEnumSet)paramIterable;
    }
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Collection)paramIterable;
      if (paramIterable.isEmpty()) {
        return ImmutableSet.of();
      }
      return ImmutableEnumSet.asImmutable(EnumSet.copyOf(paramIterable));
    }
    paramIterable = paramIterable.iterator();
    if (paramIterable.hasNext())
    {
      EnumSet localEnumSet = EnumSet.of((Enum)paramIterable.next());
      Iterators.addAll(localEnumSet, paramIterable);
      return ImmutableEnumSet.asImmutable(localEnumSet);
    }
    return ImmutableSet.of();
  }
  
  public static <E> SetView<E> intersection(Set<E> paramSet, Set<?> paramSet1)
  {
    Preconditions.checkNotNull(paramSet, "set1");
    Preconditions.checkNotNull(paramSet1, "set2");
    return new Sets.2(paramSet, Predicates.in(paramSet1), paramSet1);
  }
  
  private static <E extends Enum<E>> EnumSet<E> makeComplementByHand(Collection<E> paramCollection, Class<E> paramClass)
  {
    paramClass = EnumSet.allOf(paramClass);
    paramClass.removeAll(paramCollection);
    return paramClass;
  }
  
  public static <E> Set<E> newConcurrentHashSet()
  {
    return Collections.newSetFromMap(new ConcurrentHashMap());
  }
  
  public static <E> Set<E> newConcurrentHashSet(Iterable<? extends E> paramIterable)
  {
    Set localSet = newConcurrentHashSet();
    Iterables.addAll(localSet, paramIterable);
    return localSet;
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet()
  {
    return new CopyOnWriteArraySet();
  }
  
  @GwtIncompatible
  public static <E> CopyOnWriteArraySet<E> newCopyOnWriteArraySet(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {}
    for (paramIterable = Collections2.cast(paramIterable);; paramIterable = Lists.newArrayList(paramIterable)) {
      return new CopyOnWriteArraySet(paramIterable);
    }
  }
  
  public static <E extends Enum<E>> EnumSet<E> newEnumSet(Iterable<E> paramIterable, Class<E> paramClass)
  {
    paramClass = EnumSet.noneOf(paramClass);
    Iterables.addAll(paramClass, paramIterable);
    return paramClass;
  }
  
  public static <E> HashSet<E> newHashSet()
  {
    return new HashSet();
  }
  
  public static <E> HashSet<E> newHashSet(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new HashSet(Collections2.cast(paramIterable));
    }
    return newHashSet(paramIterable.iterator());
  }
  
  public static <E> HashSet<E> newHashSet(Iterator<? extends E> paramIterator)
  {
    HashSet localHashSet = newHashSet();
    Iterators.addAll(localHashSet, paramIterator);
    return localHashSet;
  }
  
  public static <E> HashSet<E> newHashSet(E... paramVarArgs)
  {
    HashSet localHashSet = newHashSetWithExpectedSize(paramVarArgs.length);
    Collections.addAll(localHashSet, paramVarArgs);
    return localHashSet;
  }
  
  public static <E> HashSet<E> newHashSetWithExpectedSize(int paramInt)
  {
    return new HashSet(Maps.capacity(paramInt));
  }
  
  public static <E> Set<E> newIdentityHashSet()
  {
    return Collections.newSetFromMap(Maps.newIdentityHashMap());
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet()
  {
    return new LinkedHashSet();
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSet(Iterable<? extends E> paramIterable)
  {
    if ((paramIterable instanceof Collection)) {
      return new LinkedHashSet(Collections2.cast(paramIterable));
    }
    LinkedHashSet localLinkedHashSet = newLinkedHashSet();
    Iterables.addAll(localLinkedHashSet, paramIterable);
    return localLinkedHashSet;
  }
  
  public static <E> LinkedHashSet<E> newLinkedHashSetWithExpectedSize(int paramInt)
  {
    return new LinkedHashSet(Maps.capacity(paramInt));
  }
  
  @Deprecated
  public static <E> Set<E> newSetFromMap(Map<E, Boolean> paramMap)
  {
    return Collections.newSetFromMap(paramMap);
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet()
  {
    return new TreeSet();
  }
  
  public static <E extends Comparable> TreeSet<E> newTreeSet(Iterable<? extends E> paramIterable)
  {
    TreeSet localTreeSet = newTreeSet();
    Iterables.addAll(localTreeSet, paramIterable);
    return localTreeSet;
  }
  
  public static <E> TreeSet<E> newTreeSet(Comparator<? super E> paramComparator)
  {
    return new TreeSet((Comparator)Preconditions.checkNotNull(paramComparator));
  }
  
  @GwtCompatible(serializable=false)
  public static <E> Set<Set<E>> powerSet(Set<E> paramSet)
  {
    return new PowerSet(paramSet);
  }
  
  static boolean removeAllImpl(Set<?> paramSet, Collection<?> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection);
    Object localObject = paramCollection;
    if ((paramCollection instanceof Multiset)) {
      localObject = ((Multiset)paramCollection).elementSet();
    }
    if (((localObject instanceof Set)) && (((Collection)localObject).size() > paramSet.size())) {
      return Iterators.removeAll(paramSet.iterator(), (Collection)localObject);
    }
    return removeAllImpl(paramSet, ((Collection)localObject).iterator());
  }
  
  static boolean removeAllImpl(Set<?> paramSet, Iterator<?> paramIterator)
  {
    boolean bool = false;
    while (paramIterator.hasNext()) {
      bool |= paramSet.remove(paramIterator.next());
    }
    return bool;
  }
  
  @Beta
  @GwtIncompatible
  public static <K extends Comparable<? super K>> NavigableSet<K> subSet(NavigableSet<K> paramNavigableSet, Range<K> paramRange)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool2 = true;
    boolean bool1;
    Comparable localComparable1;
    label106:
    Comparable localComparable2;
    if ((paramNavigableSet.comparator() != null) && (paramNavigableSet.comparator() != Ordering.natural()) && (paramRange.hasLowerBound()) && (paramRange.hasUpperBound()))
    {
      if (paramNavigableSet.comparator().compare(paramRange.lowerEndpoint(), paramRange.upperEndpoint()) <= 0)
      {
        bool1 = true;
        Preconditions.checkArgument(bool1, "set is using a custom comparator which is inconsistent with the natural ordering.");
      }
    }
    else
    {
      if ((!paramRange.hasLowerBound()) || (!paramRange.hasUpperBound())) {
        break label150;
      }
      localComparable1 = paramRange.lowerEndpoint();
      if (paramRange.lowerBoundType() != BoundType.CLOSED) {
        break label140;
      }
      bool1 = true;
      localComparable2 = paramRange.upperEndpoint();
      if (paramRange.upperBoundType() != BoundType.CLOSED) {
        break label145;
      }
    }
    for (;;)
    {
      return paramNavigableSet.subSet(localComparable1, bool1, localComparable2, bool2);
      bool1 = false;
      break;
      label140:
      bool1 = false;
      break label106;
      label145:
      bool2 = false;
    }
    label150:
    if (paramRange.hasLowerBound())
    {
      localComparable1 = paramRange.lowerEndpoint();
      if (paramRange.lowerBoundType() == BoundType.CLOSED) {}
      for (bool1 = bool3;; bool1 = false) {
        return paramNavigableSet.tailSet(localComparable1, bool1);
      }
    }
    if (paramRange.hasUpperBound())
    {
      localComparable1 = paramRange.upperEndpoint();
      if (paramRange.upperBoundType() == BoundType.CLOSED) {}
      for (bool1 = bool4;; bool1 = false) {
        return paramNavigableSet.headSet(localComparable1, bool1);
      }
    }
    return (NavigableSet)Preconditions.checkNotNull(paramNavigableSet);
  }
  
  public static <E> SetView<E> symmetricDifference(Set<? extends E> paramSet1, Set<? extends E> paramSet2)
  {
    Preconditions.checkNotNull(paramSet1, "set1");
    Preconditions.checkNotNull(paramSet2, "set2");
    return new Sets.4(paramSet1, paramSet2);
  }
  
  @GwtIncompatible
  public static <E> NavigableSet<E> synchronizedNavigableSet(NavigableSet<E> paramNavigableSet)
  {
    return Synchronized.navigableSet(paramNavigableSet);
  }
  
  public static <E> SetView<E> union(Set<? extends E> paramSet1, Set<? extends E> paramSet2)
  {
    Preconditions.checkNotNull(paramSet1, "set1");
    Preconditions.checkNotNull(paramSet2, "set2");
    return new Sets.1(paramSet1, difference(paramSet2, paramSet1), paramSet2);
  }
  
  @GwtIncompatible
  public static <E> NavigableSet<E> unmodifiableNavigableSet(NavigableSet<E> paramNavigableSet)
  {
    if (((paramNavigableSet instanceof ImmutableSortedSet)) || ((paramNavigableSet instanceof UnmodifiableNavigableSet))) {
      return paramNavigableSet;
    }
    return new UnmodifiableNavigableSet(paramNavigableSet);
  }
  
  static final class CartesianSet<E>
    extends ForwardingCollection<List<E>>
    implements Set<List<E>>
  {
    private final transient ImmutableList<ImmutableSet<E>> axes;
    private final transient CartesianList<E> delegate;
    
    private CartesianSet(ImmutableList<ImmutableSet<E>> paramImmutableList, CartesianList<E> paramCartesianList)
    {
      this.axes = paramImmutableList;
      this.delegate = paramCartesianList;
    }
    
    static <E> Set<List<E>> create(List<? extends Set<? extends E>> paramList)
    {
      ImmutableList.Builder localBuilder = new ImmutableList.Builder(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ImmutableSet localImmutableSet = ImmutableSet.copyOf((Set)paramList.next());
        if (localImmutableSet.isEmpty()) {
          return ImmutableSet.of();
        }
        localBuilder.add(localImmutableSet);
      }
      paramList = localBuilder.build();
      return new CartesianSet(paramList, new CartesianList(new Sets.CartesianSet.1(paramList)));
    }
    
    protected Collection<List<E>> delegate()
    {
      return this.delegate;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof CartesianSet))
      {
        paramObject = (CartesianSet)paramObject;
        return this.axes.equals(paramObject.axes);
      }
      return super.equals(paramObject);
    }
    
    public int hashCode()
    {
      int i = size() - 1;
      int j = 0;
      while (j < this.axes.size())
      {
        i = i * 31 ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
        j += 1;
      }
      Iterator localIterator = this.axes.iterator();
      Set localSet;
      int k;
      for (j = 1; localIterator.hasNext(); j = localSet.hashCode() * k + j * 31 ^ 0xFFFFFFFF ^ 0xFFFFFFFF)
      {
        localSet = (Set)localIterator.next();
        k = size() / localSet.size();
      }
      return j + i ^ 0xFFFFFFFF ^ 0xFFFFFFFF;
    }
  }
  
  @GwtIncompatible
  static class DescendingSet<E>
    extends ForwardingNavigableSet<E>
  {
    private final NavigableSet<E> forward;
    
    DescendingSet(NavigableSet<E> paramNavigableSet)
    {
      this.forward = paramNavigableSet;
    }
    
    private static <T> Ordering<T> reverse(Comparator<T> paramComparator)
    {
      return Ordering.from(paramComparator).reverse();
    }
    
    public E ceiling(E paramE)
    {
      return this.forward.floor(paramE);
    }
    
    public Comparator<? super E> comparator()
    {
      Comparator localComparator = this.forward.comparator();
      if (localComparator == null) {
        return Ordering.natural().reverse();
      }
      return reverse(localComparator);
    }
    
    protected NavigableSet<E> delegate()
    {
      return this.forward;
    }
    
    public Iterator<E> descendingIterator()
    {
      return this.forward.iterator();
    }
    
    public NavigableSet<E> descendingSet()
    {
      return this.forward;
    }
    
    public E first()
    {
      return this.forward.last();
    }
    
    public E floor(E paramE)
    {
      return this.forward.ceiling(paramE);
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return this.forward.tailSet(paramE, paramBoolean).descendingSet();
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      return standardHeadSet(paramE);
    }
    
    public E higher(E paramE)
    {
      return this.forward.lower(paramE);
    }
    
    public Iterator<E> iterator()
    {
      return this.forward.descendingIterator();
    }
    
    public E last()
    {
      return this.forward.first();
    }
    
    public E lower(E paramE)
    {
      return this.forward.higher(paramE);
    }
    
    public E pollFirst()
    {
      return this.forward.pollLast();
    }
    
    public E pollLast()
    {
      return this.forward.pollFirst();
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return this.forward.subSet(paramE2, paramBoolean2, paramE1, paramBoolean1).descendingSet();
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      return standardSubSet(paramE1, paramE2);
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return this.forward.headSet(paramE, paramBoolean).descendingSet();
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      return standardTailSet(paramE);
    }
    
    public Object[] toArray()
    {
      return standardToArray();
    }
    
    public <T> T[] toArray(T[] paramArrayOfT)
    {
      return standardToArray(paramArrayOfT);
    }
    
    public String toString()
    {
      return standardToString();
    }
  }
  
  @GwtIncompatible
  static class FilteredNavigableSet<E>
    extends Sets.FilteredSortedSet<E>
    implements NavigableSet<E>
  {
    FilteredNavigableSet(NavigableSet<E> paramNavigableSet, Predicate<? super E> paramPredicate)
    {
      super(paramPredicate);
    }
    
    public E ceiling(E paramE)
    {
      return Iterables.getFirst(tailSet(paramE, true), null);
    }
    
    public Iterator<E> descendingIterator()
    {
      return Iterators.filter(unfiltered().descendingIterator(), this.predicate);
    }
    
    public NavigableSet<E> descendingSet()
    {
      return Sets.filter(unfiltered().descendingSet(), this.predicate);
    }
    
    @Nullable
    public E floor(E paramE)
    {
      return Iterators.getNext(headSet(paramE, true).descendingIterator(), null);
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return Sets.filter(unfiltered().headSet(paramE, paramBoolean), this.predicate);
    }
    
    public E higher(E paramE)
    {
      return Iterables.getFirst(tailSet(paramE, false), null);
    }
    
    public E last()
    {
      return descendingIterator().next();
    }
    
    @Nullable
    public E lower(E paramE)
    {
      return Iterators.getNext(headSet(paramE, false).descendingIterator(), null);
    }
    
    public E pollFirst()
    {
      return Iterables.removeFirstMatching(unfiltered(), this.predicate);
    }
    
    public E pollLast()
    {
      return Iterables.removeFirstMatching(unfiltered().descendingSet(), this.predicate);
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return Sets.filter(unfiltered().subSet(paramE1, paramBoolean1, paramE2, paramBoolean2), this.predicate);
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return Sets.filter(unfiltered().tailSet(paramE, paramBoolean), this.predicate);
    }
    
    NavigableSet<E> unfiltered()
    {
      return (NavigableSet)this.unfiltered;
    }
  }
  
  static class FilteredSet<E>
    extends Collections2.FilteredCollection<E>
    implements Set<E>
  {
    FilteredSet(Set<E> paramSet, Predicate<? super E> paramPredicate)
    {
      super(paramPredicate);
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      return Sets.equalsImpl(this, paramObject);
    }
    
    public int hashCode()
    {
      return Sets.hashCodeImpl(this);
    }
  }
  
  static class FilteredSortedSet<E>
    extends Sets.FilteredSet<E>
    implements SortedSet<E>
  {
    FilteredSortedSet(SortedSet<E> paramSortedSet, Predicate<? super E> paramPredicate)
    {
      super(paramPredicate);
    }
    
    public Comparator<? super E> comparator()
    {
      return ((SortedSet)this.unfiltered).comparator();
    }
    
    public E first()
    {
      return iterator().next();
    }
    
    public SortedSet<E> headSet(E paramE)
    {
      return new FilteredSortedSet(((SortedSet)this.unfiltered).headSet(paramE), this.predicate);
    }
    
    public E last()
    {
      Object localObject;
      for (SortedSet localSortedSet = (SortedSet)this.unfiltered;; localSortedSet = localSortedSet.headSet(localObject))
      {
        localObject = localSortedSet.last();
        if (this.predicate.apply(localObject)) {
          return localObject;
        }
      }
    }
    
    public SortedSet<E> subSet(E paramE1, E paramE2)
    {
      return new FilteredSortedSet(((SortedSet)this.unfiltered).subSet(paramE1, paramE2), this.predicate);
    }
    
    public SortedSet<E> tailSet(E paramE)
    {
      return new FilteredSortedSet(((SortedSet)this.unfiltered).tailSet(paramE), this.predicate);
    }
  }
  
  static abstract class ImprovedAbstractSet<E>
    extends AbstractSet<E>
  {
    public boolean removeAll(Collection<?> paramCollection)
    {
      return Sets.removeAllImpl(this, paramCollection);
    }
    
    public boolean retainAll(Collection<?> paramCollection)
    {
      return super.retainAll((Collection)Preconditions.checkNotNull(paramCollection));
    }
  }
  
  static final class PowerSet<E>
    extends AbstractSet<Set<E>>
  {
    final ImmutableMap<E, Integer> inputSet;
    
    PowerSet(Set<E> paramSet)
    {
      this.inputSet = Maps.indexMap(paramSet);
      if (this.inputSet.size() <= 30) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Too many elements to create power set: %s > 30", this.inputSet.size());
        return;
      }
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        return this.inputSet.keySet().containsAll(paramObject);
      }
      return false;
    }
    
    public boolean equals(@Nullable Object paramObject)
    {
      if ((paramObject instanceof PowerSet))
      {
        paramObject = (PowerSet)paramObject;
        return this.inputSet.equals(paramObject.inputSet);
      }
      return super.equals(paramObject);
    }
    
    public int hashCode()
    {
      return this.inputSet.keySet().hashCode() << this.inputSet.size() - 1;
    }
    
    public boolean isEmpty()
    {
      return false;
    }
    
    public Iterator<Set<E>> iterator()
    {
      return new Sets.PowerSet.1(this, size());
    }
    
    public int size()
    {
      return 1 << this.inputSet.size();
    }
    
    public String toString()
    {
      return "powerSet(" + this.inputSet + ")";
    }
  }
  
  public static abstract class SetView<E>
    extends AbstractSet<E>
  {
    @CanIgnoreReturnValue
    public <S extends Set<E>> S copyInto(S paramS)
    {
      paramS.addAll(this);
      return paramS;
    }
    
    public ImmutableSet<E> immutableCopy()
    {
      return ImmutableSet.copyOf(this);
    }
    
    public abstract UnmodifiableIterator<E> iterator();
  }
  
  static final class SubSet<E>
    extends AbstractSet<E>
  {
    private final ImmutableMap<E, Integer> inputSet;
    private final int mask;
    
    SubSet(ImmutableMap<E, Integer> paramImmutableMap, int paramInt)
    {
      this.inputSet = paramImmutableMap;
      this.mask = paramInt;
    }
    
    public boolean contains(@Nullable Object paramObject)
    {
      paramObject = (Integer)this.inputSet.get(paramObject);
      if (paramObject != null)
      {
        int i = this.mask;
        if ((1 << paramObject.intValue() & i) != 0) {
          return true;
        }
      }
      return false;
    }
    
    public Iterator<E> iterator()
    {
      return new Sets.SubSet.1(this);
    }
    
    public int size()
    {
      return Integer.bitCount(this.mask);
    }
  }
  
  @GwtIncompatible
  static final class UnmodifiableNavigableSet<E>
    extends ForwardingSortedSet<E>
    implements Serializable, NavigableSet<E>
  {
    private static final long serialVersionUID = 0L;
    private final NavigableSet<E> delegate;
    private transient UnmodifiableNavigableSet<E> descendingSet;
    
    UnmodifiableNavigableSet(NavigableSet<E> paramNavigableSet)
    {
      this.delegate = ((NavigableSet)Preconditions.checkNotNull(paramNavigableSet));
    }
    
    public E ceiling(E paramE)
    {
      return this.delegate.ceiling(paramE);
    }
    
    protected SortedSet<E> delegate()
    {
      return Collections.unmodifiableSortedSet(this.delegate);
    }
    
    public Iterator<E> descendingIterator()
    {
      return Iterators.unmodifiableIterator(this.delegate.descendingIterator());
    }
    
    public NavigableSet<E> descendingSet()
    {
      UnmodifiableNavigableSet localUnmodifiableNavigableSet2 = this.descendingSet;
      UnmodifiableNavigableSet localUnmodifiableNavigableSet1 = localUnmodifiableNavigableSet2;
      if (localUnmodifiableNavigableSet2 == null)
      {
        localUnmodifiableNavigableSet1 = new UnmodifiableNavigableSet(this.delegate.descendingSet());
        this.descendingSet = localUnmodifiableNavigableSet1;
        localUnmodifiableNavigableSet1.descendingSet = this;
      }
      return localUnmodifiableNavigableSet1;
    }
    
    public E floor(E paramE)
    {
      return this.delegate.floor(paramE);
    }
    
    public NavigableSet<E> headSet(E paramE, boolean paramBoolean)
    {
      return Sets.unmodifiableNavigableSet(this.delegate.headSet(paramE, paramBoolean));
    }
    
    public E higher(E paramE)
    {
      return this.delegate.higher(paramE);
    }
    
    public E lower(E paramE)
    {
      return this.delegate.lower(paramE);
    }
    
    public E pollFirst()
    {
      throw new UnsupportedOperationException();
    }
    
    public E pollLast()
    {
      throw new UnsupportedOperationException();
    }
    
    public NavigableSet<E> subSet(E paramE1, boolean paramBoolean1, E paramE2, boolean paramBoolean2)
    {
      return Sets.unmodifiableNavigableSet(this.delegate.subSet(paramE1, paramBoolean1, paramE2, paramBoolean2));
    }
    
    public NavigableSet<E> tailSet(E paramE, boolean paramBoolean)
    {
      return Sets.unmodifiableNavigableSet(this.delegate.tailSet(paramE, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets
 * JD-Core Version:    0.7.0.1
 */