package com.qzone.utils.http.pool;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

abstract class RouteSpecificPool<T, C, E extends PoolEntry<T, C>>
{
  private final LinkedList<E> available;
  private final Set<E> leased;
  private final LinkedList<PoolEntryFuture<E>> pending;
  private final T route;
  
  RouteSpecificPool(T paramT)
  {
    this.route = paramT;
    this.leased = new HashSet();
    this.available = new LinkedList();
    this.pending = new LinkedList();
  }
  
  public E add(C paramC)
  {
    paramC = createEntry(paramC);
    this.leased.add(paramC);
    return paramC;
  }
  
  protected abstract E createEntry(C paramC);
  
  public void free(E paramE, boolean paramBoolean)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    if (!this.leased.remove(paramE)) {
      throw new IllegalStateException("Entry " + paramE + " has not been leased from this pool");
    }
    if (paramBoolean) {
      this.available.addFirst(paramE);
    }
  }
  
  public int getAllocatedCount()
  {
    return this.available.size() + this.leased.size();
  }
  
  public int getAvailableCount()
  {
    return this.available.size();
  }
  
  public E getFree(Object paramObject)
  {
    Object localObject;
    if (!this.available.isEmpty())
    {
      if (paramObject != null)
      {
        localObject = this.available.iterator();
        if (((Iterator)localObject).hasNext()) {
          break label50;
        }
      }
      paramObject = this.available.iterator();
    }
    label50:
    do
    {
      if (!paramObject.hasNext())
      {
        return null;
        PoolEntry localPoolEntry = (PoolEntry)((Iterator)localObject).next();
        if (!paramObject.equals(localPoolEntry.getState())) {
          break;
        }
        ((Iterator)localObject).remove();
        this.leased.add(localPoolEntry);
        return localPoolEntry;
      }
      localObject = (PoolEntry)paramObject.next();
    } while (((PoolEntry)localObject).getState() != null);
    paramObject.remove();
    this.leased.add(localObject);
    return localObject;
  }
  
  public E getLastUsed()
  {
    if (!this.available.isEmpty()) {
      return (PoolEntry)this.available.getLast();
    }
    return null;
  }
  
  public int getLeasedCount()
  {
    return this.leased.size();
  }
  
  public int getPendingCount()
  {
    return this.pending.size();
  }
  
  public final T getRoute()
  {
    return this.route;
  }
  
  public PoolEntryFuture<E> nextPending()
  {
    return (PoolEntryFuture)this.pending.poll();
  }
  
  public void queue(PoolEntryFuture<E> paramPoolEntryFuture)
  {
    if (paramPoolEntryFuture == null) {
      return;
    }
    this.pending.add(paramPoolEntryFuture);
  }
  
  public boolean remove(E paramE)
  {
    if (paramE == null) {
      throw new IllegalArgumentException("Pool entry may not be null");
    }
    return (this.available.remove(paramE)) || (this.leased.remove(paramE));
  }
  
  public void shutdown()
  {
    Iterator localIterator = this.pending.iterator();
    if (!localIterator.hasNext())
    {
      this.pending.clear();
      localIterator = this.available.iterator();
      label32:
      if (localIterator.hasNext()) {
        break label94;
      }
      this.available.clear();
      localIterator = this.leased.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        this.leased.clear();
        return;
        ((PoolEntryFuture)localIterator.next()).cancel(true);
        break;
        label94:
        ((PoolEntry)localIterator.next()).close();
        break label32;
      }
      ((PoolEntry)localIterator.next()).close();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[route: ");
    localStringBuilder.append(this.route);
    localStringBuilder.append("][leased: ");
    localStringBuilder.append(this.leased.size());
    localStringBuilder.append("][available: ");
    localStringBuilder.append(this.available.size());
    localStringBuilder.append("][pending: ");
    localStringBuilder.append(this.pending.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void unqueue(PoolEntryFuture<E> paramPoolEntryFuture)
  {
    if (paramPoolEntryFuture == null) {
      return;
    }
    this.pending.remove(paramPoolEntryFuture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.http.pool.RouteSpecificPool
 * JD-Core Version:    0.7.0.1
 */