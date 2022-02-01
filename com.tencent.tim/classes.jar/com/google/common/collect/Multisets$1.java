package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$1
  extends AbstractMultiset<E>
{
  Multisets$1(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    return (this.val$multiset1.contains(paramObject)) || (this.val$multiset2.contains(paramObject));
  }
  
  public int count(Object paramObject)
  {
    return Math.max(this.val$multiset1.count(paramObject), this.val$multiset2.count(paramObject));
  }
  
  Set<E> createElementSet()
  {
    return Sets.union(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
  }
  
  int distinctElements()
  {
    return elementSet().size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return new Multisets.1.1(this, this.val$multiset1.entrySet().iterator(), this.val$multiset2.entrySet().iterator());
  }
  
  public boolean isEmpty()
  {
    return (this.val$multiset1.isEmpty()) && (this.val$multiset2.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.1
 * JD-Core Version:    0.7.0.1
 */