package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$4
  extends AbstractMultiset<E>
{
  Multisets$4(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public int count(@Nullable Object paramObject)
  {
    int i = this.val$multiset1.count(paramObject);
    if (i == 0) {
      return 0;
    }
    return Math.max(0, i - this.val$multiset2.count(paramObject));
  }
  
  int distinctElements()
  {
    return Iterators.size(entryIterator());
  }
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return new Multisets.4.1(this, this.val$multiset1.entrySet().iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.4
 * JD-Core Version:    0.7.0.1
 */