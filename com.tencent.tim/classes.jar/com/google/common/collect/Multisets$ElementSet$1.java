package com.google.common.collect;

import java.util.Iterator;

class Multisets$ElementSet$1
  extends TransformedIterator<Multiset.Entry<E>, E>
{
  Multisets$ElementSet$1(Multisets.ElementSet paramElementSet, Iterator paramIterator)
  {
    super(paramIterator);
  }
  
  E transform(Multiset.Entry<E> paramEntry)
  {
    return paramEntry.getElement();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.ElementSet.1
 * JD-Core Version:    0.7.0.1
 */