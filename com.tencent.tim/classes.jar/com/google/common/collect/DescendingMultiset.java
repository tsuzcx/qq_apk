package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(emulated=true)
abstract class DescendingMultiset<E>
  extends ForwardingMultiset<E>
  implements SortedMultiset<E>
{
  private transient Comparator<? super E> comparator;
  private transient NavigableSet<E> elementSet;
  private transient Set<Multiset.Entry<E>> entrySet;
  
  public Comparator<? super E> comparator()
  {
    Comparator localComparator = this.comparator;
    Object localObject = localComparator;
    if (localComparator == null)
    {
      localObject = Ordering.from(forwardMultiset().comparator()).reverse();
      this.comparator = ((Comparator)localObject);
    }
    return localObject;
  }
  
  Set<Multiset.Entry<E>> createEntrySet()
  {
    return new DescendingMultiset.1EntrySetImpl(this);
  }
  
  protected Multiset<E> delegate()
  {
    return forwardMultiset();
  }
  
  public SortedMultiset<E> descendingMultiset()
  {
    return forwardMultiset();
  }
  
  public NavigableSet<E> elementSet()
  {
    NavigableSet localNavigableSet = this.elementSet;
    Object localObject = localNavigableSet;
    if (localNavigableSet == null)
    {
      localObject = new SortedMultisets.NavigableElementSet(this);
      this.elementSet = ((NavigableSet)localObject);
    }
    return localObject;
  }
  
  abstract Iterator<Multiset.Entry<E>> entryIterator();
  
  public Set<Multiset.Entry<E>> entrySet()
  {
    Set localSet2 = this.entrySet;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = createEntrySet();
      this.entrySet = localSet1;
    }
    return localSet1;
  }
  
  public Multiset.Entry<E> firstEntry()
  {
    return forwardMultiset().lastEntry();
  }
  
  abstract SortedMultiset<E> forwardMultiset();
  
  public SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType)
  {
    return forwardMultiset().tailMultiset(paramE, paramBoundType).descendingMultiset();
  }
  
  public Iterator<E> iterator()
  {
    return Multisets.iteratorImpl(this);
  }
  
  public Multiset.Entry<E> lastEntry()
  {
    return forwardMultiset().firstEntry();
  }
  
  public Multiset.Entry<E> pollFirstEntry()
  {
    return forwardMultiset().pollLastEntry();
  }
  
  public Multiset.Entry<E> pollLastEntry()
  {
    return forwardMultiset().pollFirstEntry();
  }
  
  public SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2)
  {
    return forwardMultiset().subMultiset(paramE2, paramBoundType2, paramE1, paramBoundType1).descendingMultiset();
  }
  
  public SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType)
  {
    return forwardMultiset().headMultiset(paramE, paramBoundType).descendingMultiset();
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
    return entrySet().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.DescendingMultiset
 * JD-Core Version:    0.7.0.1
 */