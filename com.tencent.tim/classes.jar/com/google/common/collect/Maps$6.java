package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

final class Maps$6
  extends UnmodifiableIterator<Map.Entry<K, V>>
{
  Maps$6(Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$entryIterator.hasNext();
  }
  
  public Map.Entry<K, V> next()
  {
    return Maps.unmodifiableEntry((Map.Entry)this.val$entryIterator.next());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Maps.6
 * JD-Core Version:    0.7.0.1
 */