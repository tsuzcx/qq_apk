package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible(emulated=true)
final class LongAddables
{
  private static final Supplier<LongAddable> SUPPLIER;
  
  static
  {
    try
    {
      new LongAdder();
      LongAddables.1 local1 = new LongAddables.1();
      SUPPLIER = local1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LongAddables.2 local2 = new LongAddables.2();
      }
    }
  }
  
  public static LongAddable create()
  {
    return (LongAddable)SUPPLIER.get();
  }
  
  static final class PureJavaLongAddable
    extends AtomicLong
    implements LongAddable
  {
    public void add(long paramLong)
    {
      getAndAdd(paramLong);
    }
    
    public void increment()
    {
      getAndIncrement();
    }
    
    public long sum()
    {
      return get();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.cache.LongAddables
 * JD-Core Version:    0.7.0.1
 */