package rx.internal.util.unsafe;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeAccess
{
  public static final Unsafe UNSAFE;
  
  static
  {
    try
    {
      Object localObject1 = Unsafe.class.getDeclaredField("theUnsafe");
      ((Field)localObject1).setAccessible(true);
      localObject1 = (Unsafe)((Field)localObject1).get(null);
      UNSAFE = (Unsafe)localObject1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  private UnsafeAccess()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static long addressOf(Class<?> paramClass, String paramString)
  {
    try
    {
      paramClass = paramClass.getDeclaredField(paramString);
      long l = UNSAFE.objectFieldOffset(paramClass);
      return l;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramString = new InternalError();
      paramString.initCause(paramClass);
      throw paramString;
    }
  }
  
  public static boolean compareAndSwapInt(Object paramObject, long paramLong, int paramInt1, int paramInt2)
  {
    return UNSAFE.compareAndSwapInt(paramObject, paramLong, paramInt1, paramInt2);
  }
  
  public static int getAndAddInt(Object paramObject, long paramLong, int paramInt)
  {
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, i + paramInt));
    return i;
  }
  
  public static int getAndIncrementInt(Object paramObject, long paramLong)
  {
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, i + 1));
    return i;
  }
  
  public static int getAndSetInt(Object paramObject, long paramLong, int paramInt)
  {
    int i;
    do
    {
      i = UNSAFE.getIntVolatile(paramObject, paramLong);
    } while (!UNSAFE.compareAndSwapInt(paramObject, paramLong, i, paramInt));
    return i;
  }
  
  public static boolean isUnsafeAvailable()
  {
    return UNSAFE != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rx.internal.util.unsafe.UnsafeAccess
 * JD-Core Version:    0.7.0.1
 */