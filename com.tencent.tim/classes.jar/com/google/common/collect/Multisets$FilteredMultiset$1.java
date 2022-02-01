package com.google.common.collect;

import com.google.common.base.Predicate;

class Multisets$FilteredMultiset$1
  implements Predicate<Multiset.Entry<E>>
{
  Multisets$FilteredMultiset$1(Multisets.FilteredMultiset paramFilteredMultiset) {}
  
  public boolean apply(Multiset.Entry<E> paramEntry)
  {
    return this.this$0.predicate.apply(paramEntry.getElement());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.FilteredMultiset.1
 * JD-Core Version:    0.7.0.1
 */