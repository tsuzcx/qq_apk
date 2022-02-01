package com.tencent.token;

import com.tencent.turingfd.sdk.qps.break;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class aei
  extends aeh
{
  public static Class b;
  public final Object c = b();
  public final Field d = c();
  
  private static Object b()
  {
    try
    {
      Object localObject = Class.forName("sun.misc.Unsafe");
      b = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("theUnsafe");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  private static Field c()
  {
    try
    {
      Field localField = AccessibleObject.class.getDeclaredField("override");
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      label10:
      break label10;
    }
    return null;
  }
  
  public final void a(AccessibleObject paramAccessibleObject)
  {
    Object localObject = this.c;
    j = 0;
    i = j;
    if (localObject != null)
    {
      i = j;
      if (this.d == null) {}
    }
    try
    {
      localObject = b;
      long l = ((Long)((Class)localObject).getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(this.c, new Object[] { this.d })).longValue();
      localObject = b;
      ((Class)localObject).getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(this.c, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.TRUE });
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (i == 0) {
      try
      {
        paramAccessibleObject.setAccessible(true);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        StringBuilder localStringBuilder = new StringBuilder("Gson couldn't modify fields for ");
        localStringBuilder.append(paramAccessibleObject);
        localStringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
        throw new break(localStringBuilder.toString(), localSecurityException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aei
 * JD-Core Version:    0.7.0.1
 */