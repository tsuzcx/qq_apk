package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map.Entry;

final class Maps$1
  extends TransformedIterator<K, Map.Entry<K, V>>
{
  Maps$1(Iterator paramIterator, Function paramFunction)
  {
    super(paramIterator);
  }
  
  Map.Entry<K, V> transform(K paramK)
  {
    return Maps.immutableEntry(paramK, this.val$function.apply(paramK));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.1
 * JD-Core Version:    0.7.0.1
 */