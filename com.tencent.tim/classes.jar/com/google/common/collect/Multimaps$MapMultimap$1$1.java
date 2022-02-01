package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

class Multimaps$MapMultimap$1$1
  implements Iterator<V>
{
  int i;
  
  Multimaps$MapMultimap$1$1(Multimaps.MapMultimap.1 param1) {}
  
  public boolean hasNext()
  {
    return (this.i == 0) && (this.this$1.this$0.map.containsKey(this.this$1.val$key));
  }
  
  public V next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    this.i += 1;
    return this.this$1.this$0.map.get(this.this$1.val$key);
  }
  
  public void remove()
  {
    boolean bool = true;
    if (this.i == 1) {}
    for (;;)
    {
      CollectPreconditions.checkRemove(bool);
      this.i = -1;
      this.this$1.this$0.map.remove(this.this$1.val$key);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.Multimaps.MapMultimap.1.1
 * JD-Core Version:    0.7.0.1
 */