package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NoSuchElementException;

class ForwardingNavigableMap$StandardDescendingMap$1
  implements Iterator<Map.Entry<K, V>>
{
  private Map.Entry<K, V> nextOrNull = this.this$1.forward().lastEntry();
  private Map.Entry<K, V> toRemove = null;
  
  ForwardingNavigableMap$StandardDescendingMap$1(ForwardingNavigableMap.StandardDescendingMap paramStandardDescendingMap) {}
  
  public boolean hasNext()
  {
    return this.nextOrNull != null;
  }
  
  public Map.Entry<K, V> next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    try
    {
      Map.Entry localEntry = this.nextOrNull;
      return localEntry;
    }
    finally
    {
      this.toRemove = this.nextOrNull;
      this.nextOrNull = this.this$1.forward().lowerEntry(this.nextOrNull.getKey());
    }
  }
  
  public void remove()
  {
    if (this.toRemove != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      this.this$1.forward().remove(this.toRemove.getKey());
      this.toRemove = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.1
 * JD-Core Version:    0.7.0.1
 */