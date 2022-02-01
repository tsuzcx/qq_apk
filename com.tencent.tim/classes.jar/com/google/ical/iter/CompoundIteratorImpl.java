package com.google.ical.iter;

import com.google.ical.values.DateValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

final class CompoundIteratorImpl
  implements RecurrenceIterator
{
  private int nInclusionsRemaining;
  private HeapElement pending;
  private PriorityQueue<HeapElement> queue;
  
  CompoundIteratorImpl(Collection<RecurrenceIterator> paramCollection1, Collection<RecurrenceIterator> paramCollection2)
  {
    this.queue = new PriorityQueue(paramCollection1.size() + paramCollection2.size(), HeapElement.CMP);
    paramCollection1 = paramCollection1.iterator();
    while (paramCollection1.hasNext())
    {
      HeapElement localHeapElement = new HeapElement(true, (RecurrenceIterator)paramCollection1.next());
      if (localHeapElement.shift())
      {
        this.queue.add(localHeapElement);
        this.nInclusionsRemaining += 1;
      }
    }
    paramCollection1 = paramCollection2.iterator();
    while (paramCollection1.hasNext())
    {
      paramCollection2 = new HeapElement(false, (RecurrenceIterator)paramCollection1.next());
      if (paramCollection2.shift()) {
        this.queue.add(paramCollection2);
      }
    }
  }
  
  private void reattach(HeapElement paramHeapElement)
  {
    if (paramHeapElement.shift()) {}
    int i;
    do
    {
      this.queue.add(paramHeapElement);
      do
      {
        return;
      } while (!paramHeapElement.inclusion);
      i = this.nInclusionsRemaining - 1;
      this.nInclusionsRemaining = i;
    } while (i != 0);
    this.queue.clear();
  }
  
  private void requirePending()
  {
    if (this.pending != null) {}
    label29:
    label62:
    label78:
    label217:
    for (;;)
    {
      return;
      long l1 = -9223372036854775808L;
      for (;;)
      {
        if ((this.nInclusionsRemaining == 0) || (this.queue.isEmpty())) {
          break label217;
        }
        HeapElement localHeapElement1 = (HeapElement)this.queue.poll();
        long l2;
        int i;
        HeapElement localHeapElement2;
        if (localHeapElement1.inclusion)
        {
          l2 = l1;
          if (l1 == localHeapElement1.comparable()) {
            break label154;
          }
          l2 = localHeapElement1.comparable();
          if (l1 != l2) {
            break label189;
          }
          i = 1;
          if ((this.queue.isEmpty()) || (((HeapElement)this.queue.peek()).comparable() != l2)) {
            break label199;
          }
          localHeapElement2 = (HeapElement)this.queue.poll();
          if (localHeapElement2.inclusion) {
            break label194;
          }
        }
        for (int j = 1;; j = 0)
        {
          i |= j;
          reattach(localHeapElement2);
          if (this.nInclusionsRemaining != 0) {
            break label78;
          }
          return;
          l2 = localHeapElement1.comparable();
          reattach(localHeapElement1);
          if (this.nInclusionsRemaining == 0) {
            break;
          }
          l1 = l2;
          if (!this.queue.isEmpty()) {
            break label29;
          }
          localHeapElement1 = null;
          l1 = l2;
          break label62;
          i = 0;
          break label78;
        }
        if (i == 0)
        {
          this.pending = localHeapElement1;
          return;
        }
        reattach(localHeapElement1);
      }
    }
  }
  
  public void advanceTo(DateValue paramDateValue)
  {
    long l = DateValueComparison.comparable(paramDateValue);
    if (this.pending != null) {
      if (this.pending.comparable() < l) {}
    }
    for (;;)
    {
      return;
      this.pending.advanceTo(paramDateValue);
      reattach(this.pending);
      this.pending = null;
      while ((this.nInclusionsRemaining != 0) && (!this.queue.isEmpty()) && (((HeapElement)this.queue.peek()).comparable() < l))
      {
        HeapElement localHeapElement = (HeapElement)this.queue.poll();
        localHeapElement.advanceTo(paramDateValue);
        reattach(localHeapElement);
      }
    }
  }
  
  public boolean hasNext()
  {
    requirePending();
    return this.pending != null;
  }
  
  public DateValue next()
  {
    requirePending();
    if (this.pending == null) {
      throw new NoSuchElementException();
    }
    DateValue localDateValue = this.pending.head();
    reattach(this.pending);
    this.pending = null;
    return localDateValue;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.CompoundIteratorImpl
 * JD-Core Version:    0.7.0.1
 */