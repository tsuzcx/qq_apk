package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import javax.annotation.Nullable;

@GwtIncompatible
public final class Atomics
{
  public static <V> AtomicReference<V> newReference()
  {
    return new AtomicReference();
  }
  
  public static <V> AtomicReference<V> newReference(@Nullable V paramV)
  {
    return new AtomicReference(paramV);
  }
  
  public static <E> AtomicReferenceArray<E> newReferenceArray(int paramInt)
  {
    return new AtomicReferenceArray(paramInt);
  }
  
  public static <E> AtomicReferenceArray<E> newReferenceArray(E[] paramArrayOfE)
  {
    return new AtomicReferenceArray(paramArrayOfE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.util.concurrent.Atomics
 * JD-Core Version:    0.7.0.1
 */