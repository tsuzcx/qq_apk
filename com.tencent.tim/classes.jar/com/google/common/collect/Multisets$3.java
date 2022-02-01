package com.google.common.collect;

import com.google.common.math.IntMath;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;

final class Multisets$3
  extends AbstractMultiset<E>
{
  Multisets$3(Multiset paramMultiset1, Multiset paramMultiset2) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    return (this.val$multiset1.contains(paramObject)) || (this.val$multiset2.contains(paramObject));
  }
  
  public int count(Object paramObject)
  {
    return this.val$multiset1.count(paramObject) + this.val$multiset2.count(paramObject);
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
    return new Multisets.3.1(this, this.val$multiset1.entrySet().iterator(), this.val$multiset2.entrySet().iterator());
  }
  
  public boolean isEmpty()
  {
    return (this.val$multiset1.isEmpty()) && (this.val$multiset2.isEmpty());
  }
  
  public int size()
  {
    return IntMath.saturatedAdd(this.val$multiset1.size(), this.val$multiset2.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.3
 * JD-Core Version:    0.7.0.1
 */