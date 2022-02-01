package com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class AbstractBiMap$1
  implements Iterator<Map.Entry<K, V>>
{
  Map.Entry<K, V> entry;
  
  AbstractBiMap$1(AbstractBiMap paramAbstractBiMap, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return this.val$iterator.hasNext();
  }
  
  public Map.Entry<K, V> next()
  {
    this.entry = ((Map.Entry)this.val$iterator.next());
    return new AbstractBiMap.BiMapEntry(this.this$0, this.entry);
  }
  
  public void remove()
  {
    if (this.entry != null) {}
    for (boolean bool = true;; bool = false)
    {
      CollectPreconditions.checkRemove(bool);
      Object localObject = this.entry.getValue();
      this.val$iterator.remove();
      AbstractBiMap.access$600(this.this$0, localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.AbstractBiMap.1
 * JD-Core Version:    0.7.0.1
 */