package com.google.common.collect;

import java.util.Iterator;

class ImmutableMultiset$1
  extends UnmodifiableIterator<E>
{
  E element;
  int remaining;
  
  ImmutableMultiset$1(ImmutableMultiset paramImmutableMultiset, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return (this.remaining > 0) || (this.val$entryIterator.hasNext());
  }
  
  public E next()
  {
    if (this.remaining <= 0)
    {
      Multiset.Entry localEntry = (Multiset.Entry)this.val$entryIterator.next();
      this.element = localEntry.getElement();
      this.remaining = localEntry.getCount();
    }
    this.remaining -= 1;
    return this.element;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableMultiset.1
 * JD-Core Version:    0.7.0.1
 */