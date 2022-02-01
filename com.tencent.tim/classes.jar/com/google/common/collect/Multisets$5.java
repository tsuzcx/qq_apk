package com.google.common.collect;

import com.google.common.primitives.Ints;

final class Multisets$5
  extends Ordering<Multiset.Entry<?>>
{
  public int compare(Multiset.Entry<?> paramEntry1, Multiset.Entry<?> paramEntry2)
  {
    return Ints.compare(paramEntry2.getCount(), paramEntry1.getCount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multisets.5
 * JD-Core Version:    0.7.0.1
 */