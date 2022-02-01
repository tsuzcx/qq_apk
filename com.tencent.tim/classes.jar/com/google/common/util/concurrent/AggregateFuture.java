package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AggregateFuture<InputT, OutputT>
  extends AbstractFuture.TrustedFuture<OutputT>
{
  private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
  private AggregateFuture<InputT, OutputT>.RunningState runningState;
  
  private static boolean addCausalChain(Set<Throwable> paramSet, Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if (!paramSet.add(paramThrowable)) {
        return false;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return true;
  }
  
  protected final void afterDone()
  {
    super.afterDone();
    Object localObject = this.runningState;
    if (localObject != null)
    {
      this.runningState = null;
      ImmutableCollection localImmutableCollection = ((RunningState)localObject).futures;
      boolean bool2 = wasInterrupted();
      if (wasInterrupted()) {
        ((RunningState)localObject).interruptTask();
      }
      boolean bool3 = isCancelled();
      if (localImmutableCollection != null) {}
      for (boolean bool1 = true; (bool1 & bool3); bool1 = false)
      {
        localObject = localImmutableCollection.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ListenableFuture)((Iterator)localObject).next()).cancel(bool2);
        }
      }
    }
  }
  
  final void init(AggregateFuture<InputT, OutputT>.RunningState paramAggregateFuture)
  {
    this.runningState = paramAggregateFuture;
    paramAggregateFuture.init();
  }
  
  abstract class RunningState
    extends AggregateFutureState
    implements Runnable
  {
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;
    
    RunningState(boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.futures = ((ImmutableCollection)Preconditions.checkNotNull(paramBoolean1));
      this.allMustSucceed = paramBoolean2;
      boolean bool;
      this.collectsValues = bool;
    }
    
    private void decrementCountAndMaybeComplete()
    {
      int i = decrementRemainingAndGet();
      if (i >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkState(bool, "Less than 0 remaining futures");
        if (i == 0) {
          processCompleted();
        }
        return;
      }
    }
    
    private void handleException(Throwable paramThrowable)
    {
      boolean bool1 = true;
      Preconditions.checkNotNull(paramThrowable);
      boolean bool3;
      boolean bool2;
      if (this.allMustSucceed)
      {
        bool3 = AggregateFuture.this.setException(paramThrowable);
        if (bool3)
        {
          releaseResourcesAfterFailure();
          bool2 = true;
        }
      }
      for (;;)
      {
        boolean bool4 = paramThrowable instanceof Error;
        boolean bool5 = this.allMustSucceed;
        if (!bool3) {
          label52:
          if ((bool2 & bool1 & bool5 | bool4)) {
            if (!(paramThrowable instanceof Error)) {
              break label105;
            }
          }
        }
        label105:
        for (String str = "Input Future failed with Error";; str = "Got more than one input Future failure. Logging failures after the first")
        {
          AggregateFuture.logger.log(Level.SEVERE, str, paramThrowable);
          return;
          bool2 = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), paramThrowable);
          break;
          bool1 = false;
          break label52;
        }
        bool2 = true;
        bool3 = false;
      }
    }
    
    private void handleOneInputDone(int paramInt, Future<? extends InputT> paramFuture)
    {
      boolean bool = false;
      if ((this.allMustSucceed) || (!AggregateFuture.this.isDone()) || (AggregateFuture.this.isCancelled())) {
        bool = true;
      }
      Preconditions.checkState(bool, "Future was done before all dependencies completed");
      try
      {
        Preconditions.checkState(paramFuture.isDone(), "Tried to set value from future which is not done");
        if (this.allMustSucceed)
        {
          if (paramFuture.isCancelled())
          {
            AggregateFuture.access$602(AggregateFuture.this, null);
            AggregateFuture.this.cancel(false);
            return;
          }
          paramFuture = Futures.getDone(paramFuture);
          if (!this.collectsValues) {
            return;
          }
          collectOneValue(this.allMustSucceed, paramInt, paramFuture);
        }
      }
      catch (ExecutionException paramFuture)
      {
        handleException(paramFuture.getCause());
        return;
        if ((this.collectsValues) && (!paramFuture.isCancelled()))
        {
          collectOneValue(this.allMustSucceed, paramInt, Futures.getDone(paramFuture));
          return;
        }
      }
      catch (Throwable paramFuture)
      {
        handleException(paramFuture);
      }
    }
    
    private void init()
    {
      if (this.futures.isEmpty()) {
        handleAllCompleted();
      }
      for (;;)
      {
        return;
        Iterator localIterator;
        if (this.allMustSucceed)
        {
          localIterator = this.futures.iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            ListenableFuture localListenableFuture = (ListenableFuture)localIterator.next();
            localListenableFuture.addListener(new AggregateFuture.RunningState.1(this, i, localListenableFuture), MoreExecutors.directExecutor());
            i += 1;
          }
        }
        else
        {
          localIterator = this.futures.iterator();
          while (localIterator.hasNext()) {
            ((ListenableFuture)localIterator.next()).addListener(this, MoreExecutors.directExecutor());
          }
        }
      }
    }
    
    private void processCompleted()
    {
      boolean bool = this.collectsValues;
      if (!this.allMustSucceed) {}
      int j;
      for (int i = 1; (i & bool) != 0; j = 0)
      {
        Iterator localIterator = this.futures.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          handleOneInputDone(i, (ListenableFuture)localIterator.next());
          i += 1;
        }
      }
      handleAllCompleted();
    }
    
    final void addInitialException(Set<Throwable> paramSet)
    {
      if (!AggregateFuture.this.isCancelled()) {
        AggregateFuture.addCausalChain(paramSet, AggregateFuture.this.trustedGetException());
      }
    }
    
    abstract void collectOneValue(boolean paramBoolean, int paramInt, @Nullable InputT paramInputT);
    
    abstract void handleAllCompleted();
    
    void interruptTask() {}
    
    void releaseResourcesAfterFailure()
    {
      this.futures = null;
    }
    
    public final void run()
    {
      decrementCountAndMaybeComplete();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.AggregateFuture
 * JD-Core Version:    0.7.0.1
 */