package com.google.common.collect;

import java.util.Iterator;

class ConcurrentHashMultiset$3
  extends ForwardingIterator<Multiset.Entry<E>>
{
  private Multiset.Entry<E> last;
  
  ConcurrentHashMultiset$3(ConcurrentHashMultiset paramConcurrentHashMultiset, Iterator paramIterator) {}
  
  protected Iterator<Multiset.Entry<E>> delegate()
  {
    return this.val$readOnlyIterator;
  }
  
  public Multiset.Entry<E> next()
  {
    this.last = ((Multiset.Entry)super.next());
    return this.last;
  }
  
  public void remove()
  {
    if (this.last != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.this$0.setCount(this.last.getElement(), 0);
      this.last = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ConcurrentHashMultiset.3
 * JD-Core Version:    0.7.0.1
 */