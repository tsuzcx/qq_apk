package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.j2objc.annotations.Weak;

@GwtCompatible(emulated=true)
class RegularImmutableAsList<E>
  extends ImmutableAsList<E>
{
  @Weak
  private final ImmutableCollection<E> delegate;
  private final ImmutableList<? extends E> delegateList;
  
  RegularImmutableAsList(ImmutableCollection<E> paramImmutableCollection, ImmutableList<? extends E> paramImmutableList)
  {
    this.delegate = paramImmutableCollection;
    this.delegateList = paramImmutableList;
  }
  
  RegularImmutableAsList(ImmutableCollection<E> paramImmutableCollection, Object[] paramArrayOfObject)
  {
    this(paramImmutableCollection, ImmutableList.asImmutableList(paramArrayOfObject));
  }
  
  @GwtIncompatible
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    return this.delegateList.copyIntoArray(paramArrayOfObject, paramInt);
  }
  
  ImmutableCollection<E> delegateCollection()
  {
    return this.delegate;
  }
  
  ImmutableList<? extends E> delegateList()
  {
    return this.delegateList;
  }
  
  public E get(int paramInt)
  {
    return this.delegateList.get(paramInt);
  }
  
  public UnmodifiableListIterator<E> listIterator(int paramInt)
  {
    return this.delegateList.listIterator(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableAsList
 * JD-Core Version:    0.7.0.1
 */