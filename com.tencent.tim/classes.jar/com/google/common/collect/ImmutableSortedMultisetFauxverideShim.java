package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;

@GwtIncompatible
abstract class ImmutableSortedMultisetFauxverideShim<E>
  extends ImmutableMultiset<E>
{
  @Deprecated
  public static <E> ImmutableSortedMultiset.Builder<E> builder()
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> copyOf(E[] paramArrayOfE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> of(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> of(E paramE1, E paramE2)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5)
  {
    throw new UnsupportedOperationException();
  }
  
  @Deprecated
  public static <E> ImmutableSortedMultiset<E> of(E paramE1, E paramE2, E paramE3, E paramE4, E paramE5, E paramE6, E... paramVarArgs)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ImmutableSortedMultisetFauxverideShim
 * JD-Core Version:    0.7.0.1
 */