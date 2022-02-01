package com.google.common.collect;

import java.util.NoSuchElementException;

class Sets$SubSet$1
  extends UnmodifiableIterator<E>
{
  final ImmutableList<E> elements = Sets.SubSet.access$100(this.this$0).keySet().asList();
  int remainingSetBits = Sets.SubSet.access$200(this.this$0);
  
  Sets$SubSet$1(Sets.SubSet paramSubSet) {}
  
  public boolean hasNext()
  {
    return this.remainingSetBits != 0;
  }
  
  public E next()
  {
    int i = Integer.numberOfTrailingZeros(this.remainingSetBits);
    if (i == 32) {
      throw new NoSuchElementException();
    }
    this.remainingSetBits &= (1 << i ^ 0xFFFFFFFF);
    return this.elements.get(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.SubSet.1
 * JD-Core Version:    0.7.0.1
 */