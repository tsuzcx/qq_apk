package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

@Beta
@GwtIncompatible
public abstract class Striped<L>
{
  private static final int ALL_SET = -1;
  private static final int LARGE_LAZY_CUTOFF = 1024;
  private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Striped.5();
  
  private static int ceilToPowerOfTwo(int paramInt)
  {
    return 1 << IntMath.log2(paramInt, RoundingMode.CEILING);
  }
  
  private static <L> Striped<L> lazy(int paramInt, Supplier<L> paramSupplier)
  {
    if (paramInt < 1024) {
      return new SmallLazyStriped(paramInt, paramSupplier);
    }
    return new LargeLazyStriped(paramInt, paramSupplier);
  }
  
  public static Striped<Lock> lazyWeakLock(int paramInt)
  {
    return lazy(paramInt, new Striped.2());
  }
  
  public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int paramInt)
  {
    return lazy(paramInt, READ_WRITE_LOCK_SUPPLIER);
  }
  
  public static Striped<Semaphore> lazyWeakSemaphore(int paramInt1, int paramInt2)
  {
    return lazy(paramInt1, new Striped.4(paramInt2));
  }
  
  public static Striped<Lock> lock(int paramInt)
  {
    return new CompactStriped(paramInt, new Striped.1(), null);
  }
  
  public static Striped<ReadWriteLock> readWriteLock(int paramInt)
  {
    return new CompactStriped(paramInt, READ_WRITE_LOCK_SUPPLIER, null);
  }
  
  public static Striped<Semaphore> semaphore(int paramInt1, int paramInt2)
  {
    return new CompactStriped(paramInt1, new Striped.3(paramInt2), null);
  }
  
  private static int smear(int paramInt)
  {
    paramInt = paramInt >>> 20 ^ paramInt >>> 12 ^ paramInt;
    return paramInt >>> 4 ^ paramInt >>> 7 ^ paramInt;
  }
  
  public Iterable<L> bulkGet(Iterable<?> paramIterable)
  {
    paramIterable = Iterables.toArray(paramIterable, Object.class);
    if (paramIterable.length == 0) {
      return ImmutableList.of();
    }
    int[] arrayOfInt = new int[paramIterable.length];
    int i = 0;
    while (i < paramIterable.length)
    {
      arrayOfInt[i] = indexFor(paramIterable[i]);
      i += 1;
    }
    Arrays.sort(arrayOfInt);
    int j = arrayOfInt[0];
    paramIterable[0] = getAt(j);
    i = 1;
    if (i < paramIterable.length)
    {
      int k = arrayOfInt[i];
      if (k == j) {
        paramIterable[i] = paramIterable[(i - 1)];
      }
      for (;;)
      {
        i += 1;
        break;
        paramIterable[i] = getAt(k);
        j = k;
      }
    }
    return Collections.unmodifiableList(Arrays.asList(paramIterable));
  }
  
  public abstract L get(Object paramObject);
  
  public abstract L getAt(int paramInt);
  
  abstract int indexFor(Object paramObject);
  
  public abstract int size();
  
  static class CompactStriped<L>
    extends Striped.PowerOfTwoStriped<L>
  {
    private final Object[] array;
    
    private CompactStriped(int paramInt, Supplier<L> paramSupplier)
    {
      super();
      if (paramInt <= 1073741824) {}
      for (boolean bool = true;; bool = false)
      {
        Preconditions.checkArgument(bool, "Stripes must be <= 2^30)");
        this.array = new Object[this.mask + 1];
        paramInt = i;
        while (paramInt < this.array.length)
        {
          this.array[paramInt] = paramSupplier.get();
          paramInt += 1;
        }
      }
    }
    
    public L getAt(int paramInt)
    {
      return this.array[paramInt];
    }
    
    public int size()
    {
      return this.array.length;
    }
  }
  
  @VisibleForTesting
  static class LargeLazyStriped<L>
    extends Striped.PowerOfTwoStriped<L>
  {
    final ConcurrentMap<Integer, L> locks;
    final int size;
    final Supplier<L> supplier;
    
    LargeLazyStriped(int paramInt, Supplier<L> paramSupplier)
    {
      super();
      if (this.mask == -1) {}
      for (paramInt = 2147483647;; paramInt = this.mask + 1)
      {
        this.size = paramInt;
        this.supplier = paramSupplier;
        this.locks = new MapMaker().weakValues().makeMap();
        return;
      }
    }
    
    public L getAt(int paramInt)
    {
      if (this.size != 2147483647) {
        Preconditions.checkElementIndex(paramInt, size());
      }
      Object localObject = this.locks.get(Integer.valueOf(paramInt));
      if (localObject != null) {
        return localObject;
      }
      localObject = this.supplier.get();
      return MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(paramInt), localObject), localObject);
    }
    
    public int size()
    {
      return this.size;
    }
  }
  
  static class PaddedLock
    extends ReentrantLock
  {
    long unused1;
    long unused2;
    long unused3;
    
    PaddedLock()
    {
      super();
    }
  }
  
  static class PaddedSemaphore
    extends Semaphore
  {
    long unused1;
    long unused2;
    long unused3;
    
    PaddedSemaphore(int paramInt)
    {
      super(false);
    }
  }
  
  static abstract class PowerOfTwoStriped<L>
    extends Striped<L>
  {
    final int mask;
    
    PowerOfTwoStriped(int paramInt)
    {
      super();
      boolean bool;
      if (paramInt > 0)
      {
        bool = true;
        Preconditions.checkArgument(bool, "Stripes must be positive");
        if (paramInt <= 1073741824) {
          break label36;
        }
      }
      label36:
      for (paramInt = -1;; paramInt = Striped.ceilToPowerOfTwo(paramInt) - 1)
      {
        this.mask = paramInt;
        return;
        bool = false;
        break;
      }
    }
    
    public final L get(Object paramObject)
    {
      return getAt(indexFor(paramObject));
    }
    
    final int indexFor(Object paramObject)
    {
      return Striped.smear(paramObject.hashCode()) & this.mask;
    }
  }
  
  @VisibleForTesting
  static class SmallLazyStriped<L>
    extends Striped.PowerOfTwoStriped<L>
  {
    final AtomicReferenceArray<ArrayReference<? extends L>> locks;
    final ReferenceQueue<L> queue = new ReferenceQueue();
    final int size;
    final Supplier<L> supplier;
    
    SmallLazyStriped(int paramInt, Supplier<L> paramSupplier)
    {
      super();
      if (this.mask == -1) {}
      for (paramInt = 2147483647;; paramInt = this.mask + 1)
      {
        this.size = paramInt;
        this.locks = new AtomicReferenceArray(this.size);
        this.supplier = paramSupplier;
        return;
      }
    }
    
    private void drainQueue()
    {
      for (;;)
      {
        Object localObject = this.queue.poll();
        if (localObject == null) {
          break;
        }
        localObject = (ArrayReference)localObject;
        this.locks.compareAndSet(((ArrayReference)localObject).index, localObject, null);
      }
    }
    
    public L getAt(int paramInt)
    {
      if (this.size != 2147483647) {
        Preconditions.checkElementIndex(paramInt, size());
      }
      ArrayReference localArrayReference1 = (ArrayReference)this.locks.get(paramInt);
      if (localArrayReference1 == null) {}
      for (Object localObject1 = null; localObject1 != null; localObject1 = localArrayReference1.get()) {
        return localObject1;
      }
      Object localObject2 = this.supplier.get();
      ArrayReference localArrayReference2 = new ArrayReference(localObject2, paramInt, this.queue);
      while (!this.locks.compareAndSet(paramInt, localArrayReference1, localArrayReference2))
      {
        localArrayReference1 = (ArrayReference)this.locks.get(paramInt);
        if (localArrayReference1 == null) {}
        for (localObject1 = null; localObject1 != null; localObject1 = localArrayReference1.get()) {
          return localObject1;
        }
      }
      drainQueue();
      return localObject2;
    }
    
    public int size()
    {
      return this.size;
    }
    
    static final class ArrayReference<L>
      extends WeakReference<L>
    {
      final int index;
      
      ArrayReference(L paramL, int paramInt, ReferenceQueue<L> paramReferenceQueue)
      {
        super(paramReferenceQueue);
        this.index = paramInt;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Striped
 * JD-Core Version:    0.7.0.1
 */