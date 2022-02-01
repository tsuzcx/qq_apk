package com.google.common.collect;

import java.util.Iterator;

class AbstractSortedMultiset$1DescendingMultisetImpl
  extends DescendingMultiset<E>
{
  AbstractSortedMultiset$1DescendingMultisetImpl(AbstractSortedMultiset paramAbstractSortedMultiset) {}
  
  Iterator<Multiset.Entry<E>> entryIterator()
  {
    return this.this$0.descendingEntryIterator();
  }
  
  SortedMultiset<E> forwardMultiset()
  {
    return this.this$0;
  }
  
  public Iterator<E> iterator()
  {
    return this.this$0.descendingIterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractSortedMultiset.1DescendingMultisetImpl
 * JD-Core Version:    0.7.0.1
 */