package com.google.common.collect;

import java.util.Set;

final class Sets$4
  extends Sets.SetView<E>
{
  Sets$4(Set paramSet1, Set paramSet2)
  {
    super(null);
  }
  
  public boolean contains(Object paramObject)
  {
    return this.val$set1.contains(paramObject) ^ this.val$set2.contains(paramObject);
  }
  
  public boolean isEmpty()
  {
    return this.val$set1.equals(this.val$set2);
  }
  
  public UnmodifiableIterator<E> iterator()
  {
    return new Sets.4.1(this, this.val$set1.iterator(), this.val$set2.iterator());
  }
  
  public int size()
  {
    return Iterators.size(iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.4
 * JD-Core Version:    0.7.0.1
 */