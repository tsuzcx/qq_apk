package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
abstract class CollectionFuture<V, C>
  extends AggregateFuture<V, C>
{
  abstract class CollectionFutureRunningState
    extends AggregateFuture<V, C>.RunningState
  {
    private List<Optional<V>> values;
    
    CollectionFutureRunningState(boolean paramBoolean)
    {
      super(paramBoolean, bool, true);
      if (paramBoolean.isEmpty()) {}
      for (this$1 = ImmutableList.of();; this$1 = Lists.newArrayListWithCapacity(paramBoolean.size()))
      {
        this.values = ((List)CollectionFuture.this);
        int i = 0;
        while (i < paramBoolean.size())
        {
          this.values.add(null);
          i += 1;
        }
      }
    }
    
    final void collectOneValue(boolean paramBoolean, int paramInt, @Nullable V paramV)
    {
      List localList = this.values;
      if (localList != null)
      {
        localList.set(paramInt, Optional.fromNullable(paramV));
        return;
      }
      if ((paramBoolean) || (CollectionFuture.this.isCancelled())) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        Preconditions.checkState(paramBoolean, "Future was done before all dependencies completed");
        return;
      }
    }
    
    abstract C combine(List<Optional<V>> paramList);
    
    final void handleAllCompleted()
    {
      List localList = this.values;
      if (localList != null)
      {
        CollectionFuture.this.set(combine(localList));
        return;
      }
      Preconditions.checkState(CollectionFuture.this.isDone());
    }
    
    void releaseResourcesAfterFailure()
    {
      super.releaseResourcesAfterFailure();
      this.values = null;
    }
  }
  
  static final class ListFuture<V>
    extends CollectionFuture<V, List<V>>
  {
    ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> paramImmutableCollection, boolean paramBoolean)
    {
      init(new ListFutureRunningState(paramImmutableCollection, paramBoolean));
    }
    
    final class ListFutureRunningState
      extends CollectionFuture<V, List<V>>.CollectionFutureRunningState
    {
      ListFutureRunningState(boolean paramBoolean)
      {
        super(paramBoolean, bool);
      }
      
      public List<V> combine(List<Optional<V>> paramList)
      {
        ArrayList localArrayList = Lists.newArrayListWithCapacity(paramList.size());
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          paramList = (Optional)localIterator.next();
          if (paramList != null) {}
          for (paramList = paramList.orNull();; paramList = null)
          {
            localArrayList.add(paramList);
            break;
          }
        }
        return Collections.unmodifiableList(localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.CollectionFuture
 * JD-Core Version:    0.7.0.1
 */