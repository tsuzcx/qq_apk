package com.google.common.collect;

import com.google.common.base.Function;
import java.util.ListIterator;

class Lists$TransformingRandomAccessList$1
  extends TransformedListIterator<F, T>
{
  Lists$TransformingRandomAccessList$1(Lists.TransformingRandomAccessList paramTransformingRandomAccessList, ListIterator paramListIterator)
  {
    super(paramListIterator);
  }
  
  T transform(F paramF)
  {
    return this.this$0.function.apply(paramF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Lists.TransformingRandomAccessList.1
 * JD-Core Version:    0.7.0.1
 */