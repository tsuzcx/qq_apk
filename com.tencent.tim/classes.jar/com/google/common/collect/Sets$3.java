package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Set;

final class Sets$3
  extends Sets.SetView<E>
{
  Sets$3(Set paramSet1, Predicate paramPredicate, Set paramSet2)
  {
    super(null);
  }
  
  public boolean contains(Object paramObject)
  {
    return (this.val$set1.contains(paramObject)) && (!this.val$set2.contains(paramObject));
  }
  
  public boolean isEmpty()
  {
    return this.val$set2.containsAll(this.val$set1);
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return Iterators.filter(this.val$set1.iterator(), this.val$notInSet2);
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.3
 * JD-Core Version:    0.7.0.1
 */