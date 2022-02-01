package com.google.common.collect;

import java.util.Iterator;
import java.util.Set;

class DescendingMultiset$1EntrySetImpl
  extends Multisets.EntrySet<E>
{
  DescendingMultiset$1EntrySetImpl(DescendingMultiset paramDescendingMultiset) {}
  
  public Iterator<Multiset.Entry<E>> iterator()
  {
    return this.this$0.entryIterator();
  }
  
  Multiset<E> multiset()
  {
    return this.this$0;
  }
  
  public int size()
  {
    return this.this$0.forwardMultiset().entrySet().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.DescendingMultiset.1EntrySetImpl
 * JD-Core Version:    0.7.0.1
 */