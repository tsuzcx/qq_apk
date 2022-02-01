package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated=true)
abstract class AggregateFutureState
{
  private static final AtomicHelper ATOMIC_HELPER;
  private static final Logger log = Logger.getLogger(AggregateFutureState.class.getName());
  private volatile int remaining;
  private volatile Set<Throwable> seenExceptions = null;
  
  static
  {
    try
    {
      SafeAtomicHelper localSafeAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "remaining"));
      ATOMIC_HELPER = localSafeAtomicHelper;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        log.log(Level.SEVERE, "SafeAtomicHelper is broken!", localThrowable);
        SynchronizedAtomicHelper localSynchronizedAtomicHelper = new SynchronizedAtomicHelper(null);
      }
    }
  }
  
  AggregateFutureState(int paramInt)
  {
    this.remaining = paramInt;
  }
  
  abstract void addInitialException(Set<Throwable> paramSet);
  
  final int decrementRemainingAndGet()
  {
    return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
  }
  
  final Set<Throwable> getOrInitSeenExceptions()
  {
    Set localSet2 = this.seenExceptions;
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      localSet1 = Sets.newConcurrentHashSet();
      addInitialException(localSet1);
      ATOMIC_HELPER.compareAndSetSeenExceptions(this, null, localSet1);
      localSet1 = this.seenExceptions;
    }
    return localSet1;
  }
  
  static abstract class AtomicHelper
  {
    abstract void compareAndSetSeenExceptions(AggregateFutureState paramAggregateFutureState, Set<Throwable> paramSet1, Set<Throwable> paramSet2);
    
    abstract int decrementAndGetRemainingCount(AggregateFutureState paramAggregateFutureState);
  }
  
  static final class SafeAtomicHelper
    extends AggregateFutureState.AtomicHelper
  {
    final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
    final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;
    
    SafeAtomicHelper(AtomicReferenceFieldUpdater paramAtomicReferenceFieldUpdater, AtomicIntegerFieldUpdater paramAtomicIntegerFieldUpdater)
    {
      super();
      this.seenExceptionsUpdater = paramAtomicReferenceFieldUpdater;
      this.remainingCountUpdater = paramAtomicIntegerFieldUpdater;
    }
    
    void compareAndSetSeenExceptions(AggregateFutureState paramAggregateFutureState, Set<Throwable> paramSet1, Set<Throwable> paramSet2)
    {
      this.seenExceptionsUpdater.compareAndSet(paramAggregateFutureState, paramSet1, paramSet2);
    }
    
    int decrementAndGetRemainingCount(AggregateFutureState paramAggregateFutureState)
    {
      return this.remainingCountUpdater.decrementAndGet(paramAggregateFutureState);
    }
  }
  
  static final class SynchronizedAtomicHelper
    extends AggregateFutureState.AtomicHelper
  {
    private SynchronizedAtomicHelper()
    {
      super();
    }
    
    void compareAndSetSeenExceptions(AggregateFutureState paramAggregateFutureState, Set<Throwable> paramSet1, Set<Throwable> paramSet2)
    {
      try
      {
        if (paramAggregateFutureState.seenExceptions == paramSet1) {
          AggregateFutureState.access$202(paramAggregateFutureState, paramSet2);
        }
        return;
      }
      finally {}
    }
    
    int decrementAndGetRemainingCount(AggregateFutureState paramAggregateFutureState)
    {
      try
      {
        AggregateFutureState.access$310(paramAggregateFutureState);
        int i = paramAggregateFutureState.remaining;
        return i;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AggregateFutureState
 * JD-Core Version:    0.7.0.1
 */