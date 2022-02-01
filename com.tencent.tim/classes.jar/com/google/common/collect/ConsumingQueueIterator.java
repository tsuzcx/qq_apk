package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;

@GwtCompatible
class ConsumingQueueIterator<T>
  extends AbstractIterator<T>
{
  private final Queue<T> queue;
  
  ConsumingQueueIterator(Queue<T> paramQueue)
  {
    this.queue = ((Queue)Preconditions.checkNotNull(paramQueue));
  }
  
  ConsumingQueueIterator(T... paramVarArgs)
  {
    this.queue = new ArrayDeque(paramVarArgs.length);
    Collections.addAll(this.queue, paramVarArgs);
  }
  
  public T computeNext()
  {
    if (this.queue.isEmpty()) {
      return endOfData();
    }
    return this.queue.remove();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ConsumingQueueIterator
 * JD-Core Version:    0.7.0.1
 */