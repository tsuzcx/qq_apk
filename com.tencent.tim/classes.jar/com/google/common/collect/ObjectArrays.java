package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
public final class ObjectArrays
{
  static final Object[] EMPTY_ARRAY = new Object[0];
  
  static <T> T[] arraysCopyOf(T[] paramArrayOfT, int paramInt)
  {
    Object[] arrayOfObject = newArray(paramArrayOfT, paramInt);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, Math.min(paramArrayOfT.length, paramInt));
    return arrayOfObject;
  }
  
  @CanIgnoreReturnValue
  static Object checkElementNotNull(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      throw new NullPointerException("at index " + paramInt);
    }
    return paramObject;
  }
  
  @CanIgnoreReturnValue
  static Object[] checkElementsNotNull(Object... paramVarArgs)
  {
    return checkElementsNotNull(paramVarArgs, paramVarArgs.length);
  }
  
  @CanIgnoreReturnValue
  static Object[] checkElementsNotNull(Object[] paramArrayOfObject, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      checkElementNotNull(paramArrayOfObject[i], i);
      i += 1;
    }
    return paramArrayOfObject;
  }
  
  public static <T> T[] concat(@Nullable T paramT, T[] paramArrayOfT)
  {
    Object[] arrayOfObject = newArray(paramArrayOfT, paramArrayOfT.length + 1);
    arrayOfObject[0] = paramT;
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 1, paramArrayOfT.length);
    return arrayOfObject;
  }
  
  public static <T> T[] concat(T[] paramArrayOfT, @Nullable T paramT)
  {
    Object[] arrayOfObject = arraysCopyOf(paramArrayOfT, paramArrayOfT.length + 1);
    arrayOfObject[paramArrayOfT.length] = paramT;
    return arrayOfObject;
  }
  
  @GwtIncompatible
  public static <T> T[] concat(T[] paramArrayOfT1, T[] paramArrayOfT2, Class<T> paramClass)
  {
    paramClass = newArray(paramClass, paramArrayOfT1.length + paramArrayOfT2.length);
    System.arraycopy(paramArrayOfT1, 0, paramClass, 0, paramArrayOfT1.length);
    System.arraycopy(paramArrayOfT2, 0, paramClass, paramArrayOfT1.length, paramArrayOfT2.length);
    return paramClass;
  }
  
  static Object[] copyAsObjectArray(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    if (paramInt2 == 0) {
      return EMPTY_ARRAY;
    }
    Object[] arrayOfObject = new Object[paramInt2];
    System.arraycopy(paramArrayOfObject, paramInt1, arrayOfObject, 0, paramInt2);
    return arrayOfObject;
  }
  
  @CanIgnoreReturnValue
  private static Object[] fillArray(Iterable<?> paramIterable, Object[] paramArrayOfObject)
  {
    int i = 0;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      paramArrayOfObject[i] = paramIterable.next();
      i += 1;
    }
    return paramArrayOfObject;
  }
  
  @GwtIncompatible
  public static <T> T[] newArray(Class<T> paramClass, int paramInt)
  {
    return (Object[])Array.newInstance(paramClass, paramInt);
  }
  
  public static <T> T[] newArray(T[] paramArrayOfT, int paramInt)
  {
    return Platform.newArray(paramArrayOfT, paramInt);
  }
  
  static void swap(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    Object localObject = paramArrayOfObject[paramInt1];
    paramArrayOfObject[paramInt1] = paramArrayOfObject[paramInt2];
    paramArrayOfObject[paramInt2] = localObject;
  }
  
  static Object[] toArrayImpl(Collection<?> paramCollection)
  {
    return fillArray(paramCollection, new Object[paramCollection.size()]);
  }
  
  static <T> T[] toArrayImpl(Collection<?> paramCollection, T[] paramArrayOfT)
  {
    int i = paramCollection.size();
    Object localObject = paramArrayOfT;
    if (paramArrayOfT.length < i) {
      localObject = newArray(paramArrayOfT, i);
    }
    fillArray(paramCollection, (Object[])localObject);
    if (localObject.length > i) {
      localObject[i] = null;
    }
    return localObject;
  }
  
  static <T> T[] toArrayImpl(Object[] paramArrayOfObject, int paramInt1, int paramInt2, T[] paramArrayOfT)
  {
    Preconditions.checkPositionIndexes(paramInt1, paramInt1 + paramInt2, paramArrayOfObject.length);
    Object localObject;
    if (paramArrayOfT.length < paramInt2) {
      localObject = newArray(paramArrayOfT, paramInt2);
    }
    for (;;)
    {
      System.arraycopy(paramArrayOfObject, paramInt1, localObject, 0, paramInt2);
      return localObject;
      localObject = paramArrayOfT;
      if (paramArrayOfT.length > paramInt2)
      {
        paramArrayOfT[paramInt2] = null;
        localObject = paramArrayOfT;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.ObjectArrays
 * JD-Core Version:    0.7.0.1
 */