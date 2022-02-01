package com.google.common.primitives;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

final class UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1
  implements PrivilegedExceptionAction<Unsafe>
{
  public Unsafe run()
    throws Exception
  {
    Field[] arrayOfField = Unsafe.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfField[i];
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      if (Unsafe.class.isInstance(localObject)) {
        return (Unsafe)Unsafe.class.cast(localObject);
      }
      i += 1;
    }
    throw new NoSuchFieldError("the Unsafe");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.common.primitives.UnsignedBytes.LexicographicalComparatorHolder.UnsafeComparator.1
 * JD-Core Version:    0.7.0.1
 */