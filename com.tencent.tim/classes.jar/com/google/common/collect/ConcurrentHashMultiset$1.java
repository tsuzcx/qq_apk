package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import javax.annotation.Nullable;

class ConcurrentHashMultiset$1
  extends ForwardingSet<E>
{
  ConcurrentHashMultiset$1(ConcurrentHashMultiset paramConcurrentHashMultiset, Set paramSet) {}
  
  public boolean contains(@Nullable Object paramObject)
  {
    return (paramObject != null) && (Collections2.safeContains(this.val$delegate, paramObject));
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return standardContainsAll(paramCollection);
  }
  
  protected Set<E> delegate()
  {
    return this.val$delegate;
  }
  
  public boolean remove(Object paramObject)
  {
    return (paramObject != null) && (Collections2.safeRemove(this.val$delegate, paramObject));
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return standardRemoveAll(paramCollection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ConcurrentHashMultiset.1
 * JD-Core Version:    0.7.0.1
 */