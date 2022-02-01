package com.google.common.collect;

import java.util.Iterator;
import java.util.List;

final class Iterables$7
  extends FluentIterable<T>
{
  Iterables$7(List paramList, int paramInt) {}
  
  public Iterator<T> iterator()
  {
    int i = Math.min(this.val$list.size(), this.val$numberToSkip);
    return this.val$list.subList(i, this.val$list.size()).iterator();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterables.7
 * JD-Core Version:    0.7.0.1
 */