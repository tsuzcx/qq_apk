package moai.io;

import android.util.Log;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;

public class ThreadBuffer<T>
  extends ThreadLocal<SoftReference<T>>
{
  private static final String TAG = "ThreadBuffer";
  private int capacity;
  private final int initCapacity;
  private final Class type;
  
  public ThreadBuffer(Class paramClass, int paramInt)
  {
    this.capacity = paramInt;
    this.initCapacity = paramInt;
    this.type = paramClass;
  }
  
  public static ThreadBuffer<byte[]> bytes(int paramInt)
  {
    return new ThreadBuffer(Byte.TYPE, paramInt);
  }
  
  public static ThreadBuffer<char[]> chars(int paramInt)
  {
    return new ThreadBuffer(Character.TYPE, paramInt);
  }
  
  public static ThreadBuffer<int[]> ints(int paramInt)
  {
    return new ThreadBuffer(Integer.TYPE, paramInt);
  }
  
  public T array()
  {
    Object localObject2 = ((SoftReference)get()).get();
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      Log.d("ThreadBuffer", "garbage collected, realloc one.");
      set(initialValue());
      localObject1 = array();
    }
    return localObject1;
  }
  
  public T array(int paramInt)
  {
    Object localObject2 = ((SoftReference)get()).get();
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (isEnough(localObject2, paramInt)) {}
    }
    else
    {
      if (localObject2 != null) {
        break label68;
      }
      Log.d("ThreadBuffer", "garbage collected, realloc one.");
    }
    for (;;)
    {
      setCapacity(Math.max(this.initCapacity, paramInt * 2));
      set(initialValue());
      localObject1 = array(paramInt);
      return localObject1;
      label68:
      Log.d("ThreadBuffer", "expanding buffer from " + Array.getLength(localObject2) + " to " + paramInt + ".");
    }
  }
  
  protected T create(int paramInt)
  {
    return Array.newInstance(this.type, paramInt);
  }
  
  protected SoftReference<T> initialValue()
  {
    return new SoftReference(create(this.capacity));
  }
  
  protected boolean isEnough(T paramT, int paramInt)
  {
    return Array.getLength(paramT) > paramInt;
  }
  
  protected void setCapacity(int paramInt)
  {
    this.capacity = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.io.ThreadBuffer
 * JD-Core Version:    0.7.0.1
 */