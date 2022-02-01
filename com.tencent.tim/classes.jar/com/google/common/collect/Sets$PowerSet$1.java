package com.google.common.collect;

import java.util.Set;

class Sets$PowerSet$1
  extends AbstractIndexedListIterator<Set<E>>
{
  Sets$PowerSet$1(Sets.PowerSet paramPowerSet, int paramInt)
  {
    super(paramInt);
  }
  
  protected Set<E> get(int paramInt)
  {
    return new Sets.SubSet(this.this$0.inputSet, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.PowerSet.1
 * JD-Core Version:    0.7.0.1
 */