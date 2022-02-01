package rx.internal.util;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

public final class IndexedRingBuffer<E>
  implements Subscription
{
  private static final ObjectPool<IndexedRingBuffer<?>> POOL = new IndexedRingBuffer.1();
  static final int SIZE;
  static int _size = 256;
  private final ElementSection<E> elements = new ElementSection();
  final AtomicInteger index = new AtomicInteger();
  private final IndexSection removed = new IndexSection();
  final AtomicInteger removedIndex = new AtomicInteger();
  
  static
  {
    if (PlatformDependent.isAndroid()) {
      _size = 8;
    }
    String str = System.getProperty("rx.indexed-ring-buffer.size");
    if (str != null) {}
    try
    {
      _size = Integer.parseInt(str);
      SIZE = _size;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        System.err.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + str + " => " + localException.getMessage());
      }
    }
  }
  
  private int forEach(Func1<? super E, Boolean> paramFunc1, int paramInt1, int paramInt2)
  {
    int k = this.index.get();
    ElementSection localElementSection = this.elements;
    int i;
    int j;
    if (paramInt1 >= SIZE)
    {
      localElementSection = getElementSection(paramInt1);
      i = SIZE;
      j = paramInt1 % i;
      i = paramInt1;
      paramInt1 = j;
    }
    for (;;)
    {
      if (localElementSection != null)
      {
        j = paramInt1;
        paramInt1 = i;
        if (j < SIZE)
        {
          if ((paramInt1 >= k) || (paramInt1 >= paramInt2)) {
            return paramInt1;
          }
          Object localObject = localElementSection.array.get(j);
          if (localObject == null) {}
          while (((Boolean)paramFunc1.call(localObject)).booleanValue())
          {
            paramInt1 += 1;
            j += 1;
            break;
          }
          return paramInt1;
        }
        localElementSection = (ElementSection)localElementSection.next.get();
        i = paramInt1;
        paramInt1 = 0;
      }
      else
      {
        return i;
        i = paramInt1;
      }
    }
  }
  
  private ElementSection<E> getElementSection(int paramInt)
  {
    Object localObject;
    if (paramInt < SIZE)
    {
      localObject = this.elements;
      return localObject;
    }
    int i = paramInt / SIZE;
    ElementSection localElementSection = this.elements;
    paramInt = 0;
    for (;;)
    {
      localObject = localElementSection;
      if (paramInt >= i) {
        break;
      }
      localElementSection = localElementSection.getNext();
      paramInt += 1;
    }
  }
  
  /* Error */
  private int getIndexForAdd()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 155	rx/internal/util/IndexedRingBuffer:getIndexFromPreviouslyRemoved	()I
    //   6: istore_1
    //   7: iload_1
    //   8: iflt +67 -> 75
    //   11: iload_1
    //   12: getstatic 62	rx/internal/util/IndexedRingBuffer:SIZE	I
    //   15: if_icmpge +40 -> 55
    //   18: aload_0
    //   19: getfield 98	rx/internal/util/IndexedRingBuffer:removed	Lrx/internal/util/IndexedRingBuffer$IndexSection;
    //   22: iload_1
    //   23: iconst_m1
    //   24: invokevirtual 159	rx/internal/util/IndexedRingBuffer$IndexSection:getAndSet	(II)I
    //   27: istore_1
    //   28: iload_1
    //   29: istore_2
    //   30: iload_1
    //   31: aload_0
    //   32: getfield 103	rx/internal/util/IndexedRingBuffer:index	Ljava/util/concurrent/atomic/AtomicInteger;
    //   35: invokevirtual 111	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   38: if_icmpne +13 -> 51
    //   41: aload_0
    //   42: getfield 103	rx/internal/util/IndexedRingBuffer:index	Ljava/util/concurrent/atomic/AtomicInteger;
    //   45: invokevirtual 162	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   48: pop
    //   49: iload_1
    //   50: istore_2
    //   51: aload_0
    //   52: monitorexit
    //   53: iload_2
    //   54: ireturn
    //   55: getstatic 62	rx/internal/util/IndexedRingBuffer:SIZE	I
    //   58: istore_2
    //   59: aload_0
    //   60: iload_1
    //   61: invokespecial 166	rx/internal/util/IndexedRingBuffer:getIndexSection	(I)Lrx/internal/util/IndexedRingBuffer$IndexSection;
    //   64: iload_1
    //   65: iload_2
    //   66: irem
    //   67: iconst_m1
    //   68: invokevirtual 159	rx/internal/util/IndexedRingBuffer$IndexSection:getAndSet	(II)I
    //   71: istore_1
    //   72: goto -44 -> 28
    //   75: aload_0
    //   76: getfield 103	rx/internal/util/IndexedRingBuffer:index	Ljava/util/concurrent/atomic/AtomicInteger;
    //   79: invokevirtual 162	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   82: istore_2
    //   83: goto -32 -> 51
    //   86: astore_3
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_3
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	IndexedRingBuffer
    //   6	66	1	i	int
    //   29	54	2	j	int
    //   86	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	86	finally
    //   11	28	86	finally
    //   30	49	86	finally
    //   55	72	86	finally
    //   75	83	86	finally
  }
  
  /* Error */
  private int getIndexFromPreviouslyRemoved()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 105	rx/internal/util/IndexedRingBuffer:removedIndex	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 111	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: istore_1
    //   10: iload_1
    //   11: ifle +27 -> 38
    //   14: aload_0
    //   15: getfield 105	rx/internal/util/IndexedRingBuffer:removedIndex	Ljava/util/concurrent/atomic/AtomicInteger;
    //   18: iload_1
    //   19: iload_1
    //   20: iconst_1
    //   21: isub
    //   22: invokevirtual 170	java/util/concurrent/atomic/AtomicInteger:compareAndSet	(II)Z
    //   25: istore_2
    //   26: iload_2
    //   27: ifeq -25 -> 2
    //   30: iload_1
    //   31: iconst_1
    //   32: isub
    //   33: istore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: iload_1
    //   37: ireturn
    //   38: iconst_m1
    //   39: istore_1
    //   40: goto -6 -> 34
    //   43: astore_3
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_3
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	IndexedRingBuffer
    //   9	31	1	i	int
    //   25	2	2	bool	boolean
    //   43	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	43	finally
    //   14	26	43	finally
  }
  
  private IndexSection getIndexSection(int paramInt)
  {
    Object localObject;
    if (paramInt < SIZE)
    {
      localObject = this.removed;
      return localObject;
    }
    int i = paramInt / SIZE;
    IndexSection localIndexSection = this.removed;
    paramInt = 0;
    for (;;)
    {
      localObject = localIndexSection;
      if (paramInt >= i) {
        break;
      }
      localIndexSection = localIndexSection.getNext();
      paramInt += 1;
    }
  }
  
  public static <T> IndexedRingBuffer<T> getInstance()
  {
    return (IndexedRingBuffer)POOL.borrowObject();
  }
  
  /* Error */
  private void pushRemovedIndex(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 105	rx/internal/util/IndexedRingBuffer:removedIndex	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 162	java/util/concurrent/atomic/AtomicInteger:getAndIncrement	()I
    //   9: istore_2
    //   10: iload_2
    //   11: getstatic 62	rx/internal/util/IndexedRingBuffer:SIZE	I
    //   14: if_icmpge +15 -> 29
    //   17: aload_0
    //   18: getfield 98	rx/internal/util/IndexedRingBuffer:removed	Lrx/internal/util/IndexedRingBuffer$IndexSection;
    //   21: iload_2
    //   22: iload_1
    //   23: invokevirtual 187	rx/internal/util/IndexedRingBuffer$IndexSection:set	(II)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: getstatic 62	rx/internal/util/IndexedRingBuffer:SIZE	I
    //   32: istore_3
    //   33: aload_0
    //   34: iload_2
    //   35: invokespecial 166	rx/internal/util/IndexedRingBuffer:getIndexSection	(I)Lrx/internal/util/IndexedRingBuffer$IndexSection;
    //   38: iload_2
    //   39: iload_3
    //   40: irem
    //   41: iload_1
    //   42: invokevirtual 187	rx/internal/util/IndexedRingBuffer$IndexSection:set	(II)V
    //   45: goto -19 -> 26
    //   48: astore 4
    //   50: aload_0
    //   51: monitorexit
    //   52: aload 4
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	IndexedRingBuffer
    //   0	55	1	paramInt	int
    //   9	32	2	i	int
    //   32	9	3	j	int
    //   48	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	48	finally
    //   29	45	48	finally
  }
  
  public int add(E paramE)
  {
    int i = getIndexForAdd();
    if (i < SIZE)
    {
      this.elements.array.set(i, paramE);
      return i;
    }
    int j = SIZE;
    getElementSection(i).array.set(i % j, paramE);
    return i;
  }
  
  public int forEach(Func1<? super E, Boolean> paramFunc1)
  {
    return forEach(paramFunc1, 0);
  }
  
  public int forEach(Func1<? super E, Boolean> paramFunc1, int paramInt)
  {
    int i = 0;
    int j = forEach(paramFunc1, paramInt, this.index.get());
    if ((paramInt > 0) && (j == this.index.get())) {
      paramInt = forEach(paramFunc1, 0, paramInt);
    }
    do
    {
      return paramInt;
      paramInt = i;
    } while (j == this.index.get());
    return j;
  }
  
  public boolean isUnsubscribed()
  {
    return false;
  }
  
  public void releaseToPool()
  {
    int k = this.index.get();
    ElementSection localElementSection = this.elements;
    int i = 0;
    for (;;)
    {
      int j;
      if (localElementSection != null) {
        j = 0;
      }
      while (j < SIZE)
      {
        if (i >= k)
        {
          this.index.set(0);
          this.removedIndex.set(0);
          POOL.returnObject(this);
          return;
        }
        localElementSection.array.set(j, null);
        j += 1;
        i += 1;
      }
      localElementSection = (ElementSection)localElementSection.next.get();
    }
  }
  
  public E remove(int paramInt)
  {
    if (paramInt < SIZE) {}
    int i;
    for (Object localObject = this.elements.array.getAndSet(paramInt, null);; localObject = getElementSection(paramInt).array.getAndSet(paramInt % i, null))
    {
      pushRemovedIndex(paramInt);
      return localObject;
      i = SIZE;
    }
  }
  
  public void unsubscribe()
  {
    releaseToPool();
  }
  
  static class ElementSection<E>
  {
    final AtomicReferenceArray<E> array = new AtomicReferenceArray(IndexedRingBuffer.SIZE);
    final AtomicReference<ElementSection<E>> next = new AtomicReference();
    
    ElementSection<E> getNext()
    {
      Object localObject;
      if (this.next.get() != null) {
        localObject = (ElementSection)this.next.get();
      }
      ElementSection localElementSection;
      do
      {
        return localObject;
        localElementSection = new ElementSection();
        localObject = localElementSection;
      } while (this.next.compareAndSet(null, localElementSection));
      return (ElementSection)this.next.get();
    }
  }
  
  static class IndexSection
  {
    private final AtomicReference<IndexSection> _next = new AtomicReference();
    private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);
    
    public int getAndSet(int paramInt1, int paramInt2)
    {
      return this.unsafeArray.getAndSet(paramInt1, paramInt2);
    }
    
    IndexSection getNext()
    {
      Object localObject;
      if (this._next.get() != null) {
        localObject = (IndexSection)this._next.get();
      }
      IndexSection localIndexSection;
      do
      {
        return localObject;
        localIndexSection = new IndexSection();
        localObject = localIndexSection;
      } while (this._next.compareAndSet(null, localIndexSection));
      return (IndexSection)this._next.get();
    }
    
    public void set(int paramInt1, int paramInt2)
    {
      this.unsafeArray.set(paramInt1, paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.util.IndexedRingBuffer
 * JD-Core Version:    0.7.0.1
 */