package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ListIterator;
import java.util.NoSuchElementException;

class Lists$ReverseList$1
  implements ListIterator<T>
{
  boolean canRemoveOrSet;
  
  Lists$ReverseList$1(Lists.ReverseList paramReverseList, ListIterator paramListIterator) {}
  
  public void add(T paramT)
  {
    this.val$forwardIterator.add(paramT);
    this.val$forwardIterator.previous();
    this.canRemoveOrSet = false;
  }
  
  public boolean hasNext()
  {
    return this.val$forwardIterator.hasPrevious();
  }
  
  public boolean hasPrevious()
  {
    return this.val$forwardIterator.hasNext();
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.canRemoveOrSet = true;
    return this.val$forwardIterator.previous();
  }
  
  public int nextIndex()
  {
    return Lists.ReverseList.access$000(this.this$0, this.val$forwardIterator.nextIndex());
  }
  
  public T previous()
  {
    if (!hasPrevious()) {
      throw new NoSuchElementException();
    }
    this.canRemoveOrSet = true;
    return this.val$forwardIterator.next();
  }
  
  public int previousIndex()
  {
    return nextIndex() - 1;
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(this.canRemoveOrSet);
    this.val$forwardIterator.remove();
    this.canRemoveOrSet = false;
  }
  
  public void set(T paramT)
  {
    Preconditions.checkState(this.canRemoveOrSet);
    this.val$forwardIterator.set(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Lists.ReverseList.1
 * JD-Core Version:    0.7.0.1
 */