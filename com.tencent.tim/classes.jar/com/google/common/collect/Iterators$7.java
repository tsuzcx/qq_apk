package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

final class Iterators$7
  extends TransformedIterator<F, T>
{
  Iterators$7(Iterator paramIterator, Function paramFunction)
  {
    super(paramIterator);
  }
  
  T transform(F paramF)
  {
    return this.val$function.apply(paramF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Iterators.7
 * JD-Core Version:    0.7.0.1
 */