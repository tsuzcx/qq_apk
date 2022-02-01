package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

final class Multisets$2
  extends AbstractMultiset<E>
{
  Multisets$2(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public int count(Object paramObject)
  {
    int i = this.val$multiset1.count(paramObject);
    if (i == 0) {
      return 0;
    }
    return Math.min(i, this.val$multiset2.count(paramObject));
  }
  
  Set<E> createElementSet()
  {
    return Sets.intersection(this.val$multiset1.elementSet(), this.val$multiset2.elementSet());
  }
  
  int distinctElements()
  {
    return elementSet().size();
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return new Multisets.2.1(this, this.val$multiset1.entrySet().iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.2
 * JD-Core Version:    0.7.0.1
 */