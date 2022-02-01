package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true, serializable=true)
final class RegularImmutableSet<E>
  extends ImmutableSet.Indexed<E>
{
  static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet(ObjectArrays.EMPTY_ARRAY, 0, null, 0);
  private final transient Object[] elements;
  private final transient int hashCode;
  private final transient int mask;
  @VisibleForTesting
  final transient Object[] table;
  
  RegularImmutableSet(Object[] paramArrayOfObject1, int paramInt1, Object[] paramArrayOfObject2, int paramInt2)
  {
    this.elements = paramArrayOfObject1;
    this.table = paramArrayOfObject2;
    this.mask = paramInt2;
    this.hashCode = paramInt1;
  }
  
  public boolean contains(@Nullable Object paramObject)
  {
    Object[] arrayOfObject = this.table;
    if ((paramObject == null) || (arrayOfObject == null)) {
      return false;
    }
    int i = Hashing.smearedHash(paramObject);
    for (;;)
    {
      i &= this.mask;
      Object localObject = arrayOfObject[i];
      if (localObject == null) {
        return false;
      }
      if (localObject.equals(paramObject)) {
        return true;
      }
      i += 1;
    }
  }
  
  int copyIntoArray(Object[] paramArrayOfObject, int paramInt)
  {
    System.arraycopy(this.elements, 0, paramArrayOfObject, paramInt, this.elements.length);
    return this.elements.length + paramInt;
  }
  
  ImmutableList<E> createAsList()
  {
    if (this.table == null) {
      return ImmutableList.of();
    }
    return new RegularImmutableAsList(this, this.elements);
  }
  
  E get(int paramInt)
  {
    return this.elements[paramInt];
  }
  
  public int hashCode()
  {
    return this.hashCode;
  }
  
  boolean isHashCodeFast()
  {
    return true;
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public int size()
  {
    return this.elements.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.collect.RegularImmutableSet
 * JD-Core Version:    0.7.0.1
 */