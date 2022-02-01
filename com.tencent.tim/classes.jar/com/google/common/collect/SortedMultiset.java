package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;

@GwtCompatible(emulated=true)
public abstract interface SortedMultiset<E>
  extends SortedIterable<E>, SortedMultisetBridge<E>
{
  public abstract Comparator<? super E> comparator();
  
  public abstract SortedMultiset<E> descendingMultiset();
  
  public abstract NavigableSet<E> elementSet();
  
  public abstract Set<Multiset.Entry<E>> entrySet();
  
  public abstract Multiset.Entry<E> firstEntry();
  
  public abstract SortedMultiset<E> headMultiset(E paramE, BoundType paramBoundType);
  
  public abstract Iterator<E> iterator();
  
  public abstract Multiset.Entry<E> lastEntry();
  
  public abstract Multiset.Entry<E> pollFirstEntry();
  
  public abstract Multiset.Entry<E> pollLastEntry();
  
  public abstract SortedMultiset<E> subMultiset(E paramE1, BoundType paramBoundType1, E paramE2, BoundType paramBoundType2);
  
  public abstract SortedMultiset<E> tailMultiset(E paramE, BoundType paramBoundType);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.SortedMultiset
 * JD-Core Version:    0.7.0.1
 */