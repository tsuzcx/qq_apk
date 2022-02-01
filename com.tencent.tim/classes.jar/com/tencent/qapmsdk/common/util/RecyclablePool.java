package com.tencent.qapmsdk.common.util;

import com.tencent.qapmsdk.common.logger.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/RecyclablePool;", "", "clz", "Ljava/lang/Class;", "Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;", "cap", "", "(Ljava/lang/Class;I)V", "capacity", "count", "head", "obtain", "recycle", "", "recyclableObject", "Companion", "Recyclable", "common_release"}, k=1, mv={1, 1, 15})
public final class RecyclablePool
{
  public static final Companion Companion = new Companion(null);
  @NotNull
  public static final String TAG = "QAPM_common_RecyclablePool";
  private volatile int capacity;
  private volatile int count;
  private final Recyclable head = new Recyclable();
  
  public RecyclablePool(@NotNull Class<? extends Recyclable> paramClass, int paramInt)
  {
    synchronized (this.head)
    {
      this.capacity = paramInt;
      this.head.setInPool(true);
      int i = this.capacity;
      paramInt = 0;
      for (;;)
      {
        if (paramInt < i) {
          try
          {
            recycle((Recyclable)paramClass.newInstance());
            paramInt += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Logger.INSTANCE.exception("QAPM_common_RecyclablePool", localThrowable);
            }
          }
        }
      }
    }
    paramClass = Unit.INSTANCE;
  }
  
  @Nullable
  public final Recyclable obtain(@NotNull Class<? extends Recyclable> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clz");
    Recyclable localRecyclable1 = (Recyclable)null;
    if (this.count > 0)
    {
      synchronized (this.head)
      {
        localRecyclable1 = this.head.getNext();
        if (localRecyclable1 == null) {
          break label106;
        }
        if (!localRecyclable1.isInPool()) {
          throw ((Throwable)new RuntimeException("recyclable object is not in pool"));
        }
      }
      this.head.changeNext(localRecyclable1.getNext(), false);
      localRecyclable1.setInPool(false);
      this.count -= 1;
      int i = this.count;
      if (localRecyclable1 == null) {
        break label162;
      }
    }
    for (;;)
    {
      return localRecyclable1;
      label106:
      throw ((Throwable)new RuntimeException("recyclable object is null"));
      Logger.INSTANCE.d(new String[] { "QAPM_common_RecyclablePool", "obtain " + this.count });
      break;
      try
      {
        label162:
        localRecyclable1 = (Recyclable)paramClass.newInstance();
      }
      catch (Throwable paramClass)
      {
        Logger.INSTANCE.exception("QAPM_common_RecyclablePool", paramClass);
      }
    }
    return null;
  }
  
  public final void recycle(@Nullable Recyclable paramRecyclable)
  {
    if (paramRecyclable != null)
    {
      paramRecyclable.reset();
      synchronized (this.head)
      {
        if (paramRecyclable.isInPool()) {
          throw ((Throwable)new RuntimeException("recyclableObject has in pool"));
        }
      }
      if (this.count < this.capacity)
      {
        paramRecyclable.changeNext(this.head.getNext(), false);
        this.head.changeNext(paramRecyclable, false);
        paramRecyclable.setInPool(true);
        this.count += 1;
        int i = this.count;
      }
      paramRecyclable = Unit.INSTANCE;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/RecyclablePool$Companion;", "", "()V", "TAG", "", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;", "", "()V", "isInPool", "", "()Z", "setInPool", "(Z)V", "next", "getNext", "()Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;", "setNext", "(Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable;)V", "changeNext", "", "nextObjext", "outPool", "reset", "Companion", "common_release"}, k=1, mv={1, 1, 15})
  public static class Recyclable
  {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "QAPM_common_RecyclablePool_Recyclable";
    private boolean isInPool;
    @Nullable
    private Recyclable next;
    
    public final void changeNext(@Nullable Recyclable paramRecyclable, boolean paramBoolean)
    {
      if ((this.isInPool) && (paramBoolean))
      {
        Logger.INSTANCE.d(new String[] { "QAPM_common_RecyclablePool_Recyclable", "changeNext " + paramRecyclable + ", " + paramBoolean });
        throw ((Throwable)new RuntimeException("conflict inPool and outPool"));
      }
      this.next = paramRecyclable;
    }
    
    @Nullable
    public final Recyclable getNext()
    {
      return this.next;
    }
    
    public final boolean isInPool()
    {
      return this.isInPool;
    }
    
    public void reset()
    {
      this.next = ((Recyclable)null);
    }
    
    public final void setInPool(boolean paramBoolean)
    {
      this.isInPool = paramBoolean;
    }
    
    public final void setNext(@Nullable Recyclable paramRecyclable)
    {
      this.next = paramRecyclable;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/RecyclablePool$Recyclable$Companion;", "", "()V", "TAG", "", "common_release"}, k=1, mv={1, 1, 15})
    public static final class Companion {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.RecyclablePool
 * JD-Core Version:    0.7.0.1
 */