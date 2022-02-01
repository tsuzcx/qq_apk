package moai.concurrent;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public final class BlockingLIFOQueue<T>
  implements BlockingQueue<T>
{
  private final BlockingDeque<T> deque;
  
  public BlockingLIFOQueue(int paramInt)
  {
    this.deque = new LinkedBlockingDeque(paramInt);
  }
  
  public boolean add(T paramT)
  {
    this.deque.addLast(paramT);
    return true;
  }
  
  public boolean addAll(Collection<? extends T> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      this.deque.add(localObject);
    }
    return true;
  }
  
  public void clear()
  {
    this.deque.clear();
  }
  
  public boolean contains(Object paramObject)
  {
    return this.deque.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    return this.deque.containsAll(paramCollection);
  }
  
  public int drainTo(Collection<? super T> paramCollection)
  {
    return this.deque.drainTo(paramCollection);
  }
  
  public int drainTo(Collection<? super T> paramCollection, int paramInt)
  {
    return this.deque.drainTo(paramCollection, paramInt);
  }
  
  public T element()
  {
    if (this.deque.isEmpty()) {
      throw new NoSuchElementException("empty stack");
    }
    return this.deque.pollLast();
  }
  
  public boolean isEmpty()
  {
    return this.deque.isEmpty();
  }
  
  public Iterator<T> iterator()
  {
    return this.deque.descendingIterator();
  }
  
  public boolean offer(T paramT)
  {
    return this.deque.offerLast(paramT);
  }
  
  public boolean offer(T paramT, long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.deque.offerLast(paramT, paramLong, paramTimeUnit);
  }
  
  public T peek()
  {
    return this.deque.peekLast();
  }
  
  public T poll()
  {
    return this.deque.pollLast();
  }
  
  public T poll(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return this.deque.pollLast(paramLong, paramTimeUnit);
  }
  
  public void put(T paramT)
    throws InterruptedException
  {
    this.deque.putLast(paramT);
  }
  
  public int remainingCapacity()
  {
    return this.deque.size();
  }
  
  public T remove()
  {
    if (this.deque.isEmpty()) {
      throw new NoSuchElementException("empty stack");
    }
    return this.deque.pollLast();
  }
  
  public boolean remove(Object paramObject)
  {
    return this.deque.remove(paramObject);
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    return this.deque.removeAll(paramCollection);
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    return this.deque.retainAll(paramCollection);
  }
  
  public int size()
  {
    return this.deque.size();
  }
  
  public T take()
    throws InterruptedException
  {
    return this.deque.takeLast();
  }
  
  public Object[] toArray()
  {
    return this.deque.toArray();
  }
  
  public <R> R[] toArray(R[] paramArrayOfR)
  {
    return this.deque.toArray(paramArrayOfR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.concurrent.BlockingLIFOQueue
 * JD-Core Version:    0.7.0.1
 */