package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

@Beta
@GwtCompatible
public final class EvictingQueue<E>
  extends ForwardingQueue<E>
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private final Queue<E> delegate;
  @VisibleForTesting
  final int maxSize;
  
  private EvictingQueue(int paramInt)
  {
    if (paramInt >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Preconditions.checkArgument(bool, "maxSize (%s) must >= 0", paramInt);
      this.delegate = new ArrayDeque(paramInt);
      this.maxSize = paramInt;
      return;
    }
  }
  
  public static <E> EvictingQueue<E> create(int paramInt)
  {
    return new EvictingQueue(paramInt);
  }
  
  @CanIgnoreReturnValue
  public boolean add(E paramE)
  {
    Preconditions.checkNotNull(paramE);
    if (this.maxSize == 0) {
      return true;
    }
    if (size() == this.maxSize) {
      this.delegate.remove();
    }
    this.delegate.add(paramE);
    return true;
  }
  
  @CanIgnoreReturnValue
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    int i = paramCollection.size();
    if (i >= this.maxSize)
    {
      clear();
      return Iterables.addAll(this, Iterables.skip(paramCollection, i - this.maxSize));
    }
    return standardAddAll(paramCollection);
  }
  
  public boolean contains(Object paramObject)
  {
    return delegate().contains(Preconditions.checkNotNull(paramObject));
  }
  
  protected Queue<E> delegate()
  {
    return this.delegate;
  }
  
  @CanIgnoreReturnValue
  public boolean offer(E paramE)
  {
    return add(paramE);
  }
  
  public int remainingCapacity()
  {
    return this.maxSize - size();
  }
  
  @CanIgnoreReturnValue
  public boolean remove(Object paramObject)
  {
    return delegate().remove(Preconditions.checkNotNull(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.EvictingQueue
 * JD-Core Version:    0.7.0.1
 */