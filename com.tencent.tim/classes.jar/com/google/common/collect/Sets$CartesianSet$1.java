package com.google.common.collect;

import java.util.List;

final class Sets$CartesianSet$1
  extends ImmutableList<List<E>>
{
  Sets$CartesianSet$1(ImmutableList paramImmutableList) {}
  
  public List<E> get(int paramInt)
  {
    return ((ImmutableSet)this.val$axes.get(paramInt)).asList();
  }
  
  boolean isPartialView()
  {
    return true;
  }
  
  public int size()
  {
    return this.val$axes.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Sets.CartesianSet.1
 * JD-Core Version:    0.7.0.1
 */