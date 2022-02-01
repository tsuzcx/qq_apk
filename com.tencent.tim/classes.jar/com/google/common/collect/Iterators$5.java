package com.google.common.collect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class Iterators$5
  extends UnmodifiableIterator<List<T>>
{
  Iterators$5(Iterator paramIterator, int paramInt, boolean paramBoolean) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public List<T> next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    Object localObject = new Object[this.val$size];
    int i = 0;
    while ((i < this.val$size) && (this.val$iterator.hasNext()))
    {
      localObject[i] = this.val$iterator.next();
      i += 1;
    }
    int j = i;
    while (j < this.val$size)
    {
      localObject[j] = null;
      j += 1;
    }
    localObject = Collections.unmodifiableList(Arrays.asList((Object[])localObject));
    if ((this.val$pad) || (i == this.val$size)) {
      return localObject;
    }
    return ((List)localObject).subList(0, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.5
 * JD-Core Version:    0.7.0.1
 */